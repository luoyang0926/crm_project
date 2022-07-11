package com.yang.controller;

import com.yang.commons.contants.Contants;
import com.yang.commons.pojo.ReturnObject;
import com.yang.commons.utils.DateUtils;
import com.yang.commons.utils.UUIDUtils;
import com.yang.pojo.*;
import com.yang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DicController {
    @Autowired
    private UserService userService;
    @Autowired
    private DicValueService dicValueService;
    @Autowired
    private ClueService clueService;
    @Autowired
    private ClueRemarkService clueRemarkService;
    @Autowired
    private ActivityService activityService;
    @RequestMapping("workbench/clue/index.do")
    public String index(HttpServletRequest request) {
        List<User> userList = userService.selectAllUsers();
        List<DicValue> applicationList = dicValueService.selectDicValueByTypeCode("appellation");
        List<DicValue> clueStateList = dicValueService.selectDicValueByTypeCode("clueState");
        List<DicValue> sourceList = dicValueService.selectDicValueByTypeCode("source");

        request.setAttribute("applicationList",applicationList);
        request.setAttribute("clueStateList",clueStateList);
        request.setAttribute("sourceList",sourceList);
        request.setAttribute("userList",userList);

        return "workbench/clue/index";
    }

    /**
     * 保存线索
     */

    @ResponseBody
    @RequestMapping("/workbench/activity/insertClue.do")
    public Object insertClue(Clue clue, HttpSession session) {
        clue.setId(UUIDUtils.getUUID());
        clue.setCreateTime(DateUtils.formateDateTime(new Date()));
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        clue.setCreateBy(user.getId());
        ReturnObject returnObject=new ReturnObject();
        try {
            int i = clueService.insertClue(clue);
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);

            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("添加失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/detailClue.do")
    public String detailClue(String id,HttpServletRequest request) {
        Clue clue = clueService.selectClueForDetailById(id);
        List<ClueRemark> clueRemarksList = clueRemarkService.selectClueRemarkByClueId(id);
        List<Activity> activityList = activityService.selectActivityForDetailByClueId(id);
        request.setAttribute("clue",clue);
        request.setAttribute("remarkList",clueRemarksList);
        request.setAttribute("activityList",activityList);

        return "workbench/clue/detail";
    }

    @ResponseBody
    @RequestMapping("/workbench/clue/detail.do")
    public Object selectActivityForDetailByNameClueId(String activityName,String clueId) {
        Map<String, Object> map = new HashMap<>();
        map.put("activityName", activityName);
        map.put("clueId", clueId);
        List<Activity> activityList = activityService.selectActivityForConvertByNameClueId(map);
        return activityList;
    }

}
