package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 出入库
 *
 * @author 
 * @email
 */
@TableName("xianhua_churu_inout")
public class XianhuaChuruInoutEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XianhuaChuruInoutEntity() {

	}

	public XianhuaChuruInoutEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 出入库流水号
     */
    @TableField(value = "xianhua_churu_inout_uuid_number")

    private String xianhuaChuruInoutUuidNumber;


    /**
     * 负责人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 出入库名称
     */
    @TableField(value = "xianhua_churu_inout_name")

    private String xianhuaChuruInoutName;


    /**
     * 出入库类型
     */
    @TableField(value = "xianhua_churu_inout_types")

    private Integer xianhuaChuruInoutTypes;


    /**
     * 备注
     */
    @TableField(value = "xianhua_churu_inout_content")

    private String xianhuaChuruInoutContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：出入库流水号
	 */
    public String getXianhuaChuruInoutUuidNumber() {
        return xianhuaChuruInoutUuidNumber;
    }
    /**
	 * 获取：出入库流水号
	 */

    public void setXianhuaChuruInoutUuidNumber(String xianhuaChuruInoutUuidNumber) {
        this.xianhuaChuruInoutUuidNumber = xianhuaChuruInoutUuidNumber;
    }
    /**
	 * 设置：负责人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：负责人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：出入库名称
	 */
    public String getXianhuaChuruInoutName() {
        return xianhuaChuruInoutName;
    }
    /**
	 * 获取：出入库名称
	 */

    public void setXianhuaChuruInoutName(String xianhuaChuruInoutName) {
        this.xianhuaChuruInoutName = xianhuaChuruInoutName;
    }
    /**
	 * 设置：出入库类型
	 */
    public Integer getXianhuaChuruInoutTypes() {
        return xianhuaChuruInoutTypes;
    }
    /**
	 * 获取：出入库类型
	 */

    public void setXianhuaChuruInoutTypes(Integer xianhuaChuruInoutTypes) {
        this.xianhuaChuruInoutTypes = xianhuaChuruInoutTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getXianhuaChuruInoutContent() {
        return xianhuaChuruInoutContent;
    }
    /**
	 * 获取：备注
	 */

    public void setXianhuaChuruInoutContent(String xianhuaChuruInoutContent) {
        this.xianhuaChuruInoutContent = xianhuaChuruInoutContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "XianhuaChuruInout{" +
            "id=" + id +
            ", xianhuaChuruInoutUuidNumber=" + xianhuaChuruInoutUuidNumber +
            ", yonghuId=" + yonghuId +
            ", xianhuaChuruInoutName=" + xianhuaChuruInoutName +
            ", xianhuaChuruInoutTypes=" + xianhuaChuruInoutTypes +
            ", xianhuaChuruInoutContent=" + xianhuaChuruInoutContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
