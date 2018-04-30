package com.amos.dao;

import com.amos.pojo.ConfigurationInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigurationInfoMapper {
    /**
     *  根据主键删除数据库的记录,configuration_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,configuration_info
     *
     * @param record
     */
    int insert(ConfigurationInfo record);

    /**
     *  动态字段,写入数据库记录,configuration_info
     *
     * @param record
     */
    int insertSelective(ConfigurationInfo record);

    /**
     *  根据指定主键获取一条数据库记录,configuration_info
     *
     * @param id
     */
    ConfigurationInfo selectByPrimaryKey(Integer id);


    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,configuration_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ConfigurationInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,configuration_info
     *
     * @param record
     */
    int updateByPrimaryKey(ConfigurationInfo record);

    int insertBatchSelective(List<ConfigurationInfo> records);

    int updateBatchByPrimaryKeySelective(List<ConfigurationInfo> records);

	ConfigurationInfo selectBaseInfoById(@Param("configId") Integer configId);

	ConfigurationInfo selectFullInfoById(@Param("configId") Integer configId);
}