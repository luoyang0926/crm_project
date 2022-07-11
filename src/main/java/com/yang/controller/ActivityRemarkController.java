package com.yang.controller;

import com.yang.commons.contants.Contants;
import com.yang.commons.pojo.ReturnObject;
import com.yang.commons.utils.DateUtils;
import com.yang.commons.utils.UUIDUtils;
import com.yang.pojo.ActivityRemark;
import com.yang.pojo.User;
import com.yang.service.ActivityRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ActivityRemarkController {
    @Autowired
    private ActivityRemarkService activityRemarkService;

    @ResponseBody
    @RequestMapping("workbench/activity/detils.do")
    public Object activityRemark(ActivityRemark activityRemark, HttpSession session) {
        activityRemark.setId(UUIDUtils.getUUID());
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        activityRemark.setCreateBy(user.getId());
        activityRemark.setCreateTime(DateUtils.formateDateTime(new Date()));
        activityRemark.setEditFlag(Contants.EDIT_FLAG_FAIL);
        ReturnObject returnObject=new ReturnObject();
        try {
            int i = activityRemarkService.insertActivityRemark(activityRemark);

            if (i > 0) {
                   returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                   returnObject.setRetData(activityRemark);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙 请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙 请稍后重试...");
        }
        return  returnObject;
    }

    @ResponseBody
    @RequestMapping("/workbench/activity/deleteActivityRemark.do")
    public Object deleteActivityRemark(String id) {
        int i = activityRemarkService.deleteActivityRemarkById(id);
        ReturnObject returnObject=new ReturnObject();
        try {
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("删除失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }
return  returnObject;
    }

    /**
     * 修改备注
     */
    @ResponseBody
    @RequestMapping("/workbench/activity/updateActivityRemark.do")
    public Object updateActivityRemark(ActivityRemark activityRemark,HttpSession session) {
        activityRemark.setEditTime(DateUtils.formateDateTime(new Date()));
        User user =(User) session.getAttribute(Contants.SESSION_USER);
        activityRemark.setEditBy(user.getId());
        activityRemark.setEditFlag(Contants.EDIT_FLAG_SUCCESS);
        int i = activityRemarkService.updateActivityRemark(activityRemark);
        ReturnObject returnObject=new ReturnObject();
        try {
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setRetData(activityRemark);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("更新失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("更新失败");
        }
        return returnObject;
    }
}
