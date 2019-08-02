package com.zhumingbei.babybei_server.controller;

import com.zhumingbei.babybei_server.bean.HelpInfo;
import com.zhumingbei.babybei_server.service.HelpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelpInfoController {
    @Autowired
    private HelpInfoService helpInfoService;
    private int limit = 10;

    @GetMapping(value = "helpInfo/{type}")
    public List<HelpInfo> getInfo(@PathVariable("type") Integer type, @RequestParam(value = "page",required = false) Integer page) {
        if(page == null){
            page = 0;
        }
        return helpInfoService.getInfo(type, limit, page * limit);
    }

}
