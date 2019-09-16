package com.boss.bes.core.data.pojo;

/**
 * 业务结果枚举类，包含应答码和消息
 * 应答码规定为4位，规则如下：
 * 1. 业务执行成功时，使用 0000
 * 2. 出现系统级错误，使用 1xxx
 *      网关服务错误：10xx
 *      认证服务错误：11xx
 *      日志服务错误：12xx
 *      CDN服务错误：13xx
 * 3. 出现业务错误，使用 2xxx
 *      基础数据服务错误：20xx + 21xx
 *      租凭服务错误：22xx + 23xx
 *      用户和权限服务错误：24xx + 25xx
 *      试卷服务错误：26xx + 27xx
 *      考试服务错误：28xx + 29xx
 *  现在只是初步模拟实现，还需要后续的修改
 *
 * @author 何家伟
 * @date 2019-08-09 23:05
 * @version 1.0
 */
public enum ResultEnum {
    /**
     * 方法执行成功时的枚举情况
     */
    SUCCESS("00000", "请求成功"),
    /**
     * 默认错误
     */
    DEFAULT_ERROR("-1", "请求失败"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR("1000", "系统错误"),
    /**
     * 业务错误
     */
    BUSINESS_ERROR("2000", "参数错误"),
    /**
     * 从请求体拿token内参数错误，或者从redis拿值错误
     */
    PARAMS_TOKEN_ERROR("1001", "获取自动填值参数错误"),
    /**
     * 网关熔断超时错误
     */
    GATEWAY_HYSTRIX_TIMEOUT_ERROR("1002", "网关熔断超时错误"),
    /**
     * token无效错误
     */
    TOKEN_INVALID("1003","token无效，请重新登录"),
    /**
     * token不存在错误
     */
    TOKEN_NOT_EXITS("1004", "token不存在，请登录"),
    /**
     * 请求体参数不符合规范
     */
    REQUEST_BODY_PARAMS_ERROR("1005", "请求体参数不符合规范！！"),
    /**
     * 没有权限
     */
    REQUEST_NO_AUTH_ERROR("1006", "没有权限！"),
    /**
     * 登录熔断异常
     */
    LOGIN_OUT_TIME_ERROR("1101", "登录验证超时！"),
    /**
     * 用户名或密码错误
     */
    LOGIN_FORMAT_ERROR("1102", "用户名或密码错误！"),
    /**
     * 获取角色资源异常
     */
    GET_ROLE_RESOURCE_ERROR("1103", "获取角色资源错误！"),

    // 试卷微服务异常
    /**
     * 上传的试卷不存在异常
     */
    PAPER_NOT_EXITS("2601", "上传的试卷不存在！"),
    /**
     * 存在名称相同的模板
     */
    PAPER_TEMPLATE_SAME_NAME("2602", "存在名称相同的模板！"),
    /**
     * 生成模板试卷失败异常
     */
    PAPER_GENERATE_TEMPLATE("2603", "生成模板试卷失败！"),
    /**
     * 试卷为空试卷异常
     */
    PAPER_NONE_SUBJECTS("2604", "试卷为空试卷！"),
    /**
     * 试卷已被禁用不能进行上传
     */
    PAPER_IS_DISABLE("2605", "试卷已被禁用不能进行上传！"),
    /**
     * 组卷配置项为空异常
     */
    PAPER_COMPOSITION_NONE_CONFIG("2606", "组卷失败！组卷配置项为空！"),
    /**
     * 组卷配置详情为空异常
     */
    PAPER_COMPOSITION_NONE_CONFIG_ITEM("2607", "组卷失败！组卷配置详情为空，请添加配置详情！"),
    /**
     * 配置详情的题目数量太多
     */
    PAPER_COMPOSITION_CONFIG_NUMBER_TOO_BIGGER("2608", "组卷失败！配置详情的题目数量太大，题目数量不够，请减少数量或者添加该类型题目"),
    /**
     * 组卷生成题目异常
     */
    PAPER_COMPOSITION_GENERATE_SUBJECT("2609", "组卷失败！无法生成题目！"),
    /**
     * 组卷生成答案异常
     */
    PAPER_COMPOSITION_GENERATE_ANSWER("2610", "组卷失败！无法生成答案！"),
    /**
     * 答案为空异常
     */
    PAPER_COMPOSITION_NONE_ANSWER("2611", "组卷失败！该试卷的答案全部为空！"),
    /**
     * 试卷无法关联题目
     */
    PAPER_COMPOSITION_CANNOT_SUBJECT("2612", "组卷失败！试卷无法关联题目！"),
    /**
     * 下载试卷失败异常
     */
    TEMPLATE_DOWNLOAD_ERROR("2613", "下载试卷失败！"),
    /**
     * 下载试卷参数异常
     */
    TEMPLATE_PARAMS_NONE_ERROR("2614", "请选择需要下载的模板"),
    /**
     * 模板不存在异常
     */
    TEMPLATE_NOT_EXIST("2615", "下载试卷失败！选择的模板不存在！"),
    /**
     * 模板被禁用异常
     */
    TEMPLATE_IS_DISABLE("2616", "下载试卷失败！选择的模板被禁用！"),
    /**
     * 模板为空异常
     */
    TEMPLATE_NONE_SUBJECTS("2617", "该模板为空模板！"),
    /**
     * 考试发布记录不存在
     */
    PUBLISH_RECORD_ID_NOT_EXISTS("140000","考试发布记录id为空"),
    /**
     * 找不到考试发布记录
     */
    PUBlISH_RECORD_NOT_EXISTS("140001","找不到考试发布记录"),
    /**
     * 找不到试卷id异常
     */
    PUBLISH_RECORD_PAPER_ID_NOT_EXISTS("140002","找不到试卷ID异常"),
    /**
     * 考试未发布异常
     */
    EXAM_UNPUBLISH_EXCEPTION("141000","该场考试未发布！"),
    /**
     * 考试已经发布异常
     */
    EXAM_PUBLISHED_EXCEPTION("141001","该场考试已经结束！"),
    /**
     * 考试剩余时间异常
     */
    EXAM_TIME_EXCEPTION("141001","考试时间错误")
    ;

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
