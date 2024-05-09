package com.xazhao.strategy.impl;

import com.xazhao.common.InvokeResult;
import com.xazhao.entity.Pay;
import com.xazhao.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 工商银行
 *
 * @Description Created on 2024/05/09.
 * @Author xaZhao
 */

@Slf4j
@Component("ICBC")
public class IndustrialCommercialBankServiceImpl implements PayStrategy {

    @Override
    public InvokeResult pay(Pay pay) {

        log.info("{} 支付.", pay.getPaymentPlatform());

        return InvokeResult.success(null, pay.getPaymentPlatform() + " 支付.");
    }
}
