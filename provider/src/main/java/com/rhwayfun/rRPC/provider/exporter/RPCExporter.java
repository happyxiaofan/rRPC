package com.rhwayfun.rRPC.provider.exporter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by rhwayfun on 16-7-24.
 */
public class RPCExporter {
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName, int port) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(hostName,port));
        try {
            executor.execute(new RPCExporterTask(server.accept()));
        }finally {
            server.close();
        }
    }
}
