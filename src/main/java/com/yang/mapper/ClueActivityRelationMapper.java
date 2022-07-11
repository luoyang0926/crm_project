package com.yang.mapper;

import com.yang.pojo.ClueActivityRelation;
import com.yang.pojo.ClueActivityRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClueActivityRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int countByExample(ClueActivityRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int deleteByExample(ClueActivityRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int insert(ClueActivityRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int insertSelective(ClueActivityRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    List<ClueActivityRelation> selectByExample(ClueActivityRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    ClueActivityRelation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int updateByExampleSelective(@Param("record") ClueActivityRelation record, @Param("example") ClueActivityRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int updateByExample(@Param("record") ClueActivityRelation record, @Param("example") ClueActivityRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int updateByPrimaryKeySelective(ClueActivityRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue_activity_relation
     *
     * @mbggenerated Wed Jun 29 15:34:26 CST 2022
     */
    int updateByPrimaryKey(ClueActivityRelation record);


    /**
     * 批量保存关联关系表
     * @return
     */
    int insertActivityRelationByList(List<ClueActivityRelation> list);

    /**
     * 解除关联
     */
    int deleteActivityDetailById(ClueActivityRelation activityRelation);
}