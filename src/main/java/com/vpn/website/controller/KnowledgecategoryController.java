package com.vpn.website.controller;

import com.vpn.website.common.base.BaseResult;
import com.vpn.website.service.KnowledgecategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tao
 * @since 2021-01-26
 */
@Api(tags = "知识问答")
@RestController
@RequestMapping("/qa")
public class KnowledgecategoryController {

    @Autowired
    KnowledgecategoryService knowledgecategoryService;

    @ApiOperation(value = "添加知识问答分类", notes = "知识问答分类")
    @PostMapping("/addCategory")
    public BaseResult addCategory(Integer parentId, String name) {
       if(null == name) {
           return BaseResult.initFailResult("名称不能为空");
       }
        try {
            Integer result = knowledgecategoryService.addCategory(parentId, name);
            if(1 == result) {
                return BaseResult.initSuccessResult("添加成功");
            }else {
                return BaseResult.initFailResult("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "获取知识问答分类列表", notes = "问答分类列表")
    @PostMapping("/categoryList")
    public BaseResult getCategoryList() {
        try {
            return BaseResult.initSuccessResult(knowledgecategoryService.getKnowledgecategory());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "删除问答分类", notes = "删除问答分类")
    @PostMapping("/deleteCategory")
    public BaseResult deleteCategory(Integer id) {
        if(null == id) {
            return BaseResult.initFailResult("id不能为空");
        }
        try {
            Integer result = knowledgecategoryService.deleteCategory(id);
            if(1 == result) {
                return BaseResult.initSuccessResult("操作成功");
            }else if(-1 == result){
                return BaseResult.initFailResult("类目不能删除,有子类目存在");
            }else if(-2 == result){
                return BaseResult.initFailResult("该类目下绑定了知识");
            }else {
                return BaseResult.initFailResult("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "修改问答分类", notes = "修改问答分类")
    @PostMapping("/editCategory")
    public BaseResult editCategory(String name, Integer id) {
        if(null == id) {
            return BaseResult.initFailResult("id不能为空");
        }
        if(null == name) {
            return BaseResult.initFailResult("名称不能为空");
        }
        try {
            Integer result = knowledgecategoryService.editCategory(name, id);
            if(1 == result) {
                return BaseResult.initSuccessResult("操作成功");
            }else {
                return BaseResult.initFailResult("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

}

