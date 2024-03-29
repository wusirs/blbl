package com.heisenberg.blbl;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-03-20 23:23:23
 */
class BIOTest {
    @Test
    void BIOTest() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);
        System.out.println("服务器启动成功");
        while (true) {
            System.out.println("等待连接");
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了");
            new Thread(() -> {
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void handler(Socket clientSocket) throws IOException {
        System.out.println("处理客户端的请求");
        byte[] data = new byte[1024];
        int read = clientSocket.getInputStream().read(data);
        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(data, 0, read));
        }
    }
}


