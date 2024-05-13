package com.xazhao.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description Created on 2024/05/11.
 * @Author xaZhao
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AlipayPropertiesTest {


    @Resource
    private Environment properties;

    @Test
    public void getAlipayPropertiesTest() {

        log.info(properties.getProperty("merchant-private-key"));
    }
}
