package com.xinverse.service.impl;

import com.xinverse.common.ServerResponse;
import com.xinverse.pojo.ShuDu;
import com.xinverse.service.IToolService;
import com.xinverse.util.ShuDuUtil;
import org.springframework.stereotype.Service;

@Service("iToolService")
public class ToolServiceImpl implements IToolService{
    @Override
    public ServerResponse<Integer[][]> shuDuCalculate(ShuDu shuDu) {
        if (shuDu.getData() == null) return ServerResponse.createByErrorMessage("输入有误");
        Integer result[][] = ShuDuUtil.solve(shuDu.getData());
        if (result == null) {
            return ServerResponse.createByErrorMessage("本输入无解");
        }
        return ServerResponse.createBySuccess("有解！", result);
    }
}
