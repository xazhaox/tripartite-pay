package com.xazhao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Created on 2024/05/07.
 * @Author xaZhao
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pay {

    /**
     * 支付平台
     */
    public String payType;
}
