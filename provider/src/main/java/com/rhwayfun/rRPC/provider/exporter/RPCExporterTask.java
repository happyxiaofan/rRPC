package com.rhwayfun.rRPC.provider.exporter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by rhwayfun on 16-7-24.
 */
public class RPCExporterTask implements Runnable {
    private Socket client = null;

    public RPCExporterTask(Socket client) {
        this.client = client;
    }

    public void run() {
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(client.getInputStream());
            output = new ObjectOutputStream(client.getOutputStream());

            String serviceName = input.readUTF();
            Class<?> service = Class.forName(serviceName);
            String methodName = input.readUTF();
            Class<?>[] parametersType = (Class<?>[]) input.readObject();
            Object[] arguments = (Object[]) input.readObject();
            Method method = service.getMethod(methodName, parametersType);
            Object result = method.invoke(service.newInstance(), arguments);

            output.writeObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
