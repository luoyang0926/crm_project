package com.yang.service.impl;

import com.yang.mapper.ActivityMapper;
import com.yang.pojo.Activity;
import com.yang.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int saveActivity(Activity activity) {
        return activityMapper.insertActivity(activity);
    }

    @Override
    public List<Activity> selectActivityForPage(Map<String, Object> map) {
        return activityMapper.selectActivityByConditionForPage(map);
    }

    @Override
    public int selectAllCounts(Map<String, Object> map) {
        return activityMapper.selectAllCounts(map);
    }

    @Override
    public int deleteById(String[] ids) {
        return activityMapper.deleteById(ids);
    }

    @Override
    public int updateById(Activity activity) {
        return activityMapper.updateById(activity);
    }

    @Override
    public Activity selectById(String id) {
        return activityMapper.selectActivityById(id);
    }

    @Override
    public List<Activity> selectAllActivity() {
        return activityMapper.selectAllActivity();
    }

    @Override
    public int saveCreateActivityByList(List<Activity> activityList) {
        return activityMapper.insertActivityByList(activityList);
    }

    @Override
    public Activity selectActivityByIdForDetails(String id) {
        return activityMapper.selectActivityByIdForDetail(id);
    }

    @Override
    public List<Activity> selectActivityForDetailByClueId(String clueId) {
        return activityMapper.selectActivityForDetailByClueId(clueId);
    }


    @Override
    public List<Activity> selectActivityForConvertByNameClueId(Map<String, Object> map) {
        return activityMapper.selectActivityForConvertByNameClueId(map);
    }

    @Override
    public List<Activity> selectActivityForDetailById(String[] ids) {
        return activityMapper.selectActivityForDetailByIds(ids);
    }

    @Override
    public List<Activity> selectActivityForDetailByNameClueId(Map<String, Object> map) {
        return activityMapper.selectActivityForDetailByNameClueId(map);
    }
}
