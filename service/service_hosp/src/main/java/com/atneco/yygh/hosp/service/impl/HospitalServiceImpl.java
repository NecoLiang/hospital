package com.atneco.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atneco.yygh.hosp.repository.HospitalRepository;
import com.atneco.yygh.hosp.service.HospitalService;
import com.atneco.yygh.model.hosp.Hospital;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author liangyt
 * @create 2021-05-25 23:37
 */
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository hospitalRepositoryService;

    @Override
    public void save(Map<String, Object> requestMap) {
        //参数map转化成对象hospital
        String mapString = JSONObject.toJSONString(requestMap);
        Hospital hospital = JSONObject.parseObject(mapString, Hospital.class);

        //判断是否存在数据
        String hoscode = hospital.getHoscode();
        Hospital hospitalByHoscode = hospitalRepositoryService.getHospitalByHoscode(hoscode);

        if(null != hospitalByHoscode) {
            hospital.setStatus(hospitalByHoscode.getStatus());
            hospital.setCreateTime(hospitalByHoscode.getCreateTime());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepositoryService.save(hospital);
        } else {
//0：未上线 1：已上线
            hospital.setStatus(0);
            hospital.setCreateTime(new Date());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepositoryService.save(hospital);
        }
    }
}
