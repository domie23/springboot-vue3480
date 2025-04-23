package com.entity.vo;

import com.entity.XianhuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 货物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xianhua")
public class XianhuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 货物编号
     */

    @TableField(value = "xianhua_uuid_number")
    private String xianhuaUuidNumber;


    /**
     * 货物名称
     */

    @TableField(value = "xianhua_name")
    private String xianhuaName;


    /**
     * 货物照片
     */

    @TableField(value = "xianhua_photo")
    private String xianhuaPhoto;


    /**
     * 货物供应商
     */

    @TableField(value = "gongyingshang_name")
    private String gongyingshangName;


    /**
     * 供应商联系方式
     */

    @TableField(value = "gongyingshang_phone")
    private String gongyingshangPhone;


    /**
     * 仓库
     */

    @TableField(value = "cangku_id")
    private Integer cangkuId;


    /**
     * 货物类型
     */

    @TableField(value = "xianhua_types")
    private Integer xianhuaTypes;


    /**
     * 货物库存
     */

    @TableField(value = "xianhua_kucun_number")
    private Integer xianhuaKucunNumber;


    /**
     * 现价
     */

    @TableField(value = "xianhua_xiaoshou_money")
    private Double xianhuaXiaoshouMoney;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "xianhua_delete")
    private Integer xianhuaDelete;


    /**
     * 货物存放规则
     */

    @TableField(value = "xianhua_text")
    private String xianhuaText;


    /**
     * 货物简介
     */

    @TableField(value = "xianhua_content")
    private String xianhuaContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：货物编号
	 */
    public String getXianhuaUuidNumber() {
        return xianhuaUuidNumber;
    }


    /**
	 * 获取：货物编号
	 */

    public void setXianhuaUuidNumber(String xianhuaUuidNumber) {
        this.xianhuaUuidNumber = xianhuaUuidNumber;
    }
    /**
	 * 设置：货物名称
	 */
    public String getXianhuaName() {
        return xianhuaName;
    }


    /**
	 * 获取：货物名称
	 */

    public void setXianhuaName(String xianhuaName) {
        this.xianhuaName = xianhuaName;
    }
    /**
	 * 设置：货物照片
	 */
    public String getXianhuaPhoto() {
        return xianhuaPhoto;
    }


    /**
	 * 获取：货物照片
	 */

    public void setXianhuaPhoto(String xianhuaPhoto) {
        this.xianhuaPhoto = xianhuaPhoto;
    }
    /**
	 * 设置：货物供应商
	 */
    public String getGongyingshangName() {
        return gongyingshangName;
    }


    /**
	 * 获取：货物供应商
	 */

    public void setGongyingshangName(String gongyingshangName) {
        this.gongyingshangName = gongyingshangName;
    }
    /**
	 * 设置：供应商联系方式
	 */
    public String getGongyingshangPhone() {
        return gongyingshangPhone;
    }


    /**
	 * 获取：供应商联系方式
	 */

    public void setGongyingshangPhone(String gongyingshangPhone) {
        this.gongyingshangPhone = gongyingshangPhone;
    }
    /**
	 * 设置：仓库
	 */
    public Integer getCangkuId() {
        return cangkuId;
    }


    /**
	 * 获取：仓库
	 */

    public void setCangkuId(Integer cangkuId) {
        this.cangkuId = cangkuId;
    }
    /**
	 * 设置：货物类型
	 */
    public Integer getXianhuaTypes() {
        return xianhuaTypes;
    }


    /**
	 * 获取：货物类型
	 */

    public void setXianhuaTypes(Integer xianhuaTypes) {
        this.xianhuaTypes = xianhuaTypes;
    }
    /**
	 * 设置：货物库存
	 */
    public Integer getXianhuaKucunNumber() {
        return xianhuaKucunNumber;
    }


    /**
	 * 获取：货物库存
	 */

    public void setXianhuaKucunNumber(Integer xianhuaKucunNumber) {
        this.xianhuaKucunNumber = xianhuaKucunNumber;
    }
    /**
	 * 设置：现价
	 */
    public Double getXianhuaXiaoshouMoney() {
        return xianhuaXiaoshouMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setXianhuaXiaoshouMoney(Double xianhuaXiaoshouMoney) {
        this.xianhuaXiaoshouMoney = xianhuaXiaoshouMoney;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXianhuaDelete() {
        return xianhuaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXianhuaDelete(Integer xianhuaDelete) {
        this.xianhuaDelete = xianhuaDelete;
    }
    /**
	 * 设置：货物存放规则
	 */
    public String getXianhuaText() {
        return xianhuaText;
    }


    /**
	 * 获取：货物存放规则
	 */

    public void setXianhuaText(String xianhuaText) {
        this.xianhuaText = xianhuaText;
    }
    /**
	 * 设置：货物简介
	 */
    public String getXianhuaContent() {
        return xianhuaContent;
    }


    /**
	 * 获取：货物简介
	 */

    public void setXianhuaContent(String xianhuaContent) {
        this.xianhuaContent = xianhuaContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
