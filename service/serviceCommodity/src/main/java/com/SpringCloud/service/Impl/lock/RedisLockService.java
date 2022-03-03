//package com.SpringCloud.service.Impl.lock;
//
//import org.redisson.Redisson;
//import org.redisson.api.RLock;
//import org.redisson.api.RReadWriteLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RedisLockService {
//    @Autowired
//   private StringRedisTemplate stringRedisTemplate;
//
//
//
//    @Autowired
//    private RedissonClient redissonClient;
//    public Long DecrLock(long goodsId) {
//        RLock lock=redissonClient.getLock("decr");
//        long stock=0;
//        lock.lock();
//        try{
//            ValueOperations<String,String> op=stringRedisTemplate.opsForValue();
//
//            op.decrement("GoodsKey:gs" + goodsId);
//            stock=Long.parseLong(op.get("GoodsKey:gs" + goodsId));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//        return stock;
//
//
//
//
//    }
//    public  void  setLock(long goodsId,long num) {
//        RReadWriteLock rwlock = redissonClient.getReadWriteLock("anyRWLock");
//// 最常见的使用方法
////        rwlock.readLock().lock();
//// 或
//        rwlock.writeLock().lock();
//        ValueOperations<String,String> op=stringRedisTemplate.opsForValue();
//
//        op.decrement("GoodsKey:gs" + goodsId);
//        op.set("GoodsKey:gs" + goodsId,String.valueOf(num));
//        rwlock.writeLock().unlock();
//
//
//
//    }
//
//
//
//}
