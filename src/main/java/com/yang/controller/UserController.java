package com.yang.controller;

import com.yang.commons.contants.Contants;
import com.yang.commons.pojo.ReturnObject;
import com.yang.commons.utils.DateUtils;
import com.yang.pojo.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.ws.model.RuntimeModeler.RETURN;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin() {
        return "settings/qx/user/login";
    }

    /**
     * 登录
     * @param loginAct
     * @param loginPwd
     * @param isRemPwd
     * @param request
     * @param response
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/settings/qx/user/login.do")
    public Object Login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
       //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        User user = userService.LoginByNameAndPwd(map);
        //根据查询结果，响应信息
        ReturnObject returnObject=new ReturnObject();
        if (user == null) {
            //失败
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");

        } else {
            //判断账号是否过期
            String sdfNow = DateUtils.formateDateTime(new Date());
            if (sdfNow.compareTo(user.getExpireTime()) > 0) {
                //登录失败，账号已过期
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号已过期");

            } else if ("0".equals(user.getLockState())) {
                //  0 登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("状态被锁定");

            } else if (!user.getAllowIps().contains(request.getRemoteAddr())) {
                //失败 ip受限
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("ip受限");
            } else {
                //成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                //将用户放入域对象中
                session.setAttribute(Contants.SESSION_USER, user);
                //如果需要记住密码,则向外写cookie
                if ("true".equals(isRemPwd)) {
                    Cookie c1 = new Cookie("loginAct", user.getLoginAct());
                    c1.setMaxAge(10 * 24 * 60 * 60);
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("loginPwd", user.getLoginPwd());
                    c2.setMaxAge(10 * 24 * 60 * 60);
                    response.addCookie(c2);
                } else {
                    //删除没有过期的cookie
                    Cookie c1 = new Cookie("loginAct", user.getLoginAct());
                    c1.setMaxAge(0);
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("loginPwd", user.getLoginPwd());
                    c2.setMaxAge(0);
                    response.addCookie(c2);

                }

            }

        }
        return returnObject;
    }

    /**
     * 用户退出到首页
     */

    @RequestMapping("/settings/qx/user/exit.do")
    public String exit(HttpServletResponse response,HttpSession session ) {

        //删除没有过期的cookie
        Cookie c1 = new Cookie("loginAct", "1");
        c1.setMaxAge(0);
        response.addCookie(c1);
        Cookie c2 = new Cookie("loginPwd", "1");
        c2.setMaxAge(0);
        response.addCookie(c2);
        //销毁session
        session.invalidate();


        return "settings/qx/user/login";
    }

    //修改密码
    @ResponseBody
    @RequestMapping("/settings/qx/user/updateUserPwd.do")
    public Object updateUserPwd(String oldPwd,String newPwd,HttpSession session) {
        User user =(User) session.getAttribute(Contants.SESSION_USER);
        String id=user.getId();
        String loginPwd=user.getLoginPwd();
        ReturnObject returnObject = new ReturnObject();
        if (oldPwd.equals(loginPwd)) {
            try{
                int i = userService.updateUserPwd(newPwd,id);
                if (i > 0) {
                    returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                    returnObject.setMessage("修改成功");

                }else {
                    returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                    returnObject.setMessage("修改失败");

                }

            } catch (Exception e) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("修改失败");

            }
        }else{
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("旧密码错误");


        }

        return returnObject;
    }
}
