package com.atneco.yygh.hosp.service.impl;

import com.atneco.yygh.hosp.mapper.HospitalSetMapper;
import com.atneco.yygh.hosp.service.HospitalSetService;
import com.atneco.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author liangyt
 * @create 2021-03-16 23:15
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = this.baseMapper.selectOne(queryWrapper);
        return hospitalSet.getSignKey();
    }
}
