package com.SpringCloud.Controller.api;


import com.SpringCloud.base.R;
import com.SpringCloud.base.Result;
import com.SpringCloud.entity.vo.CollectVo;
import com.SpringCloud.service.CollectService;
import com.SpringCloud.util.JwtInfo;
import com.SpringCloud.util.JwtUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")
@RequestMapping("/api/collect")
public class CommodityCollectController {
    @Autowired
    private CollectService collectService;
    @ApiOperation("判定收藏")
    @PostMapping("isCollect/{commodityId}")
    public R isCollect(@ApiParam(name = "commodityId",value = "commodityId",required = true)
                           @PathVariable String commodityId, HttpServletRequest request){
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        if(jwtInfo==null){
            JwtInfo temp=new JwtInfo();
            temp.setId("12");
            jwtInfo=temp;
        }
           boolean collectStatus=collectService.isCollect(commodityId,jwtInfo.getId());
        return R.ok().data("是否收藏",collectStatus);
    }
    @PostMapping("SaveCollect/{commodityId}")
    public R SaveCollect(@ApiParam(name = "commodityId",value = "commodityId",required = true)
                       @PathVariable String commodityId, HttpServletRequest request){
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        if(jwtInfo==null){
            JwtInfo temp=new JwtInfo();
            temp.setId("12");
            jwtInfo=temp;
        }
        collectService.saveCollect(commodityId,jwtInfo.getId());
        return R.ok().message("收藏成功");
    }
    @PostMapping("RemoveCollect/{commodityId}")
    public R RemoveCollect(@ApiParam(name = "commodityId",value = "commodityId",required = true)
                         @PathVariable String commodityId, HttpServletRequest request){
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        if(jwtInfo==null){
            JwtInfo temp=new JwtInfo();
            temp.setId("12");
            jwtInfo=temp;
        }
        collectService.removeCollect(commodityId,jwtInfo.getId());
        return R.ok().message("取消收藏");
    }


    @PostMapping("SelectCollect/{memberId}")
    public R SelectCollect(@ApiParam(name = "memberId",value = "memberId",required = true)
                         @PathVariable String  memberId){


      List<CollectVo> select_Commodity=collectService.selectCollect(memberId);
        return R.ok().data("查询成功",select_Commodity);
    }
//        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);

}
