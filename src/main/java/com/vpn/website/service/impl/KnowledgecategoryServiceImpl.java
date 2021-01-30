package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.mapper.KnowledgecategoryMapper;
import com.vpn.website.client.model.Knowledgecategory;
import com.vpn.website.client.util.TreeUtil;
import com.vpn.website.service.KnowledgecategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tao
 * @since 2021-01-26
 */
@Service
public class KnowledgecategoryServiceImpl extends ServiceImpl<KnowledgecategoryMapper, Knowledgecategory> implements KnowledgecategoryService {

    @Autowired
    KnowledgecategoryMapper knowledgecategoryMapper;

    @Override
    public Integer addCategory(Integer parentId, String name) {
        if(null == parentId) {
            parentId = -1;
        }
        Knowledgecategory knowledgecategory = new Knowledgecategory();
        knowledgecategory.setName(name);
        knowledgecategory.setParentId(parentId);
        Integer result = knowledgecategoryMapper.insert(knowledgecategory);
        return result;
    }

    @Override
    public Map getKnowledgecategory() {
        QueryWrapper<Knowledgecategory> wrapper = new QueryWrapper<>();
        wrapper.eq("isValid", 1);
        wrapper.orderByAsc("displayNo");
        List<Knowledgecategory> list = knowledgecategoryMapper.selectList(wrapper);
        HashMap<Object, Object> map = new HashMap<>(10);
        TreeUtil treeUtil = new TreeUtil();
        List<Object> treeList = treeUtil.treeList(list);
        map.put("items", treeList);
        return map;
    }

    @Override
    public Integer deleteCategory(Integer id) {
        int i = knowledgecategoryMapper.toSelectCounts(id);
        if(i == 0) {
            int j = knowledgecategoryMapper.selectCategoryOfQs(id);
            if(j == 0) {
                return knowledgecategoryMapper.toDeleteCategory(id);
            }else {
               return -2;
            }
        }else {
            return -1;
        }
    }

    @Override
    public Integer editCategory(String name, Integer id) {
        return knowledgecategoryMapper.editCategory(name, id);
    }


}

