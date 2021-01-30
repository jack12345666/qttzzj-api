package com.vpn.website.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author: tao
 * @Date: 2020/12/10 14:48
 */
@Data
public class LandAddDTO {
    @ApiModelProperty(value = "id(修改时必传)")
    private Integer id;

    @ApiModelProperty(value = "板块名称", required = true)
    @NotNull(message = "板块名称不能为空")
    private String name;

    @ApiModelProperty(value = "所属板块id", required = true)
    @NotNull(message = "所属板块id不能为空")
    private Integer plateId;

    @ApiModelProperty(value = "所属板块名称")
    private String plateName;

    @ApiModelProperty(value = "规划用途", required = true)
    @NotNull(message = "规划用途不能为空")
    private String plannedUse;

    @ApiModelProperty(value = "控规容积率")
    private BigDecimal plotRatio;

    @ApiModelProperty(value = "土地面积", required = true)
    @NotNull(message = "土地面积不能为空")
    private BigDecimal landArea;

    @ApiModelProperty(value = "土地面积单位", required = true)
    @NotNull(message = "土地面积单位不能为空")
    private String landAreaUnit;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal buildingArea;

    @ApiModelProperty(value = "建筑面积单位")
    private String buildingAreaUnit;

    @ApiModelProperty(value = "经度", required = true)
    @NotNull(message = "经度不能为空")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度", required = true)
    @NotNull(message = "纬度不能为空")
    private BigDecimal lat;

    @ApiModelProperty(value = "显示顺序")
    private Integer displayNo;

    @ApiModelProperty(value = "出让状态(0未出让，1已出让)", required = true)
    @NotNull(message = "出让状态不能为空")
    private Integer saleStatus;

    @ApiModelProperty(value = "0表示失效，1表示正常，10表示草稿", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

}
