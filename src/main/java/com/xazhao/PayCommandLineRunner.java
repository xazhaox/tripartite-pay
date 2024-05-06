package com.xazhao;

import com.xazhao.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;

/**
 * @Description Created on 2024/05/06.
 * @Author xaZhao
 */

@Slf4j
@Component
public class PayCommandLineRunner implements CommandLineRunner {

    @Resource
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {

        // ip
        String ip = InetAddress.getLocalHost().getHostAddress();
        // port
        String port = environment.getProperty("server.port");

        String activitiDesignerUrl = Constant.HTTP + Constant.LOCAL_HOST + ":" + port + "/index.html";

        log.info("Mainstream payment platform：{}", activitiDesignerUrl);
    }
}
