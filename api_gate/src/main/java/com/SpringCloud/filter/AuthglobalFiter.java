package com.SpringCloud.filter;

import com.google.common.primitives.Bytes;
import com.google.gson.JsonObject;
import net.bytebuddy.description.ByteCodeElement;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import  com.SpringCloud.util.JwtUtils;

import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class AuthglobalFiter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request=exchange.getRequest();
        String path=request.getURI().getPath();
        AntPathMatcher antPathMatcher=new AntPathMatcher();
        if(antPathMatcher.match("/api/**/auth",path)){
            List<String> TokenList=request.getHeaders().get("token");
         if(TokenList==null){
             return out(exchange.getResponse());
         }
            Boolean isChecked=JwtUtils.checkToken(TokenList.get(0));


        }

//        api接口，校验token
        return null;
    }
//    response 转 mono
public Mono<Void> out(ServerHttpResponse response){

        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success",false);
    jsonObject.addProperty("code","28004");
    jsonObject.addProperty("data","");
    jsonObject.addProperty("message","鉴权/登录失败");
    byte[] bytes=jsonObject.toString().getBytes(StandardCharsets.UTF_8);
    DataBuffer dataBuffer=response.bufferFactory().wrap(bytes);
    response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
    return response.writeWith(Mono.just(dataBuffer));


}




    @Override
    public int getOrder() {
        return 0;
    }
}
