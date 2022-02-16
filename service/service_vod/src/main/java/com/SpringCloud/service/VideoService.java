package com.SpringCloud.service;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
public interface VideoService  {
    void removeVideo(String videoId) throws TencentCloudSDKException;
    void removeVideoByIdList(List<String> videoIdList);

}
