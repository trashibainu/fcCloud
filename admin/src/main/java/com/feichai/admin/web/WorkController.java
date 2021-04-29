package com.feichai.admin.web;

import com.feichai.admin.common.core.domain.AjaxResult;
import com.feichai.admin.common.core.domain.entity.SysRole;
import com.feichai.admin.common.core.domain.entity.SysUser;
import com.feichai.admin.common.utils.StringUtils;
import com.feichai.admin.system.service.ISysUserService;
import com.feichai.basejar.commons.CommonResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private ISysUserService userService;
    @Resource
    Gson gson;


    /**
     * 根据用户编号获取详细信息
     */
    @GetMapping(value = { "/{userId}"})
    @ResponseBody
    public String getInfo(@PathVariable(value = "userId", required = false) Long userId)
    {
        SysUser sysUser=userService.selectUserById(userId);
        return gson.toJson(CommonResult.success(sysUser));
    }
}
