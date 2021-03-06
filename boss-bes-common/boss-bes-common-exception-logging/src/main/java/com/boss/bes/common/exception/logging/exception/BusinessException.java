package com.boss.bes.common.exception.logging.exception;

import com.boss.bes.core.data.pojo.ResultEnum;

/**
 * 用于抛出业务层的异常用于继承
 *
 * @author fishkk
 * @version 1.0.0
 * @since 2019/8/13
 */
public class BusinessException extends AppException
{

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public BusinessException(String message, String code) {
        super(message, code);
    }

    public BusinessException(ResultEnum resultEnum, Throwable throwable) {
        super(resultEnum, throwable);
    }

    public BusinessException(String message, String code, Throwable throwable) {
        super(message, code, throwable);
    }
}
