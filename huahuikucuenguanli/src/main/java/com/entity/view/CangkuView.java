package com.entity.view;

import com.entity.CangkuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 仓库信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cangku")
public class CangkuView extends CangkuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 仓库类型的值
		*/
		private String cangkuValue;



	public CangkuView() {

	}

	public CangkuView(CangkuEntity cangkuEntity) {
		try {
			BeanUtils.copyProperties(this, cangkuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 仓库类型的值
			*/
			public String getCangkuValue() {
				return cangkuValue;
			}
			/**
			* 设置： 仓库类型的值
			*/
			public void setCangkuValue(String cangkuValue) {
				this.cangkuValue = cangkuValue;
			}











}
