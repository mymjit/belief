package com.example.controller.common;

import com.example.model.ResultModel;
import com.example.services.common.LabelService;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author   : while
 * @date     : 2017/11/8
 * @describe :
 */
@RestController
public class LabelController {

    private static final Logger logger = LoggerFactory.getLogger( LabelController.class );

    @Autowired
    private LabelService labelService;

    @GetMapping("/labers")
    public ResultModel obtainLabers(@RequestParam("laberName") String laberName){
        ResultModel labelResultModel = ResultUtil.success();
        if ( null == laberName  ){
            logger.warn( "/labers接口 参数 laberName 为空！！！" );
        } else if ( "".equals(laberName) ){
            logger.warn( "/labers接口 参数 laberName 为空字符串！！！" );
        } else {
            labelResultModel.setData( labelService.likeLaber(laberName ) );
        }
        return  labelResultModel;
    }



}
