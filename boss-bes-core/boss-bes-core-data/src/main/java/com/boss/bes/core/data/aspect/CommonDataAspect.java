package com.boss.bes.core.data.aspect;

/**
 * 切面类
 * 还未完善，需要后续增加加密、解密功能
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-12 14:37
 */
//@Aspect
//@Component
public class CommonDataAspect {
//    private final Logger logger = LoggerFactory.getLogger(CommonDataAspect.class);
//    /**
//     * 设置切点
//     */
//    @Pointcut("@annotation(com.boss.bes.core.data.annotation.CommonDataAnnotation)")
//    public void cutPoint() {
//    }//签名，可以理解成这个切入点的一个名称
//
//    @Around("cutPoint()")
//    public Object doAround(ProceedingJoinPoint point) throws Throwable {
//        // 获取版本和加密信息
//        Object[] args = point.getArgs();
//        CommonRequest commonRequest = (CommonRequest) args[0];
//        String version = commonRequest.getHead().getVersion();
//        Integer crypt = commonRequest.getHead().getCrypt();
//
//        // 将版本和加密信息填入response
//        Object result = point.proceed();
//        CommonResponse commonResponse = (CommonResponse) result;
//        commonResponse.getHead().setVersion(version);
//        commonResponse.getHead().setCrypt(crypt);
//        return commonResponse;
//    }
}
