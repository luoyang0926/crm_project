package com.yang.service;

import com.yang.pojo.ClueRemark;

import java.util.List;

public interface ClueRemarkService {
    //查询线索备注
    List<ClueRemark> selectClueRemarkByClueId(String clueId);
}
