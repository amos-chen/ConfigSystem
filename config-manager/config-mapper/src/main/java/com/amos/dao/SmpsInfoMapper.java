package com.amos.dao;

import com.amos.pojo.SmpsInfo;
import java.util.List;

public interface SmpsInfoMapper {
    /**
     *  根据主键删除数据库的记录,smps_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,smps_info
     *
     * @param record
     */
    int insert(SmpsInfo record);

    /**
     *  动态字段,写入数据库记录,smps_info
     *
     * @param record
     */
    int insertSelective(SmpsInfo record);

    /**
     *  根据指定主键获取一条数据库记录,smps_info
     *
     * @param id
     */
    SmpsInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,smps_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SmpsInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,smps_info
     *
     * @param record
     */
    int updateByPrimaryKey(SmpsInfo record);

    int insertBatchSelective(List<SmpsInfo> records);

    int updateBatchByPrimaryKeySelective(List<SmpsInfo> records);
}