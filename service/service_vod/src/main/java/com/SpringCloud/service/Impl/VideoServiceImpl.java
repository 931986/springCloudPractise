package com.SpringCloud.service.Impl;

import com.SpringCloud.base.ResultCodeEnum;
import com.SpringCloud.service.VideoService;
import com.SpringCloud.util.VodSDKUtils;
import com.SpringCloud.util.vodProperties;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;

import java.util.List;

public class VideoServiceImpl implements VideoService {

    @Override
    public void removeVideo(String videoId) throws TencentCloudSDKException {
      vodProperties vodProperties=new vodProperties();
        VodClient vodClient = VodSDKUtils.initVodClient(vodProperties.getSecretId(), vodProperties.getSecretkey());
        // 删除的对象
        DeleteMediaRequest request = new DeleteMediaRequest();
        request.setFileId(videoId);
        try {
            vodClient.DeleteMedia(request);
        } catch (TencentCloudSDKException e) {
//            throw new TencentCloudSDKException;

        }
    }

    @Override
    public void removeVideoByIdList(List<String> videoIdList) {

    }
}
