//package com.SpringCloud.service.Impl.lock;
//
//import com.SpringCloud.entity.form.Goods;
//import com.SpringCloud.entity.form.Order;
//import com.SpringCloud.mapper.GoodsMapper;
//import com.SpringCloud.mapper.OrderMapper;
//import com.SpringCloud.service.SeckilGrabService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GrabServiceMysqlLockImpl extends ServiceImpl<GoodsMapper, Goods> implements SeckilGrabService {
//
//    @Override
//
//    @Override
//    public String gradOrder(int goodsId, int userId){
//        try{
//            System.out.println("用户"+userId+"执行请求");
//            boolean b=grad(goodsId,userId);
//            if(b){
//                System.out.println("成功用户"+userId+"抢单成功");
//            }else{
//                System.out.println("失败用户"+userId+"抢单失败");
//            }
//        }finally {
//
//
//        }
//        return "???";
//    }
//    @Autowired
//    private GoodsMapper goodsMapper;
//    @Autowired
//    private OrderMapper orderMapper;
//    public boolean grad(int goodsId, int userId) {
//        Goods goods = goodsMapper.selectById(goodsId);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int num = goods.getNum();
//        int id=Integer.parseInt(goods.getId());
//        if (num > 0) {
//
//            goodsMapper.reduceGoods(id);
//
//            Order order = new Order();
//            order.setDescription("用户" + userId + "拿到了小钱钱");
//            order.setStatus(1);
//            order.setUserId(userId);
//            orderMapper.insert(order);
//
//            return true;
//
//        }
//        return false;
//
//    }
//}
//
//
