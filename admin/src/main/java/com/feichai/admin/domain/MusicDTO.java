package com.feichai.admin.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("music")
public class MusicDTO {

    @TableId
    private String id;
    private String name;
    private String singer;
    private String album;
    private String type;
}
