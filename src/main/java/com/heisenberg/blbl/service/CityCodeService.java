package com.heisenberg.blbl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heisenberg.blbl.domain.CityCode;


/**
 * 邮政编码service
 * @author heisenberg
 * @date 2024/02/19
 * @version 1.0
 */
public interface CityCodeService {
    /**
     * 查询所有城市编码
     * @return {@link IPage<CityCode>}
     */
    IPage<CityCode> queryAll();
}
