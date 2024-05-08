package com.xazhao.service;

import com.xazhao.common.InvokeResult;
import com.xazhao.entity.Pay;

/**
 * 第三方支付平台统一支付入口
 *
 * @Description Created on 2024/05/07.
 * @Author xaZhao
 */

public interface TripartitePayService {

    /**
     * 第三方支付平台统一支付入口
     *
     * @param pay 支付平台
     * @return 支付结果
     */
    InvokeResult tripartitePayUnifiedInterface(Pay pay);
}
