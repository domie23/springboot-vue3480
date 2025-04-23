package com.entity.view;

import com.entity.XianhuaChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xianhua_churu_inout_list")
public class XianhuaChuruInoutListView extends XianhuaChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 xianhua
			/**
			* 货物编号
			*/
			private String xianhuaUuidNumber;
			/**
			* 货物名称
			*/
			private String xianhuaName;
			/**
			* 货物照片
			*/
			private String xianhuaPhoto;
			/**
			* 货物供应商
			*/
			private String gongyingshangName;
			/**
			* 供应商联系方式
			*/
			private String gongyingshangPhone;
			/**
			* 货物类型
			*/
			private Integer xianhuaTypes;
				/**
				* 货物类型的值
				*/
				private String xianhuaValue;
			/**
			* 货物库存
			*/
			private Integer xianhuaKucunNumber;
			/**
			* 现价
			*/
			private Double xianhuaXiaoshouMoney;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer xianhuaDelete;
			/**
			* 货物存放规则
			*/
			private String xianhuaText;
			/**
			* 货物简介
			*/
			private String xianhuaContent;

		//级联表 xianhua_churu_inout
			/**
			* 出入库流水号
			*/
			private String xianhuaChuruInoutUuidNumber;
			/**
			* 出入库 的 负责人
			*/
			private Integer xianhuaChuruInoutYonghuId;
			/**
			* 出入库名称
			*/
			private String xianhuaChuruInoutName;
			/**
			* 出入库类型
			*/
			private Integer xianhuaChuruInoutTypes;
				/**
				* 出入库类型的值
				*/
				private String xianhuaChuruInoutValue;
			/**
			* 备注
			*/
			private String xianhuaChuruInoutContent;

	public XianhuaChuruInoutListView() {

	}

	public XianhuaChuruInoutListView(XianhuaChuruInoutListEntity xianhuaChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, xianhuaChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




















				//级联表的get和set xianhua

					/**
					* 获取： 货物编号
					*/
					public String getXianhuaUuidNumber() {
						return xianhuaUuidNumber;
					}
					/**
					* 设置： 货物编号
					*/
					public void setXianhuaUuidNumber(String xianhuaUuidNumber) {
						this.xianhuaUuidNumber = xianhuaUuidNumber;
					}

					/**
					* 获取： 货物名称
					*/
					public String getXianhuaName() {
						return xianhuaName;
					}
					/**
					* 设置： 货物名称
					*/
					public void setXianhuaName(String xianhuaName) {
						this.xianhuaName = xianhuaName;
					}

					/**
					* 获取： 货物照片
					*/
					public String getXianhuaPhoto() {
						return xianhuaPhoto;
					}
					/**
					* 设置： 货物照片
					*/
					public void setXianhuaPhoto(String xianhuaPhoto) {
						this.xianhuaPhoto = xianhuaPhoto;
					}

					/**
					* 获取： 货物供应商
					*/
					public String getGongyingshangName() {
						return gongyingshangName;
					}
					/**
					* 设置： 货物供应商
					*/
					public void setGongyingshangName(String gongyingshangName) {
						this.gongyingshangName = gongyingshangName;
					}

					/**
					* 获取： 供应商联系方式
					*/
					public String getGongyingshangPhone() {
						return gongyingshangPhone;
					}
					/**
					* 设置： 供应商联系方式
					*/
					public void setGongyingshangPhone(String gongyingshangPhone) {
						this.gongyingshangPhone = gongyingshangPhone;
					}


					/**
					* 获取： 货物类型
					*/
					public Integer getXianhuaTypes() {
						return xianhuaTypes;
					}
					/**
					* 设置： 货物类型
					*/
					public void setXianhuaTypes(Integer xianhuaTypes) {
						this.xianhuaTypes = xianhuaTypes;
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
					* 获取： 货物库存
					*/
					public Integer getXianhuaKucunNumber() {
						return xianhuaKucunNumber;
					}
					/**
					* 设置： 货物库存
					*/
					public void setXianhuaKucunNumber(Integer xianhuaKucunNumber) {
						this.xianhuaKucunNumber = xianhuaKucunNumber;
					}

					/**
					* 获取： 现价
					*/
					public Double getXianhuaXiaoshouMoney() {
						return xianhuaXiaoshouMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setXianhuaXiaoshouMoney(Double xianhuaXiaoshouMoney) {
						this.xianhuaXiaoshouMoney = xianhuaXiaoshouMoney;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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

					/**
					* 获取： 逻辑删除
					*/
					public Integer getXianhuaDelete() {
						return xianhuaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXianhuaDelete(Integer xianhuaDelete) {
						this.xianhuaDelete = xianhuaDelete;
					}

					/**
					* 获取： 货物存放规则
					*/
					public String getXianhuaText() {
						return xianhuaText;
					}
					/**
					* 设置： 货物存放规则
					*/
					public void setXianhuaText(String xianhuaText) {
						this.xianhuaText = xianhuaText;
					}

					/**
					* 获取： 货物简介
					*/
					public String getXianhuaContent() {
						return xianhuaContent;
					}
					/**
					* 设置： 货物简介
					*/
					public void setXianhuaContent(String xianhuaContent) {
						this.xianhuaContent = xianhuaContent;
					}


				//级联表的get和set xianhua_churu_inout

					/**
					* 获取： 出入库流水号
					*/
					public String getXianhuaChuruInoutUuidNumber() {
						return xianhuaChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setXianhuaChuruInoutUuidNumber(String xianhuaChuruInoutUuidNumber) {
						this.xianhuaChuruInoutUuidNumber = xianhuaChuruInoutUuidNumber;
					}

					/**
					* 获取：出入库 的 负责人
					*/
					public Integer getXianhuaChuruInoutYonghuId() {
						return xianhuaChuruInoutYonghuId;
					}
					/**
					* 设置：出入库 的 负责人
					*/
					public void setXianhuaChuruInoutYonghuId(Integer xianhuaChuruInoutYonghuId) {
						this.xianhuaChuruInoutYonghuId = xianhuaChuruInoutYonghuId;
					}


					/**
					* 获取： 出入库名称
					*/
					public String getXianhuaChuruInoutName() {
						return xianhuaChuruInoutName;
					}
					/**
					* 设置： 出入库名称
					*/
					public void setXianhuaChuruInoutName(String xianhuaChuruInoutName) {
						this.xianhuaChuruInoutName = xianhuaChuruInoutName;
					}

					/**
					* 获取： 出入库类型
					*/
					public Integer getXianhuaChuruInoutTypes() {
						return xianhuaChuruInoutTypes;
					}
					/**
					* 设置： 出入库类型
					*/
					public void setXianhuaChuruInoutTypes(Integer xianhuaChuruInoutTypes) {
						this.xianhuaChuruInoutTypes = xianhuaChuruInoutTypes;
					}


						/**
						* 获取： 出入库类型的值
						*/
						public String getXianhuaChuruInoutValue() {
							return xianhuaChuruInoutValue;
						}
						/**
						* 设置： 出入库类型的值
						*/
						public void setXianhuaChuruInoutValue(String xianhuaChuruInoutValue) {
							this.xianhuaChuruInoutValue = xianhuaChuruInoutValue;
						}

					/**
					* 获取： 备注
					*/
					public String getXianhuaChuruInoutContent() {
						return xianhuaChuruInoutContent;
					}
					/**
					* 设置： 备注
					*/
					public void setXianhuaChuruInoutContent(String xianhuaChuruInoutContent) {
						this.xianhuaChuruInoutContent = xianhuaChuruInoutContent;
					}










}
