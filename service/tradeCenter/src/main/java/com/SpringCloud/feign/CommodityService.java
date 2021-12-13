package com.SpringCloud.feign;


import com.SpringCloud.Dto.CommodityDto;
import com.SpringCloud.base.R;
import com.SpringCloud.feign.fallback.CommodityServiceFallback;
import com.baomidou.mybatisplus.extension.service.IService;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.CommonDataSource;


@Service

@FeignClient(value = "serviceCommodity",fallback = CommodityServiceFallback.class)
@RequestMapping(value = "/api/commodity")
// @RequestMapping("/api/commodity")
public interface CommodityService {
    @GetMapping("/inner/get/{commodityId}")
    public CommodityDto GetCommodityDtoById(@PathVariable("commodityId") String commodityId);

    @GetMapping("/api/trade/commodity/inner/update-buy-count/{id}")
    public R updateBuyCountById(@PathVariable("id") String id);
}
