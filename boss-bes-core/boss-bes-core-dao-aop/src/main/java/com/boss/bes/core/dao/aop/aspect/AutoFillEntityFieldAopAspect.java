package com.boss.bes.core.dao.aop.aspect;

import com.alibaba.fastjson.JSONObject;
import com.boss.bes.common.exception.logging.exception.DaoException;
import com.boss.bes.common.utils.SnowflakeIdWorker;
import com.boss.bes.common.utils.TokenUtil;
import com.boss.bes.common.utils.constants.ByteConstants;
import com.boss.bes.common.utils.constants.CommonCacheConstants;
import com.boss.bes.core.dao.aop.annotation.AutoFillEntityFieldAopAnnotation;
import com.boss.bes.core.dao.aop.pojo.common.InsertCommon;
import com.boss.bes.core.dao.aop.pojo.common.UpdateCommon;
import com.boss.bes.core.dao.aop.pojo.enums.MethodType;
import com.boss.bes.core.data.pojo.ResultEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;

/**
 * 注解切面
 * 自动填值的切面
 * @author Lynch、likang
 * @date 2019/8/11 -23:21
 */
@Aspect
@Component
public class AutoFillEntityFieldAopAspect {

	private static Logger logger = LoggerFactory.getLogger(AutoFillEntityFieldAopAspect.class);

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 切点
	 */
	@Pointcut("@annotation(com.boss.bes.core.dao.aop.annotation.AutoFillEntityFieldAopAnnotation)")
	public void daoAop() {
	}

	/**
	 * 自动填值
	 * @param joinPoint 切面方法
	 * @return 返回值
	 */
	@Around("daoAop() && @annotation(autoFillEntityFieldAopAnnotation)")
	public Object doAround(ProceedingJoinPoint joinPoint, AutoFillEntityFieldAopAnnotation autoFillEntityFieldAopAnnotation){
		Object result;
		try {
			Long startTime = System.currentTimeMillis();
			// 获取切面参数及其属性域
			Object[] args = joinPoint.getArgs();
			if (args.length < 1 || args[0] instanceof Collection){
				return joinPoint.proceed(args);
			}
			JSONObject redisJsonObject = TokenUtil.getJsonObject(stringRedisTemplate);
			if (redisJsonObject == null) {
				throw new DaoException(ResultEnum.PARAMS_TOKEN_ERROR);
			}
			Date date = new Date();
			Long orgId = redisJsonObject.getLong(CommonCacheConstants.ORG_ID);
			Long companyId = redisJsonObject.getLong(CommonCacheConstants.COMPANY_ID);
			Long updatedBy = redisJsonObject.getLong(CommonCacheConstants.USER_ID);

			// 为不同的dao操作执行不同规则
			if (MethodType.INSERT.equals(autoFillEntityFieldAopAnnotation.methodType())) {
				InsertCommon commonString = new InsertCommon(orgId, companyId, updatedBy, date, updatedBy, date, System.currentTimeMillis());
				if (autoFillEntityFieldAopAnnotation.autoFillId()){
					commonString.setId(SnowflakeIdWorker.generateId());
				}
				if (autoFillEntityFieldAopAnnotation.autoFillStatus()){
					commonString.setStatus(ByteConstants.STATUS_YES);
				}
				BeanUtils.copyProperties(commonString, args[0]);
			} else if (MethodType.UPDATE.equals(autoFillEntityFieldAopAnnotation.methodType())) {
				UpdateCommon commonString = new UpdateCommon(updatedBy,date,System.currentTimeMillis());
				BeanUtils.copyProperties(commonString, args[0]);
			}
			Long endTime = System.currentTimeMillis();
			logger.info("DaoAop属性填值消耗时长：" + (endTime - startTime));
			result = joinPoint.proceed(args);
		} catch (Throwable throwable){
			logger.error(throwable.getMessage(), throwable);
			throw throwable instanceof DaoException ?
					(DaoException)throwable:new DaoException(throwable.getMessage(), ResultEnum.COMMON_SYSTEM_ERROR.getCode());
		}
		return result;
	}

//	/**
//	 * 根据属性名获取属性值
//	 * @param fieldName 属性名
//	 * @param object 对象
//	 * @return 属性值
//	 */
//	private static Object getFieldValueByName(String fieldName, Object object) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//		String firstLetter = fieldName.substring(0, 1).toUpperCase();
//		String getter = "get" + firstLetter + fieldName.substring(1);
//		Method method = object.getClass().getMethod(getter);
//		return method.invoke(object);
//	}
//
//	/**
//	 * 获取JSONObject从request和Redis
//	 * @return JSONObject OR null
//	 * @throws DaoException 参数异常，错误的可能是
//	 *  1、commonParamsFromToken 为 null
//	 *  2、从token里面拿用户ID错误
//	 */
//	private JSONObject getJsonObject() throws IOException {
//		Map<String, String> commonParamsFromToken = TokenUtil.getCommonParamsFromToken();
//		if (commonParamsFromToken!=null){
//			String userId = commonParamsFromToken.get(CommonCacheConstants.USER_ID);
//			if (StrUtil.isNotEmpty(userId)) {
//				return TokenUtil.getCommonParamsFromRedis(userId, stringRedisTemplate);
//			}
//		}
//		throw new DaoException(ResultEnum.PARAMS_TOKEN_ERROR);
//	}
//
//	/**
//	 * 填值，根据类属性进行填值
//	 * @param objectFirst 需要填值的对象
//	 * @param objectSecond 存在参数值的对象
//	 * @throws IllegalAccessException IllegalAccessException
//	 */
//	private static void inject2To1(Object objectFirst,Object objectSecond) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		Field[] firstFields = objectFirst.getClass().getDeclaredFields();
//		Field[] secondFields = objectSecond.getClass().getDeclaredFields();
//		for (Field 	firstField : firstFields) {
//			firstField.setAccessible(true);
//			for (Field secondField : secondFields) {
//				if (secondField.getName().equals(firstField.getName())) {
//					firstField.set(objectFirst, getFieldValueByName(firstField.getName(), objectSecond));
//				}
//			}
//		}
//	}

}
