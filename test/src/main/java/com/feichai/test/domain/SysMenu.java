package com.feichai.test.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysMenu {
    private int menuId;
    private String menuName;
    private int parentId;
    private int orderNum;
    private String path;
    private String component;
    private int menuType;
    private String perms;
    private String icon;
    private String remark;
}
