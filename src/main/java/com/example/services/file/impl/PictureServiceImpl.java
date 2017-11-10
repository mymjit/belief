package com.example.services.file.impl;

import com.example.domail.file.Picture;
import com.example.repository.file.PictureRepository;
import com.example.services.file.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author : while
 * @date : 2017/11/7
 * @describe : 处理图片信息的业务层
 */
@Service("PictureService")
public class PictureServiceImpl implements PictureService {

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);
    private static final String filePath = "D:/file";

    @Autowired
    private Picture picture;
    @Autowired
    private PictureRepository pictureRepository;

    /**
     * @param : [file]
     * @return : com.example.domail.file.Picture 成功返回图片信息，失败返回null
     * @method : fileUpload
     * @describe : 处理图片上传的方法
     */
    @Override
    public Picture fileUpload(MultipartFile file) {
        picture = getPicture(file);
        if (null != picture) {
            picture = pictureRepository.save(picture);
            logger.info("图片上传成功 : {}", picture);
            return picture;
        }
        return null;
    }

    /**
     * @param : file
     * @return : null or Picture 失败返回null 成功返回图片信息
     * @method : getPicture
     * @describe : 获取上传成功后的图片信息
     */
    private Picture getPicture(MultipartFile file) {
        picture = new Picture();
        //私有文件
        picture.setState(1);
        picture.setSize(file.getSize());
        picture.setRemarks("添加文章,自动上传图片");
        String fileName = file.getOriginalFilename();
        picture.setFileName(fileName);
        //获取文件后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
        picture.setPathName(fileName);
        File dest = new File(filePath + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            //文件不存在，则创建文件
            dest.getParentFile().mkdirs();
        }
        try {
            //复制图片到自定文件夹
            file.transferTo(dest);
            return picture;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
