package com.tensquare.spit.controller;

import com.tensquare.spit.service.SpitService;
import com.tensquare.spit.pojo.Spit;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/21 11:07
 * Description:
 **/
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Spit> l = spitService.findAll();
        return new Result(true, StatusCode.OK,"查找成功",l);
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.GET)
    public Result findOne(@PathVariable String spitId){
        Spit spit = spitService.findById(spitId);
        return new Result(true, StatusCode.OK,"查找成功",spit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit){
        spitService.save(spit);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit,@PathVariable String spitId){
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String spitId){
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/comment/{parentid}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentid,@PathVariable int page,@PathVariable int size){
        Page<Spit> pageList = spitService.findByParentid(parentid,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(pageList.getTotalElements(),pageList.getContent()));
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/thumbup/{id}",method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        String userId = "sh0rk";
        if (redisTemplate.opsForValue().get("thumbup_"+userId)!=null) {
            return new Result(false, StatusCode.REPERROR,"不能重复点赞");
        }
        spitService.updateThumbup(id);
        redisTemplate.opsForValue().set("thumbup_"+userId,1);
        return new Result(true, StatusCode.OK,"点赞成功");
    }
}
