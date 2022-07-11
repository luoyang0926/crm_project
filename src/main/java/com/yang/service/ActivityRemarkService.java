package com.yang.service;

import com.yang.pojo.ActivityRemark;

import java.util.List;

public interface ActivityRemarkService {
    //查询市场活动备注
    List<ActivityRemark> selectActivityRemarkByActivityId(String activityId);

    //保存市场活动备注
    int insertActivityRemark(ActivityRemark activityRemark);

    //删除备注
    int deleteActivityRemarkById(String id);

    //修改备注
    int updateActivityRemark(ActivityRemark activityRemark);
}
