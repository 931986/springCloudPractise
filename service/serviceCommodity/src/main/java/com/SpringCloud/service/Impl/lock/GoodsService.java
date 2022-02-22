package com.SpringCloud.service.Impl.lock;

import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.mapper.GoodsMapper;
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
    public List<Goods> listGoodsVo() {
        return goodsMapper.listGoodsVo();
    }

    /**
     * 根据id查询指定商品
     *
     * @return
     */
    public Goods getGoodsByGoodsId(long goodsId) {
        return goodsMapper.selectByGoodsId(goodsId);
    }

    /**
     * 减少库存，每次减一
     *
     * @return
     */
    public boolean reduceStock(Goods goods) {
        int numAttempts = 0;
        int ret = 0;
        Goods sg = new Goods();
        sg.setGoods_id(goods.getGoods_id());
        sg.setVersion(goods.getVersion());
        do {
            numAttempts++;
            try {
//                sg.setVersion(goodsMapper.selectById(goods.getId()).getVersion());
                System.out.println("???"+goods.getGoods_id());
                sg.setVersion(goodsMapper.getVersionByGoodsId(goods.getGoods_id()));


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