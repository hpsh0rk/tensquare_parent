package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/19 16:44
 * Description:
 **/
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
