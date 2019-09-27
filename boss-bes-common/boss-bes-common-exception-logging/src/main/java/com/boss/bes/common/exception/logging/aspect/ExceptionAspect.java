package com.boss.bes.common.exception.logging.aspect;

import com.boss.bes.common.exception.logging.exception.AppException;
import com.boss.bes.common.exception.logging.handle.ExceptionHandle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 注解的切面用于统一异常处理
 * @author fishkk
 * @version 1.0.0
 * @since 2019/8/12
 */
@Aspect
@Component
public class ExceptionAspect {

    private Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Pointcut("@annotation(com.boss.bes.common.exception.logging.annotion.ExceptionHandle)")
    public  void serviceAspect() { }

    /**
      *  在控制层方法抛出异常后调用全局异常处理函数
      *  并记录异常错误信息
      * @author fishkk
      * @since  2019/8/12
      * @param  ex 抛出的异常形参
      */
    @AfterThrowing(throwing = "ex",pointcut = "serviceAspect()")
    public void afterThrowing(JoinPoint joinPoint, AppException ex){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //创建时间
        logger.error("dateTime={}" + dateFormat.format(new Date()));
        //URL
        logger.error("url={}", request.getRequestURL());
        //method
        logger.error("method={}", request.getMethod());
        //ip
        logger.error("ip={}", request.getRemoteAddr());
        //class_method
        logger.error("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        logger.error("args={}", joinPoint.getArgs());
        //异常信息
        logger.error("errMessage={}" + ex.getMessage());
    }
}


