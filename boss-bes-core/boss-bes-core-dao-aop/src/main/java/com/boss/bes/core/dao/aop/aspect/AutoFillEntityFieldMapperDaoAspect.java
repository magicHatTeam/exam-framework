package com.boss.bes.core.dao.aop.aspect;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSONObject;
import com.boss.bes.common.exception.logging.exception.DaoException;
import com.boss.bes.common.utils.SnowflakeIdWorker;
import com.boss.bes.common.utils.TokenUtil;
import com.boss.bes.common.utils.constants.ByteConstants;
import com.boss.bes.common.utils.constants.CommonCacheConstants;
import com.boss.bes.core.dao.aop.annotation.AutoFillEntityFieldAopAnnotation;
import com.boss.bes.core.dao.aop.pojo.common.InsertCommon;
import com.boss.bes.core.dao.aop.pojo.common.UpdateCommon;
import com.boss.bes.core.data.pojo.ResultEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用Mapper切面
 * 自动填值的切面
 * @author likang
 * @date 2019/8/11 -23:21
 */
@Aspect
@Component
public class AutoFillEntityFieldMapperDaoAspect {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	private static String FIELD_ID = "id";
	private static String FIELD_STATUS = "status";
	private static String FIELD_ORG_ID = "orgId";
	private static String FIELD_COMPANY_ID = "companyId";

	/**
	 * 新增数据的切点
	 * TODO：有待将这些包进行动态配置
	 */
	@Pointcut(value = "execution(public * com.boss.bes.paper.center.dao.*.insert*(..)) || " +
			"execution(public * com.bosssoft.bes.basedata.center.dao.*.insert*(..)) ||" +
			"execution(public * com.boss.bes.user.permission.center.dao.*.insert*(..))")
	public void daoInsertAction(){}

	/**
	 * 更新数据的切点
	 */
	@Pointcut(value = "execution(public * com.boss.bes.paper.center.dao.*.update*(..)) || " +
			"execution(public * com.bosssoft.bes.basedata.center.dao.*.update*(..)) ||" +
			"execution(public * com.boss.bes.user.permission.center.dao.*.insert*(..))")
	public void daoUpdateAction(){}

	/**
	 * 自动填值 - 添加插入方法
	 * 是否存在参数
	 * 第一位参数是否为集合，是集合则不进行填充
	 * 判断方法上是否存在指定注解
	 * @param joinPoint 切面方法
	 * @return 返回值
	 */
	@Around("daoInsertAction()")
	public Object doInsertAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获取切面参数及其属性域
		Object[] args = joinPoint.getArgs();
		if (args.length < 1 || args[0] instanceof Collection || judgeAnnotationExist(joinPoint)){
			return joinPoint.proceed(args);
		}
		// 判断属性中ID和status是否有值
		Map<String, Boolean> fieldsExist = judgeFieldsExist(args);
		// 拿取公用数据
		JSONObject redisJsonObject = TokenUtil.getJsonObject(stringRedisTemplate);
		if (redisJsonObject == null) {
			throw new DaoException(ResultEnum.PARAMS_TOKEN_ERROR);
		}
		Date date = new Date();
		Long updatedBy = redisJsonObject.getLong(CommonCacheConstants.USER_ID);
		InsertCommon commonString = new InsertCommon(updatedBy, date, updatedBy, date, System.currentTimeMillis());
		if (!fieldsExist.get(FIELD_ID)){
			// ID没有值则自动填充
			commonString.setId(SnowflakeIdWorker.generateId());
		}
		if (!fieldsExist.get(FIELD_STATUS)){
			// status没有值时则自动填充为启用
			commonString.setStatus(ByteConstants.STATUS_YES);
		}
        if (!fieldsExist.get(FIELD_ORG_ID)){
            // orgId没有值时则自动填充
            commonString.setOrgId(redisJsonObject.getLong(CommonCacheConstants.ORG_ID));
        }
        if (!fieldsExist.get(FIELD_COMPANY_ID)){
            // companyId没有值时则自动填充
            commonString.setCompanyId(redisJsonObject.getLong(CommonCacheConstants.COMPANY_ID));
        }
		BeanUtil.copyProperties(commonString, args[0], CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
		return joinPoint.proceed(args);
	}

	/**
	 * 自动填值 - 更新数据方法
	 * @param joinPoint 切面方法
	 * @return 返回值
	 */
	@Around("daoUpdateAction()")
	public Object doUpdateAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获取切面参数及其属性域
		Object[] args = joinPoint.getArgs();
		if (args.length < 1 || args[0] instanceof Collection || judgeAnnotationExist(joinPoint)){
			return joinPoint.proceed(args);
		}
		JSONObject redisJsonObject = TokenUtil.getJsonObject(stringRedisTemplate);
		if (redisJsonObject == null) {
			throw new DaoException(ResultEnum.PARAMS_TOKEN_ERROR);
		}
		Long updatedBy = redisJsonObject.getLong(CommonCacheConstants.USER_ID);
		UpdateCommon commonString = new UpdateCommon(updatedBy,new Date(),System.currentTimeMillis());
		BeanUtils.copyProperties(commonString, args[0]);
		return joinPoint.proceed(args);
	}

	/**
	 * 判断是否存在填值注解
	 * @param joinPoint 切面
	 * @return 判断切面上是否存在AutoFillEntityFieldAopAnnotation注解
	 * @throws Throwable 异常
	 */
	private Boolean judgeAnnotationExist(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method targetMethod = methodSignature.getMethod();
		Method method = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(),targetMethod.getParameterTypes());
		return method.isAnnotationPresent(AutoFillEntityFieldAopAnnotation.class);
	}

	/**
	 * 判断某些属性的值是否存在
	 * @param args 参数
	 * @return 属性集合
	 */
	private Map<String,Boolean> judgeFieldsExist(Object[] args){
		Map<String,Boolean> map = new HashMap<>(4);
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(args[0]);
		map.put(FIELD_ID, judgeFieldValue(jsonObject,FIELD_ID));
		map.put(FIELD_STATUS, judgeFieldValue(jsonObject,FIELD_STATUS));
		map.put(FIELD_ORG_ID, judgeFieldValue(jsonObject,FIELD_ORG_ID));
		map.put(FIELD_COMPANY_ID, judgeFieldValue(jsonObject,FIELD_COMPANY_ID));
		return map;
	}

    /**
     * 判断属性的值是否存在
     * @param jsonObject JSONObject
     * @param field 字段名
     * @return 是否存在
     */
	private Boolean judgeFieldValue(JSONObject jsonObject,String field){
        boolean valueExist = false;
        boolean exist = jsonObject.containsKey(field);
        if (exist){
            valueExist = jsonObject.getLong(field) != null;
        }
        return valueExist;
    }
}
