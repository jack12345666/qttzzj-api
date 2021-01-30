package com.vpn.website.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TBuildingleaseattachmentDTO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "租赁序号")
    private Long leaseId;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件扩展名")
    private String fileExt;

    @ApiModelProperty(value = "附件类型，不同附件类型，显示在不同地方，看需求增加")
    private String category;

    @ApiModelProperty(value = "创建时间")
    private Data createTime;

    @ApiModelProperty(value = "显示顺序")
    private Long displayNo;

    @ApiModelProperty("是否有效")
    private Long isValid;
}