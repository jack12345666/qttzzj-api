package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "com-vpn-website-client-model-TBuildingleaseattachment")
@TableName(value = "t_buildingleaseattachment")
public class TBuildingleaseattachment implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  @ApiModelProperty(value = "id")
  private Long id;

  @TableField(value = "leaseId")
  @ApiModelProperty(value = "租赁序号")
  private Long leaseId;

  @TableField(value = "fileName")
  @ApiModelProperty(value = "文件名")
  private String fileName;

  @TableField(value = "filePath")
  @ApiModelProperty(value = "文件路径")
  private String filePath;

  @TableField(value = "fileExt")
  @ApiModelProperty(value = "文件扩展名")
  private String fileExt;

  @TableField(value = "category")
  @ApiModelProperty(value = "附件类型，不同附件类型，显示在不同地方，看需求增加")
  private String category;

  @TableField(value = "createTime", fill = FieldFill.INSERT)
  @ApiModelProperty(value = "创建时间")
  private Date createTime;

  @TableField(value = "displayNo")
  @ApiModelProperty(value = "显示顺序")
  private Long displayNo;

  @TableField(value = "isValid")
  @ApiModelProperty("是否有效")
  private Long isValid;



}
