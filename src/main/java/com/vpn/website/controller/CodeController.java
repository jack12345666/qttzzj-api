package com.vpn.website.controller;

import com.vpn.website.client.model.Code;
import com.vpn.website.client.query.CodeQuery;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tao
 * @Date: 2020/12/10 10:50
 */

@Api(tags = "通用分类")
@RequestMapping("/commonCategory")
@RestController
public class CodeController {

    @Autowired
    CodeService codeService;

    @ApiOperation(value = "获取分类", notes = "获取分类")
    @PostMapping("/categoryList")
    @Validated
    public BaseResult getCategory(@Validated CodeQuery codeQuery, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            List<Code> list = codeService.getOutletsList(codeQuery.getCategory());
            Map<String, Object> map = new HashMap<>(5);
            map.put("count", list.size());
            map.put("items", list);
            return BaseResult.initSuccessResult(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

}
