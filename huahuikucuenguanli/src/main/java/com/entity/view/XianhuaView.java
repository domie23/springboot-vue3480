package com.entity.view;

import com.entity.XianhuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 货物
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xianhua")
public class XianhuaView extends XianhuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 货物类型的值
		*/
		private String xianhuaValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 cangku
			/**
			* 仓库编号
			*/
			private String cangkuName;
			/**
			* 仓库类型
			*/
			private Integer cangkuTypes;
				/**
				* 仓库类型的值
				*/
				private String cangkuValue;
			/**
			* 仓库地址
			*/
			private String cangkuAddress;
			/**
			* 最大库存
			*/
			private Integer cangkuMaxNumber;
			/**
			* 最小库存
			*/
			private Integer cangkuMinNumber;
			/**
			* 货物现有库存
			*/
			private Integer cangkuKucunNumber;
			/**
			* 仓库详情
			*/
			private String cangkuContent;

	public XianhuaView() {

	}

	public XianhuaView(XianhuaEntity xianhuaEntity) {
		try {
			BeanUtils.copyProperties(this, xianhuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 货物类型的值
			*/
			public String getXianhuaValue() {
				return xianhuaValue;
			}
			/**
			* 设置： 货物类型的值
			*/
			public void setXianhuaValue(String xianhuaValue) {
				this.xianhuaValue = xianhuaValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}




				//级联表的get和set cangku

					/**
					* 获取： 仓库编号
					*/
					public String getCangkuName() {
						return cangkuName;
					}
					/**
					* 设置： 仓库编号
					*/
					public void setCangkuName(String cangkuName) {
						this.cangkuName = cangkuName;
					}

					/**
					* 获取： 仓库类型
					*/
					public Integer getCangkuTypes() {
						return cangkuTypes;
					}
					/**
					* 设置： 仓库类型
					*/
					public void setCangkuTypes(Integer cangkuTypes) {
						this.cangkuTypes = cangkuTypes;
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

					/**
					* 获取： 仓库地址
					*/
					public String getCangkuAddress() {
						return cangkuAddress;
					}
					/**
					* 设置： 仓库地址
					*/
					public void setCangkuAddress(String cangkuAddress) {
						this.cangkuAddress = cangkuAddress;
					}

					/**
					* 获取： 最大库存
					*/
					public Integer getCangkuMaxNumber() {
						return cangkuMaxNumber;
					}
					/**
					* 设置： 最大库存
					*/
					public void setCangkuMaxNumber(Integer cangkuMaxNumber) {
						this.cangkuMaxNumber = cangkuMaxNumber;
					}

					/**
					* 获取： 最小库存
					*/
					public Integer getCangkuMinNumber() {
						return cangkuMinNumber;
					}
					/**
					* 设置： 最小库存
					*/
					public void setCangkuMinNumber(Integer cangkuMinNumber) {
						this.cangkuMinNumber = cangkuMinNumber;
					}

					/**
					* 获取： 货物现有库存
					*/
					public Integer getCangkuKucunNumber() {
						return cangkuKucunNumber;
					}
					/**
					* 设置： 货物现有库存
					*/
					public void setCangkuKucunNumber(Integer cangkuKucunNumber) {
						this.cangkuKucunNumber = cangkuKucunNumber;
					}

					/**
					* 获取： 仓库详情
					*/
					public String getCangkuContent() {
						return cangkuContent;
					}
					/**
					* 设置： 仓库详情
					*/
					public void setCangkuContent(String cangkuContent) {
						this.cangkuContent = cangkuContent;
					}
















}
