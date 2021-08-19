package com.atneco.yygh.hosp.service;

import com.atneco.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author liangyt
 * @create 2021-03-16 23:14
 */
public interface HospitalSetService extends IService<HospitalSet> {
    String getSignKey(String hoscode);
}
