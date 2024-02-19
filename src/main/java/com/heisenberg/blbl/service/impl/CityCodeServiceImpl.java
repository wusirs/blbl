package com.heisenberg.blbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heisenberg.blbl.domain.CityCode;
import com.heisenberg.blbl.mapper.CityCodeMapper;
import com.heisenberg.blbl.service.CityCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityCodeServiceImpl extends ServiceImpl<CityCodeMapper, CityCode> implements CityCodeService {
    @Resource
    private CityCodeMapper cityCodeMapper;

    @Override
    public IPage<CityCode> queryAll() {
        QueryWrapper<CityCode> queryWrapper = new QueryWrapper<CityCode>().select();
        Page<CityCode> cityCodePage = new Page<>(1, 10);
        return cityCodeMapper.selectPage(cityCodePage, queryWrapper);
    }
}
