package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: tao
 * @Date: 2021/1/30 11:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_knowledgequestionliked")
@ApiModel(value="Knowledgequestionliked", description="知识问答相似问题表")
public class Knowledgequestionliked implements Serializable {

        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "编号")
        @TableId(value = "id", type = IdType.AUTO)
        private Integer id;

        @ApiModelProperty(value = "问题id")
        @TableField("questionId")
        private Integer questionId;

        @ApiModelProperty(value = "相似问题")
        @TableField("likedQuestion")
        private String likedQuestion;

        @ApiModelProperty(value = "答案id")
        @TableField("answerId")
        private Integer answerId;

    }

