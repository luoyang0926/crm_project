package com.yang.mapper;

import com.yang.pojo.Clue;
import com.yang.pojo.ClueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int countByExample(ClueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int deleteByExample(ClueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int insert(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int insertSelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    List<Clue> selectByExample(ClueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    Clue selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int updateByExampleSelective(@Param("record") Clue record, @Param("example") ClueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int updateByExample(@Param("record") Clue record, @Param("example") ClueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int updateByPrimaryKeySelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Tue Jun 28 20:05:34 CST 2022
     */
    int updateByPrimaryKey(Clue record);


    /**
     * 保存线索
     * @param clue
     * @return
     */
    int insertClue(Clue clue);

    /**
     * 根据id查询线索明细信息
     */
    Clue selectClueForDetailById(String id);
}