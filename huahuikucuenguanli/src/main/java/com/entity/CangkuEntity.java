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
 * 仓库信息
 *
 * @author 
 * @email
 */
@TableName("cangku")
public class CangkuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CangkuEntity() {

	}

	public CangkuEntity(T t) {
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
     * 仓库编号
     */
    @TableField(value = "cangku_name")

    private String cangkuName;


    /**
     * 仓库类型
     */
    @TableField(value = "cangku_types")

    private Integer cangkuTypes;


    /**
     * 仓库地址
     */
    @TableField(value = "cangku_address")

    private String cangkuAddress;


    /**
     * 最大库存
     */
    @TableField(value = "cangku_max_number")

    private Integer cangkuMaxNumber;


    /**
     * 最小库存
     */
    @TableField(value = "cangku_min_number")

    private Integer cangkuMinNumber;


    /**
     * 货物现有库存
     */
    @TableField(value = "cangku_kucun_number")

    private Integer cangkuKucunNumber;


    /**
     * 仓库详情
     */
    @TableField(value = "cangku_content")

    private String cangkuContent;


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
	 * 设置：仓库编号
	 */
    public String getCangkuName() {
        return cangkuName;
    }
    /**
	 * 获取：仓库编号
	 */

    public void setCangkuName(String cangkuName) {
        this.cangkuName = cangkuName;
    }
    /**
	 * 设置：仓库类型
	 */
    public Integer getCangkuTypes() {
        return cangkuTypes;
    }
    /**
	 * 获取：仓库类型
	 */

    public void setCangkuTypes(Integer cangkuTypes) {
        this.cangkuTypes = cangkuTypes;
    }
    /**
	 * 设置：仓库地址
	 */
    public String getCangkuAddress() {
        return cangkuAddress;
    }
    /**
	 * 获取：仓库地址
	 */

    public void setCangkuAddress(String cangkuAddress) {
        this.cangkuAddress = cangkuAddress;
    }
    /**
	 * 设置：最大库存
	 */
    public Integer getCangkuMaxNumber() {
        return cangkuMaxNumber;
    }
    /**
	 * 获取：最大库存
	 */

    public void setCangkuMaxNumber(Integer cangkuMaxNumber) {
        this.cangkuMaxNumber = cangkuMaxNumber;
    }
    /**
	 * 设置：最小库存
	 */
    public Integer getCangkuMinNumber() {
        return cangkuMinNumber;
    }
    /**
	 * 获取：最小库存
	 */

    public void setCangkuMinNumber(Integer cangkuMinNumber) {
        this.cangkuMinNumber = cangkuMinNumber;
    }
    /**
	 * 设置：货物现有库存
	 */
    public Integer getCangkuKucunNumber() {
        return cangkuKucunNumber;
    }
    /**
	 * 获取：货物现有库存
	 */

    public void setCangkuKucunNumber(Integer cangkuKucunNumber) {
        this.cangkuKucunNumber = cangkuKucunNumber;
    }
    /**
	 * 设置：仓库详情
	 */
    public String getCangkuContent() {
        return cangkuContent;
    }
    /**
	 * 获取：仓库详情
	 */

    public void setCangkuContent(String cangkuContent) {
        this.cangkuContent = cangkuContent;
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
        return "Cangku{" +
            "id=" + id +
            ", cangkuName=" + cangkuName +
            ", cangkuTypes=" + cangkuTypes +
            ", cangkuAddress=" + cangkuAddress +
            ", cangkuMaxNumber=" + cangkuMaxNumber +
            ", cangkuMinNumber=" + cangkuMinNumber +
            ", cangkuKucunNumber=" + cangkuKucunNumber +
            ", cangkuContent=" + cangkuContent +
            ", createTime=" + createTime +
        "}";
    }
}
