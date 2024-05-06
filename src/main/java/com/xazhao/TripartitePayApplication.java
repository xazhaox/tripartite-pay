package com.xazhao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description Created on 2024/05/06.
 * @Author xaZhao
 */

@Slf4j
@MapperScan("com.xazhao.mapper")
@SpringBootApplication
public class TripartitePayApplication {

    public static void main(String[] args) {

        SpringApplication.run(TripartitePayApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  tripartite-pay启动成功...   ლ(´ڡ`ლ)ﾞ");
    }
}
