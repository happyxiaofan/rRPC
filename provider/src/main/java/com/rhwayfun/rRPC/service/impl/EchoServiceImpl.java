package com.rhwayfun.rRPC.service.impl;

import com.rhwayfun.rRPC.service.EchoService;

/**
 * Created by rhwayfun on 16-7-24.
 */
public class EchoServiceImpl implements EchoService {

    /**
     * 根据输入的信息返回响应结果
     * @param msg
     * @return
     */
    public String echo(String msg) {
        return msg != null ? msg + "--------> I am OK." : "I am OK." ;
    }
}
