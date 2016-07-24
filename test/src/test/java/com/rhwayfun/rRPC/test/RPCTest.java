package com.rhwayfun.rRPC.test;

import com.rhwayfun.rRPC.consumer.importer.RPCImporter;
import com.rhwayfun.rRPC.provider.exporter.RPCExporter;
import com.rhwayfun.rRPC.service.EchoService;
import com.rhwayfun.rRPC.service.impl.EchoServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by rhwayfun on 16-7-24.
 */
public class RPCTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RPCExporter.exporter("localhost",8088);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RPCImporter<EchoService> importer = new RPCImporter<EchoService>();
        EchoService echoService = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echoService.echo("Are you ok ?"));
    }
}
