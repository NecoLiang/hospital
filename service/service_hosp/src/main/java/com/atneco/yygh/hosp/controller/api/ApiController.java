package com.atneco.yygh.hosp.controller.api;

import com.atneco.yygh.common.exception.YyghException;
import com.atneco.yygh.common.helper.HttpRequestHelper;
import com.atneco.yygh.common.result.Result;
import com.atneco.yygh.common.result.ResultCodeEnum;
import com.atneco.yygh.common.util.MD5;
import com.atneco.yygh.hosp.service.HospitalService;
import com.atneco.yygh.hosp.service.HospitalSetService;
import com.atneco.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author liangyt
 * @create 2021-05-25 23:40
 */
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private  HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    //上传医院接口
    @PostMapping("/saveHospital")
    public Result saveHospital(HttpServletRequest request){
        //获取传递过来的医院信息
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> requestMap = HttpRequestHelper.switchMap(parameterMap);

        //1.获取医院系统传过来的签名，进行MD5加密
        String sign = (String)requestMap.get("sign");
        //2.根据传递过来的医院编码，查询数据库，查询签名
        String hoscode = (String)requestMap.get("hoscode");
        String signKey = hospitalSetService.getSignKey(hoscode);
        //3.数据库查询的签名进行MD5加密
        String signKeyMD5 = MD5.encrypt(signKey);
        //4.判断签名是否一致
//        if (!sign.equals(signKeyMD5)){
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }
        String logoData = (String) requestMap.get("logoData");
        logoData = logoData.replaceAll(" ", "+");
        requestMap.put("logoData",logoData);
        //调用service
        hospitalService.save(requestMap);
        return Result.ok();

    }
}
