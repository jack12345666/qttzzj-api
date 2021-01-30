package com.vpn.website.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserLeaseVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String no;

    @ApiModelProperty(value = "区域序号")
    private String areaId;

    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "缩略图-用于列表")
    private String thumbnail;

    @ApiModelProperty(value = "主图，大图")
    private String mainPic;

    @ApiModelProperty(value = "楼幢")
    private String buildingNo;

    @ApiModelProperty(value = "占地面积")
    private BigDecimal floorArea;

    @ApiModelProperty(value = "占地面积单位")
    private String floorAreaUnit;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal buildingArea;

    @ApiModelProperty(value = "建筑面积单位")
    private String buildingAreaUnit;

    @ApiModelProperty(value = "总楼层")
    private String totalFloor;

    @ApiModelProperty(value = "层高")
    private String floorHeight;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "价格低区间")
    private BigDecimal priceLow;

    @ApiModelProperty(value = "价格高区间")
    private BigDecimal priceHigh;

    @ApiModelProperty(value = "价格单位")
    private String priceUnit;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "浏览量")
    private Long viewCount;

    @ApiModelProperty(value = "显示顺序")
    private Long displayNo;



}