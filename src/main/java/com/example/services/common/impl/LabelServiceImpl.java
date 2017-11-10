package com.example.services.common.impl;

import com.example.domail.common.Label;
import com.example.repository.common.LaberRepository;
import com.example.services.common.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : while
 * @date : 2017/11/8
 * @describe :
 */
@Service
public class LabelServiceImpl implements LabelService {


    private static final Logger loger = LoggerFactory.getLogger( LabelServiceImpl.class );


    @Autowired
    private LaberRepository laberRepository;
    
    /**
     *@param    : [laberName]
     *@method   : likeLaber
     *@return   : java.util.List<com.example.domail.common.Label>
     *@describe : 匹配符合的标签信息
     */
    @Override
    public List<Label> likeLaber(String laberName) {
        laberName = "%"+laberName+"%";
        return laberRepository.like( laberName );
    }
}
