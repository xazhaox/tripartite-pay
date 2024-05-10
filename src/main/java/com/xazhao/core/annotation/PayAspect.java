package com.xazhao.core.annotation;

import java.lang.annotation.*;

/**
 * 自定义支付切面注解，支持支付前置/后置操做
 *
 * @Description Created on 2024/05/09.
 * @Author xaZhao
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PayAspect {
}
