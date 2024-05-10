package com.xazhao.controller;

import com.xazhao.common.InvokeResult;
import com.xazhao.core.annotation.PayAspect;
import com.xazhao.entity.Pay;
import com.xazhao.service.TripartitePayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 统一支付入口
 *
 * @Description Created on 2024/05/07.
 * @Author xaZhao
 */

@Slf4j
@RestController
@RequestMapping("/tripartite/pay")
public class PayController {

    @Resource
    private TripartitePayService tripartitePayService;

    /**
     * 第三方支付平台统一支付入口
     *
     * @param pay 支付平台
     * @return 支付结果
     */
    @PostMapping("/entrance")
    @PayAspect
    public InvokeResult tripartitePay(@RequestBody Pay pay) {

        return tripartitePayService.tripartitePayUnifiedInterface(pay);
    }
}
