package com.example.repository.common;

import com.example.domail.common.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author   : while
 * @date     : 2017/11/8
 * @describe :
 */
public interface LaberRepository extends JpaRepository<Label, Integer > {

    @Query( value = "SELECT l.id, l.label_name, l.type FROM Label AS l WHERE l.label_name LIKE ?" , nativeQuery = true)
    List< Label > like(String  name );

}
