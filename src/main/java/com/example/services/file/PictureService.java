package com.example.services.file;

import com.example.domail.file.Picture;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : while
 * @date   : 2017/11/7
 * @describe : 处理图片信息的业务层接口
 */
public interface PictureService {


    /**
     *@param    : file
     *@method   : fileUpload
     *@return   : Picture 成功返回保存后图片信息 失败返回null
     *@describe : 图片上传接口
     */
    Picture fileUpload(MultipartFile  file);


}
