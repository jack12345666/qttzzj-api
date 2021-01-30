package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.mapper.PlatecategoryMapper;
import com.vpn.website.client.model.Platecategory;
import com.vpn.website.service.PlatecategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Service
public class PlatecategoryServiceImpl extends ServiceImpl<PlatecategoryMapper, Platecategory> implements PlatecategoryService {

    @Autowired
    private PlatecategoryMapper platecategoryMapper;

    @Override
    public Integer addPlateCategory(String name) {
        Platecategory platecategory = new Platecategory();
        platecategory.setName(name);
        return platecategoryMapper.insert(platecategory);
    }

    @Override
    public List<Platecategory> platecategoryList() {
        QueryWrapper<Platecategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isValid", 1);
        return platecategoryMapper.selectList(queryWrapper);
    }

    @Override
    public Integer deletePlateCategory(Integer id) {
        return platecategoryMapper.deletePlatecategory(id);
    }
}
