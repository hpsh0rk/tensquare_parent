package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/21 11:02
 * Description:
 **/
public interface SpitDao extends MongoRepository<Spit,String> {
    public Page<Spit> findByParentid(String prentid, Pageable pageable);
}
