package com.vpn.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.model.Platecategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
public interface PlatecategoryService extends IService<Platecategory> {
        Integer addPlateCategory(String name);
        List<Platecategory> platecategoryList();
        Integer deletePlateCategory(Integer id);
}
