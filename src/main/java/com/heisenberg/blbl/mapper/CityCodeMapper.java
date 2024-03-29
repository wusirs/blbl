package com.heisenberg.blbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heisenberg.blbl.domain.CityCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 邮政编码mapper
 * @author heisenberg
 * @date 2024/02/19
 * @version 1.0
 */
@Mapper
@Component
public interface CityCodeMapper extends BaseMapper<CityCode> {
}
