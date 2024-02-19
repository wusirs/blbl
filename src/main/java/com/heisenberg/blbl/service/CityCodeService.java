package com.heisenberg.blbl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heisenberg.blbl.domain.CityCode;


/**
 * 邮政编码service
 * @author heisenberg
 * @date 2024/02/19
 * @version 1.0
 */
public interface CityCodeService extends IService<CityCode> {
    /**
     * 查询所有城市编码
     * @return {@link IPage<CityCode>}
     */
    IPage<CityCode> queryAll();
}
