package com.amos.dao;

import com.amos.pojo.ConfigResult;
import java.util.List;

public interface ConfigResultMapper {
    /**
     *  根据主键删除数据库的记录,config_result
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,config_result
     *
     * @param record
     */
    int insert(ConfigResult record);

    /**
     *  动态字段,写入数据库记录,config_result
     *
     * @param record
     */
    int insertSelective(ConfigResult record);

    /**
     *  根据指定主键获取一条数据库记录,config_result
     *
     * @param id
     */
    ConfigResult selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,config_result
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ConfigResult record);

    /**
     * ,config_result
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(ConfigResult record);

    /**
     *  根据主键来更新符合条件的数据库记录,config_result
     *
     * @param record
     */
    int updateByPrimaryKey(ConfigResult record);

    int insertBatchSelective(List<ConfigResult> records);

    int updateBatchByPrimaryKeySelective(List<ConfigResult> records);
}