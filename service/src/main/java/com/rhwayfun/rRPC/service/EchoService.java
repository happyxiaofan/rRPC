package com.rhwayfun.rRPC.service;

/**
 * Created by rhwayfun on 16-7-24.
 */
public interface EchoService {

    /**
     * 根据输入的值返回响应结果
     * @param msg
     * @return
     */
    String echo(String msg);
}
