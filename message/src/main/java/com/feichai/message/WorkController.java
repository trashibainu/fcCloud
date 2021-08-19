package com.feichai.message;

import com.feichai.message.service.WorkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Resource
    WorkService workService;

    @GetMapping("/status")
    public String status() {
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        return "test.ok";
    }

    @GetMapping("/service")
    public String service() {
        return workService.work();
    }
}
