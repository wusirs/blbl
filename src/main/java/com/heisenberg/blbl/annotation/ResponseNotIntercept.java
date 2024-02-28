package com.heisenberg.blbl.annotation;

import java.lang.annotation.*;

/**
 * 在类和方法上使用该注解，不会在ResponseResult类中进一步封装返回值，直接返回原生值
 * @author Heisenberg
 * @date 2024-02-28 20:38
 * @version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseNotIntercept {
    String value() default "";
}
