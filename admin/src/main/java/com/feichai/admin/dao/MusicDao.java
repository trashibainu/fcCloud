package com.feichai.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feichai.admin.domain.MusicDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicDao extends BaseMapper<MusicDTO> {
}
