package com.SpringCloud.feign.fallback;


import com.SpringCloud.Dto.CommodityDto;
import com.SpringCloud.base.R;
import com.SpringCloud.feign.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Service
@RequestMapping("fallback/commodity/")

public class CommodityServiceFallback implements CommodityService {
    @Override
    public CommodityDto GetCommodityDtoById( String commodityId){
   log.info("熔断保护");
   return null;
    }
//    @GetMapping("/api/edu/course/inner/update-buy-count/{id}")
    @Override
    public R updateBuyCountById(String id) {
        log.error("熔断器被执行");
        return R.error();
    }

}
