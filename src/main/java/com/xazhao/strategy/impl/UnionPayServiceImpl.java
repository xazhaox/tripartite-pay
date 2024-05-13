package com.xazhao.strategy.impl;

import com.xazhao.common.InvokeResult;
import com.xazhao.entity.Pay;
import com.xazhao.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 银联支付，@Component("UnionPay")修改了Bean的默认命名，当前Bean的名称为UnionPay
 *
 * @Description Created on 2024/05/08.
 * @Author xaZhao
 */

@Slf4j
@Component("UnionPay")
public class UnionPayServiceImpl implements PayStrategy {

    /**
     * 支付平台实现支付功能
     *
     * @param pay       支付数据
     * @param resultMap 返回结果
     * @return 支付结果
     */
    @Override
    public InvokeResult pay(Pay pay, Map<String, Object> resultMap) {

        log.info("{} 支付.", pay.getPayType());

        return InvokeResult.success(resultMap, pay.getPayType() + " 支付.");
    }
}
