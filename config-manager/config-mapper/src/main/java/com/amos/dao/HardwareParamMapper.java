package com.amos.dao;

import com.amos.pojo.HardwareParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ${chenlunwei} on 2018/4/11.
 */
public interface HardwareParamMapper {

    int insertParam(HardwareParam hardwareParam);

    HardwareParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(HardwareParam hardwareParam);

    int deleteByPrimaryKey(Integer id);

    List<HardwareParam> selectList(@Param("search") String search);

    List<HardwareParam> queryList(@Param("cid") Integer cid,@Param("search") String search);


}
