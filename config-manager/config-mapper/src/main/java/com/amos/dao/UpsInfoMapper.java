package com.amos.dao;

import com.amos.pojo.UpsInfo;
import java.util.List;

public interface UpsInfoMapper {
    /**
     *  根据主键删除数据库的记录,ups_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,ups_info
     *
     * @param record
     */
    int insert(UpsInfo record);

    /**
     *  动态字段,写入数据库记录,ups_info
     *
     * @param record
     */
    int insertSelective(UpsInfo record);

    /**
     *  根据指定主键获取一条数据库记录,ups_info
     *
     * @param id
     */
    UpsInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,ups_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UpsInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,ups_info
     *
     * @param record
     */
    int updateByPrimaryKey(UpsInfo record);

    int insertBatchSelective(List<UpsInfo> records);

    int updateBatchByPrimaryKeySelective(List<UpsInfo> records);
}