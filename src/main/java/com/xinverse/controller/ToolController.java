package com.xinverse.controller;

import com.xinverse.common.ServerResponse;
import com.xinverse.pojo.ShuDu;
import com.xinverse.service.IToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/tool/")
public class ToolController {

    @Autowired
    IToolService iToolService;

    @RequestMapping("shuducal.do")
    @ResponseBody
    public ServerResponse<Integer[][]> shuDuCalculate(ShuDu shuDu, HttpServletRequest request, HttpServletResponse response) {
        return iToolService.shuDuCalculate(shuDu);
    }
}
