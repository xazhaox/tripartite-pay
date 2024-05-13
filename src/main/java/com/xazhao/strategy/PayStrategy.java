package com.xazhao.strategy;

import com.xazhao.common.InvokeResult;
import com.xazhao.entity.Pay;

import java.util.Map;

/**
 * 支付策略接口
 *
 * @Description Created on 2024/05/08.
 * @Author xaZhao
 */

public interface PayStrategy {

    /**
     * 支付平台实现各自的支付功能
     *
     * @param pay       支付数据
     * @param resultMap 返回结果
     * @return 支付结果
     */
    InvokeResult pay(Pay pay, Map<String, Object> resultMap);
}
