package com.SpringCloud.controller;


import com.SpringCloud.entity.form.Result;
import com.SpringCloud.service.Impl.DistributeSeckillService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.queue.DistributedIdQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")

@RequestMapping("/api/seckill_Dis")
public class SeckillDistributeController {
//    线程池？？？
@Autowired
private DistributeSeckillService distributeSeckillService;
    @PostMapping("/redission/{goodsId}")
    public Result<Integer> list(@PathVariable("goodsId") long goodsId, long userId) {
        Boolean bool=distributeSeckillService.seckillRedission(goodsId,userId);

        return null;



    }



    }
