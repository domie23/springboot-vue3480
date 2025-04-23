package com.dao;

import com.entity.XianhuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianhuaView;

/**
 * 货物 Dao 接口
 *
 * @author 
 */
public interface XianhuaDao extends BaseMapper<XianhuaEntity> {

   List<XianhuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
