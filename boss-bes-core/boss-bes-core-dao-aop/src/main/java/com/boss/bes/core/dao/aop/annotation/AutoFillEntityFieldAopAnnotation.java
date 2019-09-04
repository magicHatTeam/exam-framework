package com.boss.bes.core.dao.aop.annotation;

import com.boss.bes.core.dao.aop.pojo.enums.MethodType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动填充注解
 * 在Dao层的方法中添加注解
 * @author Lynch、likang
 * @date 2019/8/11 -23:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFillEntityFieldAopAnnotation {

	/**
	 * 方法类型，默认为添加
	 */
	MethodType methodType() default MethodType.INSERT;

	/**
	 * 自动填充雪花算法的ID
	 * 只在methodType = MethodType.INSERT 中起作用
	 */
	boolean autoFillId() default true;

	/**
	 * 是否自动填充状态标识为，默认不填充
	 */
	boolean autoFillStatus() default false;
}
