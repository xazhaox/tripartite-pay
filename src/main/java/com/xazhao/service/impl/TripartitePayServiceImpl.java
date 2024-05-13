package com.xazhao.service.impl;

import com.xazhao.common.InvokeResult;
import com.xazhao.constant.PayConventions;
import com.xazhao.entity.Pay;
import com.xazhao.exception.ServiceException;
import com.xazhao.factory.PayStrategyFactory;
import com.xazhao.service.TripartitePayService;
import com.xazhao.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一支付入口实现
 *
 * @Description Created on 2024/05/07.
 * @Author xaZhao
 */

@Slf4j
@Service
public class TripartitePayServiceImpl implements TripartitePayService, PayConventions {

    @Resource
    private PayStrategyFactory payStrategyFactory;

    /**
     * 第三方支付平台统一支付入口
     *
     * @param pay 支付平台
     * @return 支付结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public InvokeResult tripartitePayUnifiedInterface(Pay pay) {

        String payType = pay.getPayType();

        if (StringUtils.isNotBlank(payType)) {
            try {

                // 获取支付策略（支付平台），这里获取到的实际上是PayStrategy的实现，因为@Component的别名是在具体的策略类中实现
                PayStrategy payStrategy = payStrategyFactory.getPayStrategy(payType);

                if (null == payStrategy) {
                    log.error(payType + " 平台未注册支付策略.");
                    return InvokeResult.failure(payType + " 平台未注册支付策略.");
                }

                // 返回支付平台，用于区别重定向页面到具体实现的第三方支付平台
                Map<String, Object> resultMap = new HashMap<>(16);
                resultMap.put(PAY_TYPE, payType);

                // 支付
                return payStrategy.pay(pay, resultMap);

            } catch (Exception e) {
                e.printStackTrace();
                // 若有事务参与，手动回滚事务
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

                throw new ServiceException("There is an exception in the Get Pay policy.");
            }
        }

        throw new ServiceException("未指定第三方支付平台.");
    }
}
