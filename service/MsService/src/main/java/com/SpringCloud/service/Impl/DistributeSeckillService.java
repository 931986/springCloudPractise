package com.SpringCloud.service.Impl;


import com.SpringCloud.entity.form.GoodsVo;
import com.SpringCloud.entity.form.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringCloud.redission.RedisLockUtil;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DistributeSeckillService {


    //减库存 下订单 写入秒杀订单
//        seckillService.seckill(user, goodsVo);
    @Autowired
    private SeckillService seckillService;
    public Boolean seckillRedission(long goodsId,long userId) {
        boolean flag=false;

        try{
            flag =RedisLockUtil.tryLock(goodsId + "", TimeUnit.SECONDS, 3, 20);
        if(flag){
            seckillService.seckill(goodsId,userId);
        }

        }catch (Exception e){

        }finally {
            RedisLockUtil.unlock(goodsId+"");
        }
        return true;
    }



    }
