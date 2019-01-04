package com.wcs.start.start.annotation;

import java.lang.annotation.*;

/**
 * TODO 类描述
 *
 * @author pro
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterValid {

//    Class<?> type();

    String msg();

    boolean request() default true;

    boolean isEmpty() default true;

    boolean isBlank() default true;

    boolean isNull() default false;

    int min() default 0;

    int max() default 0;

    int[] section() default {0, 0};

    boolean isMin() default false;

    boolean isMax() default false;

    boolean isSection() default false;

    boolean isInfrared() default false;
}