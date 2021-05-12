package com.atneco.yygh.cmn.service;

import com.atneco.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
@author liangyt
@create 2021-04-17 17:31
*/
public interface DictService extends IService<Dict> {


    List<Dict> findChildData(Long id);

}
