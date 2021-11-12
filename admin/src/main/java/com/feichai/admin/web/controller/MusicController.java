package com.feichai.admin.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feichai.admin.dao.MusicDao;
import com.feichai.admin.domain.MusicDTO;
import com.feichai.admin.utils.Objects;
import com.feichai.admin.web.vo.MusicVO;
import com.feichai.basejar.commons.CommonResult;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/music")
public class MusicController {
    @Autowired
    Gson gson;

    @Autowired
    MusicDao musicDao;

    @PostMapping("/query")
    public String query(@RequestBody MusicVO vo) throws IllegalAccessException {
        Map map = Objects.beansToMap(vo);
        List<MusicDTO> dto = musicDao.selectByMap(map);

        return gson.toJson(CommonResult.success(dto));
    }

    @PostMapping("/mock")
    public String mock(@RequestBody MusicVO vo) throws IllegalAccessException {
        QueryWrapper<MusicDTO> wrapper = new QueryWrapper();
        wrapper.like(vo.getName() != null, "NAME", vo.getName()).or()
                .like(vo.getSinger() != null,"SINGER", vo.getSinger()).or()
                .like(vo.getAlbum() != null, "ALBUM", vo.getAlbum());
        List<MusicDTO> dto = musicDao.selectList(wrapper);

        return gson.toJson(CommonResult.success(dto));
    }


    @PostMapping("/insert")
    public String insert(@RequestBody MusicVO vo) {

        int dto = musicDao.insert(vo);

        return gson.toJson(CommonResult.success(dto));
    }

    @PostMapping("/update")
    public String update(@RequestBody MusicVO vo) {

        int dto = musicDao.updateById(vo);

        return gson.toJson(CommonResult.success(dto));
    }

    @PostMapping("/delete")
    public String delete(String id) {

        int dto = musicDao.deleteById(id);

        return gson.toJson(CommonResult.success(dto));
    }
}
