package com.SpringCloud.mapper;

import com.SpringCloud.entity.Collect;
import com.SpringCloud.entity.vo.CollectVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper extends BaseMapper<Collect> {

    List<CollectVo> selectPageByMemberId(String memberId);
}
