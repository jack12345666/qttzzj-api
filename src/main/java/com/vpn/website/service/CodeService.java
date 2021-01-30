package com.vpn.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.model.Code;

import java.util.List;

/**
 * <p>
 * 编码表 服务类
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
public interface CodeService extends IService<Code> {
    List<Code> getOutletsList(String category);
}
