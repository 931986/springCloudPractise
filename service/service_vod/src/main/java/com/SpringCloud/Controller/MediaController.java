package com.SpringCloud.Controller;


import com.SpringCloud.base.R;
import com.SpringCloud.base.ResultCodeEnum;
import com.SpringCloud.exception.DetectException;
import com.SpringCloud.service.VideoService;
import com.SpringCloud.util.ExceptionUtils;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")

@RequestMapping("/api/video")
public class MediaController {

    @Autowired
    private VideoService videoService;
    @PostMapping("/removeFile/videoId")
    public R RemoveFile(@ApiParam(name = "removeVideo",required = true)
                            @PathVariable("videoId") String videoId){
        try {
            videoService.removeVideo(videoId);
            return R.ok().message("视频删除成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new DetectException(ResultCodeEnum.VIDEO_DELETE_TENCENT_ERROR);
        }

    }

}
