package com.example.controller.file;

import com.example.domail.file.Picture;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.model.ResultModel;
import com.example.services.file.PictureService;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 *@date     : 2017/11/7
 *@author   : whilte
 *@describe : 图片信息
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    //限制最大的图片未10M
    private static  final Integer  maxFileSize = 10000000;

    /**
     *@param    : [file] : 要上传的图片
     *@method   : upload
     *@return   : com.example.model.ResultModel<com.example.domail.file.Picture>
     *@describe : 处理图片上传的接口 针对图片做一些验证
     */
    @PostMapping("/upload")
    public ResultModel<Picture> upload(@RequestParam("file") MultipartFile file){
        ResultModel resultModel = ResultUtil.error();
        // 对文件信息进行验证
        if ( file.isEmpty() ){
            //文件为空
            logger.info("上传文件为空");
            throw new UserException( ResultEnum.REQUEST_DATA_IS_EMPTY );
        } else if ( maxFileSize < file.getSize() ){
            //限制文件上传的大小
            logger.info("文件超出上传大小 : {}",file.getSize());
            throw new UserException( ResultEnum.FILE_TOO_LARGE );
        }
        Picture picture = pictureService.fileUpload( file );
        if ( null != picture ){
            resultModel = ResultUtil.success( ResultEnum.PICTURE_UPLOAD_SUCCESS ,picture );
        }
        return resultModel;
    }

}
