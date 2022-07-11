package com.yang.service;

import com.yang.pojo.ClueActivityRelation;

import java.util.List;

public interface ClueActivityRelationService {
    //
    int insertActivityRelationByList(List<ClueActivityRelation> list);

    //解除关联
    int deleteActivityRelationById(ClueActivityRelation clueActivityRelation);

}
