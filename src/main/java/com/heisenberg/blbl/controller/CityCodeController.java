package com.heisenberg.blbl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heisenberg.blbl.domain.CityCode;
import com.heisenberg.blbl.service.CityCodeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     *
     * @param cityCodeList 城市编码集合
     * @author Heisenberg
     * @date 2024/2/27 21:43
     */
    @RequestMapping("/saveCityCode")
    public void saveCityCode(@RequestBody List<CityCode> cityCodeList){
        cityCodeService.saveBatch(cityCodeList);
    }
}
