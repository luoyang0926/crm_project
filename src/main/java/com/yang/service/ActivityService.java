package com.yang.service;

import com.yang.pojo.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    //保存市场表
    int saveActivity(Activity activity);

    //分页
    List<Activity> selectActivityForPage(Map<String,Object> map);

    int selectAllCounts(Map<String ,Object> map);

    //批量删除
    int deleteById(String[] ids);

    //通过ID查询
    Activity selectById(String id);


    //更新
    int updateById(Activity activity);

    //查询所有activity
    List<Activity> selectAllActivity();

    //导入
    int  saveCreateActivityByList(List<Activity> activityList);

    //详细展示
    Activity selectActivityByIdForDetails(String id);

    //根据clueId查询市场活动信息
    List<Activity> selectActivityForDetailByClueId(String clueId);

    //模糊查询关联
    List<Activity> selectActivityForConvertByNameClueId(Map<String,Object> map);

    //根据id查询市场明细信息
    List<Activity> selectActivityForDetailById(String[] ids);

    //模糊查询关联2
    List<Activity> selectActivityForDetailByNameClueId(Map<String,Object> map);



}
