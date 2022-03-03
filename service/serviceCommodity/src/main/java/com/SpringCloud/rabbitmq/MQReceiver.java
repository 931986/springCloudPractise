package com.SpringCloud.rabbitmq;

import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.GoodsVo;
import com.SpringCloud.entity.form.User;
import com.SpringCloud.redis.redis.RedisService;
import com.SpringCloud.service.Impl.OrderService;
import com.SpringCloud.service.Impl.SeckillService;
import com.SpringCloud.service.Impl.lock.GoodsService;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangyunxiong on 2018/5/29.
 */
@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);


    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    SeckillService seckillService;

    @RabbitListener(queues=MQConfig.QUEUE)
    public void receive(String message){
        log.info("receive message:"+message);
        SeckillMessage m = RedisService.stringToBean(message, SeckillMessage.class);
        User user=new User();
        user.setId((int)m.getId());
       long goodsId = m.getGoodsId();
        System.out.println("receive"+ goodsId);

        GoodsVo goodsVo = goodsService.getGoodsByGoodsId(m.getGoodsId());

        System.out.println("goodsvo.Goodsid"+ goodsVo.getGoodsId());
         long stock = goodsVo.getNum();
        if(stock <= 0){
            return;
        }
        goodsVo.setGoodsId(goodsId);
        System.out.println("goodsvo"+goodsVo);

        //判断重复秒杀
//        SeckillOrder order = orderService.getOrderByUserIdGoodsId(user.getId(), goodsId);
//        if(order != null) {
//            return;
//        }


        //减库存 下订单 写入秒杀订单
        seckillService.seckill(user, goodsVo);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message) {
        log.info(" topic  queue1 message:" + message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message) {
        log.info(" topic  queue2 message:" + message);
    }
}
