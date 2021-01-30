package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vpn.website.client.model.Platecategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Mapper
public interface PlatecategoryMapper extends BaseMapper<Platecategory> {
    Integer deletePlatecategory(Integer id);
}
