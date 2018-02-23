package com.amos.dao;

import com.amos.pojo.EnvironmentInfo;
import java.util.List;

public interface EnvironmentInfoMapper {
    /**
     *  根据主键删除数据库的记录,environment_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,environment_info
     *
     * @param record
     */
    int insert(EnvironmentInfo record);

    /**
     *  动态字段,写入数据库记录,environment_info
     *
     * @param record
     */
    int insertSelective(EnvironmentInfo record);

    /**
     *  根据指定主键获取一条数据库记录,environment_info
     *
     * @param id
     */
    EnvironmentInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,environment_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(EnvironmentInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,environment_info
     *
     * @param record
     */
    int updateByPrimaryKey(EnvironmentInfo record);

    int insertBatchSelective(List<EnvironmentInfo> records);

    int updateBatchByPrimaryKeySelective(List<EnvironmentInfo> records);
}