package com.vpn.website.client.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: tao
 * @Date: 2020/12/10 14:38
 */
@Data
public class CodeQuery {

    @ApiModelProperty(value = "分类 (OutletsType 代表网点分类, MYSubdistrict 代表街道分类)", required = true)
    @NotNull(message = "category 不能为空")
    private String category;
}
