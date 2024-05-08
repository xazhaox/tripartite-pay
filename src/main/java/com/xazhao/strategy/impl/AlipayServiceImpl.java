package com.xazhao.strategy.impl;

import com.xazhao.common.InvokeResult;
import com.xazhao.entity.Pay;
import com.xazhao.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <h3>支付宝</h3> @Component("Alipay")修改了Bean的默认命名，当前Bean的名称为Alipay，也可使用@Service("Alipay")
 *
 * @Description Created on 2024/05/08.
 * @Author xaZhao
 */

@Slf4j
@Component("Alipay")
public class AlipayServiceImpl implements PayStrategy {

    @Override
    public InvokeResult pay(Pay pay) {

        log.info("{} 支付.", pay.getPaymentPlatform());

        return InvokeResult.success(null, pay.getPaymentPlatform() + " 支付.");
    }
}
