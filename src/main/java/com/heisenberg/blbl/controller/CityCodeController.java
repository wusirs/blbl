package com.heisenberg.blbl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heisenberg.blbl.domain.CityCode;
import com.heisenberg.blbl.service.CityCodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cityCode")
public class CityCodeController {
    @Resource
    private CityCodeService cityCodeService;

    /**
     * 查询所有城市编码
     * @return {@link IPage<CityCode>}
     */
    @RequestMapping("/queryAll")
    public IPage<CityCode> queryAll() {
        return cityCodeService.queryAll();
    }
}
