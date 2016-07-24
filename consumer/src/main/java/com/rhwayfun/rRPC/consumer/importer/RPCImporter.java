package com.rhwayfun.rRPC.consumer.importer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by rhwayfun on 16-7-24.
 */
public class RPCImporter<T> {

    public T importer(final Class<?> serviceClass, final InetSocketAddress address){
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectOutputStream output = null;
                        ObjectInputStream input = null;
                        try {
                            socket = new Socket();
                            socket.connect(address);
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);
                            input = new ObjectInputStream(socket.getInputStream());
                            return input.readObject();
                        }finally {
                            if (socket != null){
                                socket.close();
                            }
                            if (output != null){
                                output.close();
                            }
                            if (input != null){
                                input.close();
                            }
                        }
                    }
                });
    }
}
