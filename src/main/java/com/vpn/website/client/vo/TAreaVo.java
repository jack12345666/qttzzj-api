package com.vpn.website.client.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TAreaVo {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;
}