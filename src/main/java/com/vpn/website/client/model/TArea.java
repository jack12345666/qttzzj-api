package com.vpn.website.client.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 区域信息表
 * </p>
 *
 * @author fml
 * @since 2020-08-18
 */
@ApiModel(value = "com-vpn-website-client-model-TArea")
@Data
@TableName(value = "t_area")
public class TArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableField(value = "id")
    @ApiModelProperty(value = "编号")
    private String id;
    /**
     * 名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 上级编号
     */
    @ApiModelProperty(value = "上级编号")
    @TableField("parentId")
    private String parentId;
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    @TableField("shortName")
    private String shortName;
    /**
     * 层级
     */
    @ApiModelProperty(value = "层级")
    @TableField("levelType")
    private Integer levelType;
    /**
     * 区号
     */
    @ApiModelProperty(value = "区号")
    @TableField("cityCode")
    private String cityCode;
    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    @TableField("zipCode")
    private String zipCode;
    /**
     * 合并名称
     */
    @ApiModelProperty(value = "合并名称")
    @TableField("mergerName")
    private String mergerName;
    /**
     * 经度
     */
    @TableField(value = "lng")
    @ApiModelProperty(value = "经度")
    private BigDecimal lng;
    /**
     * 纬度
     */
    @TableField(value = "lat")
    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;
    /**
     * 拼音
     */
    @TableField(value = "pinyin")
    @ApiModelProperty(value = "拼音")
    private String pinyin;


    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_PARENTID = "parentId";

    public static final String COL_SHORTNAME = "shortName";

    public static final String COL_LEVELTYPE = "levelType";

    public static final String COL_CITYCODE = "cityCode";

    public static final String COL_ZIPCODE = "zipCode";

    public static final String COL_MERGERNAME = "mergerName";

    public static final String COL_LNG = "lng";

    public static final String COL_LAT = "lat";

    public static final String COL_PINYIN = "pinyin";


}
