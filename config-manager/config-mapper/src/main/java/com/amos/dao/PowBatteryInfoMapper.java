package com.amos.dao;

import com.amos.pojo.PowBatteryInfo;
import java.util.List;

public interface PowBatteryInfoMapper {
    /**
     *  根据主键删除数据库的记录,pow_battery_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,pow_battery_info
     *
     * @param record
     */
    int insert(PowBatteryInfo record);

    /**
     *  动态字段,写入数据库记录,pow_battery_info
     *
     * @param record
     */
    int insertSelective(PowBatteryInfo record);

    /**
     *  根据指定主键获取一条数据库记录,pow_battery_info
     *
     * @param id
     */
    PowBatteryInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,pow_battery_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PowBatteryInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,pow_battery_info
     *
     * @param record
     */
    int updateByPrimaryKey(PowBatteryInfo record);

    int insertBatchSelective(List<PowBatteryInfo> records);

    int updateBatchByPrimaryKeySelective(List<PowBatteryInfo> records);
}