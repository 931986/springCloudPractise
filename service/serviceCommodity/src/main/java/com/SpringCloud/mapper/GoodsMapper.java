package com.SpringCloud.mapper;


import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.GoodsInfo;
import com.SpringCloud.entity.form.GoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {


    @Select("select * from Goods_center where id= #{goodsId}")
    public GoodsInfo listGoodsInfo(@Param("goodsId")long goodsId);

void reduceGoods(@Param("id") long id);
List<Goods> findAll();
    @Select("select g.*, sg.num, sg.start_date, sg.end_date, sg.seckill_price, sg.version from Goods_seckill_center sg left join Goods_center g on sg.goods_id = g.id")
    public List<GoodsVo> listGoodsVo();
//    这一步其实是秒杀库和商品库分离
    //stock_count > 0 和 版本号实现乐观锁 防止超卖
//@Update("update sk_goods_seckill set stock_count = stock_count - 1, version= version + 1 where goods_id = #{goodsId} and stock_count > 0 and version = #{version}")

@Update("update Goods_seckill_center set num = num - 1, version= version + 1 where goods_id = #{goodsId} and num > 0 and version = #{version}")
    public int reduceStockByVersion(Goods seckillGoods);

    // 获取最新版本号
    @Select("select version from Goods_seckill_center  where goods_id = #{goodsId}")
    public int getVersionByGoodsId(@Param("goodsId") long goodsId);

    @Select("select * from Goods_seckill_center  where goods_id = #{goodsId}")
     public GoodsVo selectByGoodsId(@Param("goodsId") long goodsId);

    @Select("select * from Goods_seckill_center  where goods_id= #{goodsId}")
    Goods ListGoodsSeckill(@Param("goodsId")long goodsId);
}
