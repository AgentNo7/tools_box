package com.xinverse.service.impl;

import com.xinverse.common.ServerResponse;
import com.xinverse.pojo.ShuDu;
import com.xinverse.service.IToolService;
import com.xinverse.util.MD5Util;
import com.xinverse.util.ShuDuUtil;
import com.xinverse.util.UUIDUtil;
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

    @Override
    public ServerResponse<String> encode(String origin, String algorithm) {
        if ("MD5".equals(algorithm)) {
            return ServerResponse.createBySuccess(MD5Util.MD5EncodeUtf8(origin));
        } else if ("SHA-1".equals(algorithm)) {
            return ServerResponse.createBySuccess(MD5Util.SHA1EncodeUtf8(origin));
        } else if ("SHA-256".equals(algorithm)) {
            return ServerResponse.createBySuccess(MD5Util.SHA256EncodeUtf8(origin));
        } else {
            return ServerResponse.createByErrorMessage("不支持的算法，或输入错误！");
        }
    }

    @Override
    public ServerResponse<String> UUID() {
        return ServerResponse.createBySuccess(UUIDUtil.UUID());
    }
}
