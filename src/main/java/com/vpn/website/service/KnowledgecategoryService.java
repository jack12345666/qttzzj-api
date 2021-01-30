package com.vpn.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.model.Knowledgecategory;

import java.util.Map;

/**
 * <p>
 * 知识问答分类表 服务类
 * </p>
 *
 * @author tao
 * @since 2021-01-26
 */
public interface KnowledgecategoryService extends IService<Knowledgecategory> {
    Integer addCategory(Integer parentId, String name);
    Map getKnowledgecategory();
    Integer deleteCategory(Integer id);
    Integer editCategory(String name, Integer id);
}
