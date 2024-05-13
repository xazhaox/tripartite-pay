package com.xazhao.core.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 微信支付电脑网页支付相关参数
 *
 * @Description Created on 2024/05/11.
 * @Author xaZhao
 */

@Slf4j
@Data
@Configuration
@PropertySource("classpath:application-pay.yaml")
@ConfigurationProperties(prefix = "pay.wechat")
public class WeChatProperties {

    /**
     * appID
     */
    private String appId;
}
