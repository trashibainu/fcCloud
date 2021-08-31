package com.feichai.message;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.feichai.message.service.WorkService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GlobalTransactional(name = "work_transaction",rollbackFor = Exception.class)
    public String service() {
        return workService.work();
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey",blockHandler = "deal_hotKey")
    public String hotKey(@RequestParam(value="key", required = false) String key,
                         @RequestParam(value="value", required = false) String value) {
        return "key :"+key+"\t  value: "+value;
    }

    public String deal_hotKey(String key, String value, BlockException blockException){
        return "Exception:"+blockException.getMessage();
    }
}
