package com.xinverse.controller;

import com.xinverse.common.ServerResponse;
import com.xinverse.pojo.ShuDu;
import com.xinverse.service.IToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tool/")
public class ToolController {

    @Autowired
    IToolService iToolService;

    @RequestMapping("shuducal.do")
    @ResponseBody
    public ServerResponse<Integer[][]> shuDuCalculate(ShuDu shuDu) {
        return iToolService.shuDuCalculate(shuDu);
    }

    @RequestMapping("encode.do")
    @ResponseBody
    public ServerResponse<String> encode(String origin, String algorithm) {
        return iToolService.encode(origin, algorithm);
    }

    @RequestMapping("uuid.do")
    @ResponseBody
    public ServerResponse<String> uuid() {
        return iToolService.UUID();
    }
}
