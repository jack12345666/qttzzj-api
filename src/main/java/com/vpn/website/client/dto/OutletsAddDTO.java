package com.vpn.website.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author: tao
 * @Date: 2020/12/11 9:26
 */
@Data
public class OutletsAddDTO {

    @ApiModelProperty(value = "id(修改时必传)")
    private Integer id;

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "地址", required = true)
    @NotNull(message = "地址不能为空")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "经度", required = true)
    @NotNull(message = "经度不能为空")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度", required = true)
    @NotNull(message = "纬度不能为空")
    private BigDecimal lat;

    @ApiModelProperty(value = "运行状态")
    private Integer runStatus;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "分类", required = true)
    @NotNull(message = "分类不能为空")
    private String category;

    @ApiModelProperty(value = "显示顺序")
    private Integer displayNo;

}
