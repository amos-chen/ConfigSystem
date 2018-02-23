package com.amos.dao;

import com.amos.pojo.TelBatteryInfo;
import java.util.List;

public interface TelBatteryInfoMapper {
    /**
     *  根据主键删除数据库的记录,tel_battery_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,tel_battery_info
     *
     * @param record
     */
    int insert(TelBatteryInfo record);

    /**
     *  动态字段,写入数据库记录,tel_battery_info
     *
     * @param record
     */
    int insertSelective(TelBatteryInfo record);

    /**
     *  根据指定主键获取一条数据库记录,tel_battery_info
     *
     * @param id
     */
    TelBatteryInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,tel_battery_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TelBatteryInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,tel_battery_info
     *
     * @param record
     */
    int updateByPrimaryKey(TelBatteryInfo record);

    int insertBatchSelective(List<TelBatteryInfo> records);

    int updateBatchByPrimaryKeySelective(List<TelBatteryInfo> records);
}