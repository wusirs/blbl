package com.heisenberg.blbl.config;

import com.heisenberg.blbl.common.SocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-03-28 16:29:29
 */
@Slf4j
@Component
public class ServerStarter implements ApplicationRunner {
    @Value("${netty.server.port}")
    private Integer port;
    @Value("${netty.server.bossThreads}")
    private Integer bossThreads;
    @Value("${netty.server.workerThreads:-1}")
    private Integer workerThreads;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            new SocketServer(port, bossThreads, workerThreads);
        }catch (Exception e){
            log.info("服务端启动异常：{}", e.getMessage(), e);
        }
    }
}

