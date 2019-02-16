package com.wcs.start.start.aspect;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wcs.start.start.annotation.ParameterValid;
import com.wcs.start.start.annotation.PathAndQueryParamValid;

import javassist.NotFoundException;

/**
 * TODO 类描述
 *
 * @author pro
 */
@Aspect
@Component
public class PathAndQueryParamValidAspect {

    private static final Logger logger = LoggerFactory.getLogger(
            PathAndQueryParamValidAspect.class);

    @Resource
    private ParamValidSupport support;

    @Before("@annotation(paramValid)")
    public void paramValid(JoinPoint joinPoint, PathAndQueryParamValid paramValid) {
        String className = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] param = joinPoint.getArgs();
        try {
            List<String> errorLists = support.get().validate(className, methodName,
                    ParameterValid.class, param, clazz);
            if (errorLists != null) {
                logger.warn("warn");
            }
        } catch (NotFoundException | ClassNotFoundException e) {
            logger.error("e-name：" + e.getClass().getName() + "： message：" + e.getMessage());
        }
    }
}
