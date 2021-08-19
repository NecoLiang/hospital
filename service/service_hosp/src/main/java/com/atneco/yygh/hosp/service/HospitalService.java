package com.atneco.yygh.hosp.service;

import com.atneco.yygh.model.hosp.Hospital;
import com.atneco.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author liangyt
 * @create 2021-05-25 23:36
 */
public interface HospitalService{
    void save(Map<String, Object> requestMap);
}
