package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vpn.website.client.model.Knowledgecategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 知识问答分类表 Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2021-01-26
 */

@Mapper
public interface KnowledgecategoryMapper extends BaseMapper<Knowledgecategory> {
    int toDeleteCategory(Integer id);
    int editCategory(String name, Integer id);
    int toSelectCounts(Integer id);
    int selectCategoryOfQs(Integer id);
}
