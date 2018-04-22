package com.xinverse.service;

import com.xinverse.common.ServerResponse;
import com.xinverse.pojo.ShuDu;

public interface IToolService {
    ServerResponse<Integer[][]> shuDuCalculate(ShuDu shuDu);

    ServerResponse<String> encode(String origin, String algorithm);

    ServerResponse<String> UUID();
}
