package com.example.services.common;

import com.example.domail.common.Label;

import java.util.List;

/**
 * @author : while
 * @date : 2017/11/8
 * @describe : 标签业务逻辑接口
 */
public interface LabelService {

    List<Label> likeLaber(String laberName);

}
