package com.SpringCloud.service.Impl.lock;

import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.GoodsInfo;
import com.SpringCloud.entity.form.GoodsVo;
import com.SpringCloud.mapper.GoodsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    //乐观锁冲突最大重试次数
    private static final int DEFAULT_MAX_RETRIES = 5;

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 查询商品列表
     *
     * @return
     */
    public List<GoodsVo> listGoodsVo() {
        return goodsMapper.listGoodsVo();
    }

    /**
     * 根据id查询指定商品
     *
     * @return
     */
    public GoodsVo getGoodsByGoodsId(long goodsId) {
        Goods goods=ListGoodSeckill(goodsId);
//        System.out.println(goods);
        //        信息库  对应 goodscenter
        GoodsInfo goodsInfo=getGoodsInfoByGoodsId(goodsId);
//        System.out.println(goodsInfo);
        GoodsVo goodsVo=new GoodsVo();
        BeanUtils.copyProperties(goodsInfo,goodsVo);
        BeanUtils.copyProperties(goods,goodsVo);
        System.out.println(goodsVo);
        return goodsVo;

//        return goodsMapper.selectByGoodsId(goodsId);
    }
    public GoodsInfo getGoodsInfoByGoodsId(long goodsId) {
        return goodsMapper.listGoodsInfo(goodsId);
    }
    public Goods ListGoodSeckill(long goodsId) {
        return goodsMapper.ListGoodsSeckill(goodsId);
    }




    /**
     * 减少库存，每次减一
     *
     * @return
     */
    public boolean reduceStock(GoodsVo goods) {
        int numAttempts = 0;
        int ret = 0;
        Goods sg = new Goods();
        sg.setGoodsId(goods.getGoodsId());
        sg.setVersion(goods.getVersion());
        do {
            numAttempts++;
            try {
//                sg.setVersion(goodsMapper.selectById(goods.getId()).getVersion());
                System.out.println("???"+goods.getGoodsId());
                sg.setVersion(goodsMapper.getVersionByGoodsId(goods.getGoodsId()));


                ret = goodsMapper.reduceStockByVersion(sg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ret != 0)
                break;
        } while (numAttempts < DEFAULT_MAX_RETRIES);

        return ret > 0;
    }
}