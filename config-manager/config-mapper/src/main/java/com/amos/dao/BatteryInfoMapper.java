package com.amos.dao;

import com.amos.pojo.BatteryInfo;
import java.util.List;

public interface BatteryInfoMapper {
    /**
     *  根据主键删除数据库的记录,battery_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,battery_info
     *
     * @param record
     */
    int insert(BatteryInfo record);

    /**
     *  动态字段,写入数据库记录,battery_info
     *
     * @param record
     */
    int insertSelective(BatteryInfo record);

    /**
     *  根据指定主键获取一条数据库记录,battery_info
     *
     * @param id
     */
    BatteryInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,battery_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BatteryInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,battery_info
     *
     * @param record
     */
    int updateByPrimaryKey(BatteryInfo record);

    int insertBatchSelective(List<BatteryInfo> records);

    int updateBatchByPrimaryKeySelective(List<BatteryInfo> records);
}