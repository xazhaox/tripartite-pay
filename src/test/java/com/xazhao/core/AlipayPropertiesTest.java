package com.xazhao.core;

import cn.hutool.core.date.DateUtil;
import com.xazhao.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void getOffsetDay() {

        String format = DateUtil.format(DateUtil.offsetDay(new Date(), 180), Constant.NORM_DATETIME_PATTERN);
        log.info(format);

        List<String> insurance = new ArrayList<>();
        insurance.add("V001");
        insurance.add("V002");
        insurance.add("V003");
        insurance.add("V004");
        insurance.add("V016");
        insurance.add("V006");
        insurance.add("V012");
        insurance.add("V008");
        List<Integer> versionList = new ArrayList<>();
        insurance.forEach(caSubInsurance ->
                versionList.add(Integer.parseInt(caSubInsurance.split("V")[0])));

        log.info(versionList.toString());
    }
}
