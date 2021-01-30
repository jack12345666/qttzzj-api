package com.vpn.website.controller;


import com.vpn.website.client.model.Platecategory;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.service.PlatecategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Api(tags = "所属板块")
@RestController
@RequestMapping("/plateCategory")
public class PlatecategoryController {

    @Autowired
    PlatecategoryService platecategoryService;

    @ApiOperation(value = "添加所属板块", notes = "添加所属板块")
    @PostMapping("/addPlateCategory")
    public BaseResult addPlateCategory(@RequestParam String name) {
        if(null == name) {
            return BaseResult.initFailResult("名称不能为空");
        }
        try {
            platecategoryService.addPlateCategory(name);
            return BaseResult.initSuccessResult("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }

    }

    @ApiOperation(value = "所属板块列表", notes = "所属板块列表")
    @PostMapping("/plateCategoryList")
    public BaseResult plateCategoryList() {
        try {
            List<Platecategory> list = platecategoryService.platecategoryList();
            Map<String, Object> map = new HashMap<>(5);
            map.put("count", list.size());
            map.put("items", list);
            return BaseResult.initSuccessResult(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "删除某个板块", notes = "删除某个板块")
    @PostMapping("/deletePlatecategory")
    public BaseResult deletePlatecategory(@RequestParam Integer id) {
        if(null == id) {
            return BaseResult.initFailResult("id不能为空");
        }
        try {
           Integer result = platecategoryService.deletePlateCategory(id);
           if(1 == result) {
               return BaseResult.initSuccessResult("删除成功");
           }else {
               return BaseResult.initFailResult("操作失败");
           }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }
}

