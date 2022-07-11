package com.yang.controller;

import com.yang.commons.contants.Contants;
import com.yang.commons.pojo.ReturnObject;
import com.yang.commons.utils.UUIDUtils;
import com.yang.pojo.Activity;
import com.yang.pojo.Clue;
import com.yang.pojo.ClueActivityRelation;
import com.yang.pojo.DicValue;
import com.yang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClueController {

    @Autowired
    private ClueActivityRelationService clueActivityRelationService;
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

    @ResponseBody
    @RequestMapping("/workbench/clue/saveBund.do")
    public Object saveBund(String[] activityId,String clueId) {
        //封装参数
        ClueActivityRelation car =null;
        List<ClueActivityRelation> list = new ArrayList<>();
        for (String ai : activityId) {
             car=new ClueActivityRelation();
             car.setActivityId(ai);
             car.setClueId(clueId);
             car.setId(UUIDUtils.getUUID());
            list.add(car);
        }
        ReturnObject returnObject=new ReturnObject();
        try {
            int i = clueActivityRelationService.insertActivityRelationByList(list);
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                List<Activity> activityList = activityService.selectActivityForDetailById(activityId);
                returnObject.setRetData(activityList);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("操作失败");

            }

        } catch (Exception e) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("操作失败");

        }

 return  returnObject;

    }

    //解除关联
    @ResponseBody
    @RequestMapping("/workbench/activity/deleteBund.do")
    public Object deleteBund(ClueActivityRelation clueActivityRelation) {
        ReturnObject returnObject=new ReturnObject();
        try {
            int i = clueActivityRelationService.deleteActivityRelationById(clueActivityRelation);
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);

            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("操作失败");

            }

        } catch (Exception e) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("操作失败");

        }
        return returnObject;
    }


    @RequestMapping("/workbench/clue/toConvert.do")
    public String toConvert(String id, HttpServletRequest request) {
        Clue clue = clueService.selectClueForDetailById(id);
        List<DicValue> stageList = dicValueService.selectDicValueByTypeCode("stage");
        request.setAttribute("clue",clue);
        request.setAttribute("stageList",stageList);
        return "workbench/clue/convert";

    }

    @ResponseBody
    @RequestMapping("/workbench/clue/selectActivityForConvertByNameClueId.do")
    public Object selectActivityForConvertByNameClueId(String activityName,String clueId) {
        Map<String, Object> map = new HashMap<>();
        map.put("activityName", activityName);
        map.put("clueId", clueId);
        List<Activity> activityList = activityService.selectActivityForDetailByNameClueId(map);
        return activityList;
    }
}
