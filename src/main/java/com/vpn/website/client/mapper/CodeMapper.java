package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vpn.website.client.model.Code;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 编码表 Mapper 接口
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Mapper
public interface CodeMapper extends BaseMapper<Code> {
    List<Code> selectCateGory(String category);
}
