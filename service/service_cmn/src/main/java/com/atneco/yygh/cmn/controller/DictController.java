package com.atneco.yygh.cmn.controller;

import com.atneco.yygh.cmn.service.DictService;
import com.atneco.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.atneco.yygh.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liangyt
 * @create 2021-04-17 17:43
 */
@Api(tags = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    //根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id){
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }

}
