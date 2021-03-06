package com.boss.bes.common.exception.logging.exception;


import com.boss.bes.core.data.pojo.ResultEnum;

/**
 *  异常的父类接口  不允许自定义异常 全部通过预定义枚举赋值
 *
 * @author fishkk
 * @version 1.0.0
 * @since 2019/8/12
 */

public class AppException extends RuntimeException {

     private ResultEnum resultEnum;
     private String code;

     public AppException(ResultEnum resultEnum) {
          super(resultEnum.getMsg());
          this.resultEnum = resultEnum;
          this.code = resultEnum.getCode();
     }

     public AppException(String message, String code) {
          super(message);
          this.code = code;
     }

     public AppException(ResultEnum resultEnum, Throwable throwable) {
          this(resultEnum);
     }

     public AppException(String message, String code, Throwable throwable) {
          this(message, code);
     }

     public ResultEnum getResultEnum() {
          return resultEnum;
     }

     public void setResultEnum(ResultEnum resultEnum) {
          this.resultEnum = resultEnum;
     }

     public String getCode() {
          return code;
     }

     public void setCode(String code) {
          this.code = code;
     }
}
