package com.entity.model;

import com.entity.XianhuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 货物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XianhuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 仓库
     */
    private Integer cangkuId;


    /**
     * 货物类型
     */
    private Integer xianhuaTypes;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：货物编号
	 */
    public String getXianhuaUuidNumber() {
        return xianhuaUuidNumber;
    }


    /**
	 * 设置：货物编号
	 */
    public void setXianhuaUuidNumber(String xianhuaUuidNumber) {
        this.xianhuaUuidNumber = xianhuaUuidNumber;
    }
    /**
	 * 获取：货物名称
	 */
    public String getXianhuaName() {
        return xianhuaName;
    }


    /**
	 * 设置：货物名称
	 */
    public void setXianhuaName(String xianhuaName) {
        this.xianhuaName = xianhuaName;
    }
    /**
	 * 获取：货物照片
	 */
    public String getXianhuaPhoto() {
        return xianhuaPhoto;
    }


    /**
	 * 设置：货物照片
	 */
    public void setXianhuaPhoto(String xianhuaPhoto) {
        this.xianhuaPhoto = xianhuaPhoto;
    }
    /**
	 * 获取：货物供应商
	 */
    public String getGongyingshangName() {
        return gongyingshangName;
    }


    /**
	 * 设置：货物供应商
	 */
    public void setGongyingshangName(String gongyingshangName) {
        this.gongyingshangName = gongyingshangName;
    }
    /**
	 * 获取：供应商联系方式
	 */
    public String getGongyingshangPhone() {
        return gongyingshangPhone;
    }


    /**
	 * 设置：供应商联系方式
	 */
    public void setGongyingshangPhone(String gongyingshangPhone) {
        this.gongyingshangPhone = gongyingshangPhone;
    }
    /**
	 * 获取：仓库
	 */
    public Integer getCangkuId() {
        return cangkuId;
    }


    /**
	 * 设置：仓库
	 */
    public void setCangkuId(Integer cangkuId) {
        this.cangkuId = cangkuId;
    }
    /**
	 * 获取：货物类型
	 */
    public Integer getXianhuaTypes() {
        return xianhuaTypes;
    }


    /**
	 * 设置：货物类型
	 */
    public void setXianhuaTypes(Integer xianhuaTypes) {
        this.xianhuaTypes = xianhuaTypes;
    }
    /**
	 * 获取：货物库存
	 */
    public Integer getXianhuaKucunNumber() {
        return xianhuaKucunNumber;
    }


    /**
	 * 设置：货物库存
	 */
    public void setXianhuaKucunNumber(Integer xianhuaKucunNumber) {
        this.xianhuaKucunNumber = xianhuaKucunNumber;
    }
    /**
	 * 获取：现价
	 */
    public Double getXianhuaXiaoshouMoney() {
        return xianhuaXiaoshouMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setXianhuaXiaoshouMoney(Double xianhuaXiaoshouMoney) {
        this.xianhuaXiaoshouMoney = xianhuaXiaoshouMoney;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXianhuaDelete() {
        return xianhuaDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXianhuaDelete(Integer xianhuaDelete) {
        this.xianhuaDelete = xianhuaDelete;
    }
    /**
	 * 获取：货物存放规则
	 */
    public String getXianhuaText() {
        return xianhuaText;
    }


    /**
	 * 设置：货物存放规则
	 */
    public void setXianhuaText(String xianhuaText) {
        this.xianhuaText = xianhuaText;
    }
    /**
	 * 获取：货物简介
	 */
    public String getXianhuaContent() {
        return xianhuaContent;
    }


    /**
	 * 设置：货物简介
	 */
    public void setXianhuaContent(String xianhuaContent) {
        this.xianhuaContent = xianhuaContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
