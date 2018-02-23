package com.amos.dao;

import com.amos.pojo.DirectCurrentPanelInfo;
import java.util.List;

public interface DirectCurrentPanelInfoMapper {
    /**
     *  根据主键删除数据库的记录,direct_current_panel_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,direct_current_panel_info
     *
     * @param record
     */
    int insert(DirectCurrentPanelInfo record);

    /**
     *  动态字段,写入数据库记录,direct_current_panel_info
     *
     * @param record
     */
    int insertSelective(DirectCurrentPanelInfo record);

    /**
     *  根据指定主键获取一条数据库记录,direct_current_panel_info
     *
     * @param id
     */
    DirectCurrentPanelInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,direct_current_panel_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(DirectCurrentPanelInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,direct_current_panel_info
     *
     * @param record
     */
    int updateByPrimaryKey(DirectCurrentPanelInfo record);

    int insertBatchSelective(List<DirectCurrentPanelInfo> records);

    int updateBatchByPrimaryKeySelective(List<DirectCurrentPanelInfo> records);
}