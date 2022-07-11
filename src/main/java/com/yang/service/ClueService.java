package com.yang.service;

import com.yang.pojo.Clue;

public interface ClueService {
    //保存线索
    int insertClue(Clue clue);

    //查询线索
    Clue selectClueForDetailById(String id);
}
