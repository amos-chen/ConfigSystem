package com.amos.dao;

import com.amos.pojo.CabinetDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CabinetDeviceMapper {
    /**
     *  根据主键删除数据库的记录,cabinet_device
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,cabinet_device
     *
     * @param record
     */
    int insert(CabinetDevice record);

    /**
     *  动态字段,写入数据库记录,cabinet_device
     *
     * @param record
     */
    int insertSelective(CabinetDevice record);

    /**
     *  根据指定主键获取一条数据库记录,cabinet_device
     *
     * @param id
     */
    CabinetDevice selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,cabinet_device
     *
     * @param record
     */
    int updateByPrimaryKeySelective(CabinetDevice record);

    /**
     *  根据主键来更新符合条件的数据库记录,cabinet_device
     *
     * @param record
     */
    int updateByPrimaryKey(CabinetDevice record);

    int insertBatchSelective(List<CabinetDevice> records);

    int updateBatchByPrimaryKeySelective(List<CabinetDevice> records);

    String selectConvergenceByInfo(@Param("deviceType")int deviceType,@Param("banks")int banks,@Param("current")double current);

    String selectManagementCabinetByInfo(@Param("deviceType")int deviceType,@Param("banks")int banks,@Param("current")double current);

    String selectControlCabinetByInfo(@Param("deviceType")int deviceType,@Param("voltage")double voltage,@Param("current")double current);
}