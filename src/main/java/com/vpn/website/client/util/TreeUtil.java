package com.vpn.website.client.util;

import com.vpn.website.client.model.Knowledgecategory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tao
 * @Date: 2021/1/27 13:57
 */
public class TreeUtil {

    public List<Knowledgecategory> treeCommon;
    public List<Object> list = new ArrayList<>();

    public List<Object> treeList(List<Knowledgecategory> tree){
        this.treeCommon = tree;
        for (Knowledgecategory x : tree) {
            Map<String,Object> mapArr = new LinkedHashMap<>();
            if(-1 == x.getParentId()){
                mapArr.put("id", x.getId());
                mapArr.put("name", x.getName());
                mapArr.put("parentId", x.getParentId());
                mapArr.put("category", x.getCategory());
                mapArr.put("comment", x.getComment());
                mapArr.put("displayNo", x.getDisplayNo());
                mapArr.put("children", treeChild(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List<?> treeChild(Integer id){
        List<Object> lists = new ArrayList<>();
        for(Knowledgecategory a : treeCommon){
            Map<String,Object> childArray = new LinkedHashMap<>();
            if(a.getParentId().equals(id)){
                childArray.put("id", a.getId());
                childArray.put("name", a.getName());
                childArray.put("parentId", a.getParentId());
                childArray.put("category", a.getCategory());
                childArray.put("comment", a.getComment());
                childArray.put("displayNo", a.getDisplayNo());
                childArray.put("children", treeChild(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }
}
