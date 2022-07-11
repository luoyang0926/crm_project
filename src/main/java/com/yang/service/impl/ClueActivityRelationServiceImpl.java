package com.yang.service.impl;

import com.yang.mapper.ClueActivityRelationMapper;
import com.yang.pojo.ClueActivityRelation;
import com.yang.service.ClueActivityRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClueActivityRelationServiceImpl implements ClueActivityRelationService {
    @Autowired
    private ClueActivityRelationMapper clueActivityRelationMapper;

    @Override
    public int insertActivityRelationByList(List<ClueActivityRelation> list) {
        return clueActivityRelationMapper.insertActivityRelationByList(list);
    }

    @Override
    public int deleteActivityRelationById(ClueActivityRelation clueActivityRelation) {
        return clueActivityRelationMapper.deleteActivityDetailById(clueActivityRelation);
    }
}
