package com.SpringCloud.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.vod.v20180717.VodClient;

public class VodSDKUtils {

    public  static  VodClient initVodClient(String secretId,String secretkey){
        Credential credential=new Credential(secretId,secretkey);
        VodClient client=new VodClient(credential,"ap-chongqing");
        return client;


    }
}
