package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.mapper.CodeMapper;
import com.vpn.website.client.model.Code;
import com.vpn.website.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tao
 * @Date: 2020/12/10 10:35
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

    @Autowired
    private CodeMapper codeMapper;

    @Override
    public List<Code> getOutletsList(String category) {
        return codeMapper.selectCateGory(category);
    }
}
