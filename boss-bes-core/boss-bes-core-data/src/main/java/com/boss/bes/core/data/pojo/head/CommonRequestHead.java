package com.boss.bes.core.data.pojo.head;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 约定的请求报文头
 *  3.0更新：从request head 中删除token
 *
 * @author 何家伟
 * @version 3.0
 * @date 2019-08-14 22:33
 */
public class CommonRequestHead implements Serializable {
    private static final long serialVersionUID = -7476256075318476298L;
    /**
     * 数据版本
     */
    @NotBlank(message = "request的Head中版本信息不允许为空")
    private String version;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 加密方式
     */
    private Integer crypt;

    public Integer getCrypt() {
        return crypt;
    }

    public void setCrypt(Integer crypt) {
        this.crypt = crypt;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "CommonRequestHead{" +
                "version='" + version + '\'' +
                ", businessType='" + businessType + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType=" + deviceType +
                '}';
    }
}
