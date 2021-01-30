package com.vpn.website.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TAreaDTO {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 上级编号
     */
    @ApiModelProperty(value = "上级编号")
    private String parentId;
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    private String shortName;
    /**
     * 层级
     */
    @ApiModelProperty(value = "层级")
    private Integer levelType;
    /**
     * 区号
     */
    @ApiModelProperty(value = "区号")
    private String cityCode;
    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    /**
     * 合并名称
     */
    @ApiModelProperty(value = "合并名称")
    private String mergerName;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private BigDecimal lng;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;
    /**
     * 拼音
     */
    @ApiModelProperty(value = "拼音")
    private String pinyin;

}
