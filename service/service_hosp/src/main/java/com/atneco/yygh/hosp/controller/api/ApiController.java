package com.atneco.yygh.hosp.controller.api;

import com.atneco.yygh.hosp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangyt
 * @create 2021-05-25 23:40
 */
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private  HospitalService hospitalService;

}
