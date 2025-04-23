package com.dao;

import com.entity.XianhuaChuruInoutListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianhuaChuruInoutListView;

/**
 * 出入库详情 Dao 接口
 *
 * @author 
 */
public interface XianhuaChuruInoutListDao extends BaseMapper<XianhuaChuruInoutListEntity> {

   List<XianhuaChuruInoutListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
