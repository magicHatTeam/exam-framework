package com.boss.bes.core.data.pojo;

/**
 * 业务结果枚举类，包含应答码和消息
 * 应答码规定为5位，规则如下：
 * 第一位：取值范围0、1  0代表系统本身抛出的异常，1代表业务异常
 * 第二位：取值访问0、1、2、3、4、5、6 分别代表网关、基础数据服务、系统管理、试卷微服务、考试微服务、认证、公共模块异常
 * 第三位：对应模块的页面：从0-x 代表每个模块展开的页面，从上到下
 *  其中6，公共模块中：
 *  boss-bes-common-exception-logging：0
 *  boss-bes-common-logging：1
 *  boss-bes-common-utils：2
 *  boss-bes-core-api-version：3
 *  boss-bes-core-dao-aop：4
 *  boss-bes-core-data：5
 * 第四和第五位：代表具体的业务
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
     * 系统管理模块的异常码定义
     * TODO
     * @since 2019/9/16
     */

    // =================================
    // 系统管理-公司
    // =================================

    /**
     * 请求体为空
     */
    SYSTEM_COMPANY_EMPTY_REQUEST("12101", "请求体为空"),

    /**
     * 没有匹配的查询结果
     */
    SYSTEM_COMPANY_NO_MATCH_QUERY_RESULT("12102", "没有匹配的查询结果"),

    /**
     * 公司信息插入失败
     */
    SYSTEM_COMPANY_FAIL_INSERT("12103", "数据库中公司信息没能成功地新增"),

    /**
     * 公司信息插入失败(由于组织机构-公司中间表)
     */
    SYSTEM_COMPANY_FAIL_INSERT_CAUSE_T_ORG_COMPANY("12104", "数据库中组织机构和公司的联系新增失败"),

    /**
     * 公司信息更新失败
     */
    SYSTEM_COMPANY_FAIL_UPDATE("12105", "数据库中公司信息没能成功地更新"),

    /**
     * 空的待删除公司
     */
    SYSTEM_COMPANY_EMPTY_DELETED_COMPANY("12106", "空的待删除公司"),

    /**
     * 公司信息删除失败
     */
    SYSTEM_COMPANY_FAIL_DELETE("12107", "数据库中公司信息没能成功地删除"),

    /**
     * 可能删除了正被使用的公司
     */
    SYSTEM_COMPANY_DELETED_COMPANY_IS_BEING_USED("12108", "待删除的公司可能正被使用中"),

    /**
     * 公司信息删除失败(由于组织机构-公司中间表)
     */
    SYSTEM_COMPANY_FAIL_DELETE_CAUSE_T_ORG_COMPANY("12109", "数据库中组织机构和公司的联系删除失败"),

    /**
     * 数据版本信息不一致
     */
    SYSTEM_COMPANY_INCONSISTENT_VERSION("12110", "数据版本不一致"),

    // =================================
    // 系统管理-部门
    // =================================

    /**
     *  请求体为空
     */
    SYSTEM_NULLBODY("12201", "请求体为空"),

    /**
     * 部门管理查询数据为空
     */
    SYSTEM_DEPARTMENT_NOTFANF("12202", "对部门查询结果为空"),

    /**
     * 对组织机构-公司的树结构进行查询时出错
     */
    SYSTEM_DEPARTMENT_ERRORTREE("12203", "对公司-部门的树结构进行查询时出错"),

    /**
     * 对部门进行插入时失败
     */
    SYSTEM_DEPARTMENT_ERROR_INSERT("12204", "对部门进行插入时失败"),

    /**
     * 将公司信息插入公司-部门的中间表时出现异常
     */
    SYSTEM_DEPARTMENT_ERROR_INSRTTRELATION("12205", "将公司信息插入公司-部门的中间表时出现异常"),

    /**
     * 待删除的部门信息不能为空
     */
    SYSTEM_DEPARTMENT_ERROR_DELETENULL("12206", "待删除的部门信息不能为空"),

    /**
     * 从公司-部门的中间表中删除数据失败
     */
    SYSTEM_DEPARTMENT_ERROR_DELETERELATION("12207", "从公司-部门的中间表中删除数据失败"),

    /**
     * 删除部门信息失败
     */
    SYSTEM_DEPARTMENT_ERROR_DELETE("12208", "删除部门信息失败"),

    /**
     * 数据版本不一致，请刷新
     */
    SYSTEM_DEPARTMENT_ERROR_VERSION("12209", "数据版本不一致，请刷新"),

    /**
     *  请求体为空
     */
    SYSTEM_ORAGATION_NULLBODY("12001", "请求体为空"),

    /**
     * 部门管理查询数据为空
     */
    SYSTEM_ORAGATION_NOTFANF("12002", "对组织机构查询结果为空"),

    /**
     * 对组织机构-公司的树结构进行查询时出错
     */
    SYSTEM_ORAGATION_ERRORTREE("12003", "对组织机构-公司的树结构进行查询时出错"),

    /**
     * 对部门进行插入时失败
     */
    SYSTEM_ORAGATION_ERROR_INSERT("12004", "对组织机构进行插入时失败"),

    /**
     * 将公司信息插入公司-部门的中间表时出现异常
     */
    SYSTEM_ORAGATION_ERROR_INSRTTRELATION("12005", "将组织机构信息插-部门的中间表时出现异常"),

    /**
     * 待删除的部门信息不能为空
     */
    SYSTEM_ORAGATION_ERROR_DELETENULL("12006", "待删除的部门信息不能为空"),

    /**
     * 从公司-部门的中间表中删除数据失败
     */
    SYSTEM_ORAGATION_ERROR_DELETERELATION("12007", "从公司-部门的中间表中删除数据失败"),

    /**
     * 删除部门信息失败
     */
    SYSTEM_ORAGATION_ERROR_DELETE("12008", "删除部门信息失败"),

    /**
     * 数据版本不一致，请刷新
     */
    SYSTEM_ORAGATION_ERROR_VERSION("12009", "数据版本不一致，请刷新"),

    /**
     *  请求体为空
     */
    SYSTEM_POSITION_NULLBODY("12501", "请求体为空"),

    /**
     * 部门管理查询数据为空
     */
    SYSTEM_POSITION_NOTFANF("12502", "对职位查询结果为空"),

    /**
     * 对组织机构-公司的树结构进行查询时出错
     */
    SYSTEM_POSITION_ERRORTREE("12503", "对公司-职位的树结构进行查询时出错"),

    /**
     * 对部门进行插入时失败
     */
    SYSTEM_POSITION_ERROR_INSERT("12504", "对职位信息进行插入时失败"),

    /**
     * 将公司信息插入公司-部门的中间表时出现异常
     */
    SYSTEM_POSITION_ERROR_INSRTTRELATION("12505", "将职位信息插公司-职位的中间表时出现异常"),

    /**
     * 待删除的部门信息不能为空
     */
    SYSTEM_POSITION_ERROR_DELETENULL("12506", "待删除的职位信息不能为空"),

    /**
     * 从公司-部门的中间表中删除数据失败
     */
    SYSTEM_POSITION_ERROR_DELETERELATION("12507", "从部门-职位的中间表中删除数据失败"),

    /**
     * 删除部门信息失败
     */
    SYSTEM_POSITION_ERROR_DELETE("12508", "删除职位信息失败"),

    /**
     * 数据版本不一致，请刷新
     */
    SYSTEM_POSITION_ERROR_VERSION("12509", "数据版本不一致，请刷新"),

    // =================================
    // 系统管理-资源
    // =================================

    /**
     * 请求体为空
     */
    SYSTEM_RESOURCE_EMPTY_REQUEST("12301", "请求体为空"),

    /**
     * 没有匹配的查询结果
     */
    SYSTEM_RESOURCE_NO_MATCH_QUERY_RESULT("12302", "没有匹配的查询结果"),

    /**
     * 资源信息插入失败
     */
    SYSTEM_RESOURCE_FAIL_INSERT("12303", "数据库中资源信息没能成功地新增"),

    /**
     * 资源信息插入失败(由于组织机构-资源中间表)
     */
    SYSTEM_RESOURCE_FAIL_INSERT_CAUSE_T_ORG_RESOURCE("12304", "数据库中组织机构和资源的联系新增失败"),

    /**
     * 资源信息更新失败
     */
    SYSTEM_RESOURCE_FAIL_UPDATE("12305", "数据库中资源信息没能成功地更新"),

    /**
     * 空的待删除资源
     */
    SYSTEM_RESOURCE_EMPTY_DELETED_RESOURCE("12306", "空的待删除资源"),

    /**
     * 资源信息删除失败
     */
    SYSTEM_RESOURCE_FAIL_DELETE("12307", "数据库中资源信息没能成功地删除"),

    /**
     * 可能删除了正被使用的资源
     */
    SYSTEM_RESOURCE_DELETED_RESOURCE_IS_BEING_USED("12308", "待删除的资源可能正被使用中"),

    /**
     * 数据版本信息不一致
     */
    SYSTEM_RESOURCE_INCONSISTENT_VERSION("12109", "数据版本不一致"),

    /**
     * 资源信息删除失败(由于组织机构-资源中间表)
     */
    SYSTEM_RESOURCE_FAIL_DELETE_CAUSE_T_ORG_RESOURCE("12310", "数据库中组织机构和资源的联系删除失败"),

    /**
     * 当前登录用户的权限不满足要求
     */
    SYSTEM_RESOURCE_ERROR_MASTER_ACCESS("12311", "只有组织机构级别管理员才能进行资源管理"),

    /**
     * 删除了非叶子节点的资源
     */
    SYSTEM_RESOURCE_NON_LEAF_CANNOT_BE_DELETED("12312", "只能删除是叶子节点的资源"),

    /**
     * 只有非叶子节点才能成为父节点
     */
    SYSTEM_RESOURCE_LEAF_CANNOT_BE_PARENT("12313", "叶子节点不能充当其它节点的父节点"),

    // =================================
    // 系统管理-角色
    // =================================

    /**
     * 请求体为空
     */
    SYSTEM_ROLE_EMPTY_REQUEST("12401", "请求体为空"),

    /**
     * 没有匹配的查询结果
     */
    SYSTEM_ROLE_NO_MATCH_QUERY_RESULT("12402", "没有匹配的查询结果"),

    /**
     * 角色信息插入失败
     */
    SYSTEM_ROLE_FAIL_INSERT("12403", "数据库中角色信息没能成功地新增"),

    /**
     * 角色信息插入失败(由于组织机构-公司-角色中间表)
     */
    SYSTEM_ROLE_FAIL_INSERT_CAUSE_T_ORG_COMPANY_ROLE("12404", "数据库中组织机构、公司和角色的联系新增失败"),

    /**
     * 角色信息更新失败
     */
    SYSTEM_ROLE_FAIL_UPDATE("12405", "数据库中角色信息没能成功地更新"),

    /**
     * 空的待删除角色
     */
    SYSTEM_ROLE_EMPTY_DELETED_ROLE("12406", "空的待删除角色"),

    /**
     * 角色信息删除失败
     */
    SYSTEM_ROLE_FAIL_DELETE("12407", "数据库中角色信息没能成功地删除"),

    /**
     * 可能删除了正被使用的角色
     */
    SYSTEM_ROLE_DELETED_ROLE_IS_BEING_USED("12408", "待删除的角色可能正被使用中"),

    /**
     * 数据版本信息不一致
     */
    SYSTEM_ROLE_INCONSISTENT_VERSION("12109", "数据版本不一致"),

    /**
     * 角色信息删除失败(由于组织机构-公司-角色中间表)
     */
    SYSTEM_ROLE_FAIL_DELETE_CAUSE_T_ORG_COMPANY_ROLE("12410", "数据库中组织机构、公司和角色的联系删除失败"),

    /**
     * 角色信息删除失败(由于资源-角色中间表)
     */
    SYSTEM_ROLE_FAIL_DELETE_CAUSE_T_RESOURCE_ROLE("12411", "数据库中资源和角色的联系删除失败"),

    /**
     * 当前登录用户的权限不满足要求
     */
    SYSTEM_ROLE_ERROR_MASTER_ACCESS("12412", "超级管理员不允许进行内部角色管理"),

    /**
     * 对角色进行资源分配之前，必须以机构为单位
     */
    SYSTEM_ROLE_FAIL_DISTRIBUTE_RESOURCE_CAUSE_WITHOUT_ORG_INFO("12413", "进行资源分配时，必须有所属机构"),

    // =================================
    // 系统管理-用户
    // =================================

    /**
     * 请求体为空
     */
    SYSTEM_USER_EMPTY_REQUEST("12401", "请求体为空"),

    /**
     * 没有匹配的查询结果
     */
    SYSTEM_USER_NO_MATCH_QUERY_RESULT("12402", "没有匹配的查询结果"),

    /**
     * 用户信息插入失败
     */
    SYSTEM_USER_FAIL_INSERT("12403", "数据库中用户信息没能成功地新增"),

    /**
     * 用户信息插入失败(由于组织机构-公司-用户中间表)
     */
    SYSTEM_USER_FAIL_INSERT_CAUSE_T_ORG_COMPANY_USER("12404", "数据库中组织机构、公司和用户的联系新增失败"),

    /**
     * 用户信息插入失败(由于角色-用户中间表)
     */
    SYSTEM_USER_FAIL_INSERT_CAUSE_T_ROLE_USER("12414", "数据库中角色和用户的联系新增失败"),

    /**
     * 用户信息插入失败(由于部门-用户中间表)
     */
    SYSTEM_USER_FAIL_INSERT_CAUSE_T_DEPARTMENT_USER("12415", "数据库中部门和用户的联系新增失败"),

    /**
     * 用户信息更新失败
     */
    SYSTEM_USER_FAIL_UPDATE("12405", "数据库中用户信息没能成功地更新"),

    /**
     * 空的待删除用户
     */
    SYSTEM_USER_EMPTY_DELETED_USER("12406", "空的待删除用户"),

    /**
     * 用户信息删除失败
     */
    SYSTEM_USER_FAIL_DELETE("12407", "数据库中用户信息没能成功地删除"),

    /**
     * 数据版本信息不一致
     */
    SYSTEM_USER_INCONSISTENT_VERSION("12109", "数据版本不一致"),

    /**
     * 用户信息删除失败(由于组织机构-公司-用户中间表)
     */
    SYSTEM_USER_FAIL_DELETE_CAUSE_T_ORG_COMPANY_USER("12410", "数据库中组织机构、公司和用户的联系删除失败"),

    /**
     * 用户信息删除失败(由于角色-用户中间表)
     */
    SYSTEM_USER_FAIL_DELETE_CAUSE_T_ROLE_USER("12411", "数据库中角色和用户的联系删除失败"),

    /**
     * 用户信息删除失败(由于部门-用户中间表)
     */
    SYSTEM_USER_FAIL_DELETE_CAUSE_T_DEPARTMENT_USER("12413", "数据库中部门和用户的联系删除失败"),

    /**
     * 当前登录用户的权限不满足要求
     */
    SYSTEM_USER_ERROR_MASTER_ACCESS("12412", "超级管理员不允许进行内部用户管理"),

    /**
     * 为角色分配用户时，没能正确的将用户之前拥有的角色重置
     */
    SYSTEM_USER_FAIL_DISTRIBUTE_ROLE_CAUSE_FAIL_RESET("12408", "没能够正确地重置用户之前拥有的角色"),

    /**
     * 为角色分配用户时，没能正确的对用户进行角色分配
     */
    SYSTEM_USER_FAIL_DISTRIBUTE_ROLE_CAUSE_FAIL_DISTRIBUTE("12416", "没能够正确地分配给用户指定角色"),












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

    // 公共模块异常
    /**
     * 从请求体拿token内参数错误，或者从redis拿值错误
     */
    PARAMS_TOKEN_ERROR("16401", "获取自动填值参数错误"),

    // 网关异常
    /**
     * 网关熔断超时错误
     */
    GATEWAY_HYSTRIX_TIMEOUT_ERROR("10001", "网关熔断超时错误！"),
    /**
     * token无效错误
     */
    TOKEN_INVALID("10002","登录无效，请重新登录！"),
    /**
     * token不存在错误
     */
    TOKEN_NOT_EXITS("10003", "登录超时，请登录！"),
    /**
     * 请求体参数不符合规范
     */
    REQUEST_BODY_PARAMS_ERROR("10004", "请求体参数不符合规范！！"),
    /**
     * 没有权限
     */
    REQUEST_NO_AUTH_ERROR("10005", "对不起，您没有操作权限！"),

    // 认证微服务异常
    /**
     * 登录熔断异常
     */
    LOGIN_OUT_TIME_ERROR("15001", "登录验证超时！"),
    /**
     * 用户名或密码错误
     */
    LOGIN_FORMAT_ERROR("15002", "用户名或密码错误！"),
    /**
     * 获取角色资源异常
     */
    GET_ROLE_RESOURCE_ERROR("15003", "获取角色资源错误！"),
    /**
     * 用户注销异常
     */
    LOGIN_OUT_ERROR("15004", "用户注销错误！"),

    // 试卷微服务异常
    /**
     * 获取公用缓存失败！
     */
    USER_REDIS_PAPER_ERROR("13000", "用户信息发生错误，请重新登录！"),
    /**
     * 组卷配置项为空异常
     */
    PAPER_COMPOSITION_NONE_CONFIG("13001", "组卷失败！组卷配置项为空！"),
    /**
     * 组卷配置详情为空异常
     */
    PAPER_COMPOSITION_NONE_CONFIG_ITEM("13002", "组卷失败！组卷配置详情为空，请添加配置详情！"),
    /**
     * 配置详情的题目数量太多
     */
    PAPER_COMPOSITION_CONFIG_NUMBER_TOO_BIGGER("13003", "组卷失败！配置详情的题目数量太大，题目数量不够，请减少数量或者添加该类型题目"),
    /**
     * 组卷生成题目异常
     */
    PAPER_COMPOSITION_GENERATE_SUBJECT("13004", "组卷失败！无法生成题目！"),
    /**
     * 组卷生成答案异常
     */
    PAPER_COMPOSITION_GENERATE_ANSWER("13005", "组卷失败！无法生成答案！"),
    /**
     * 答案为空异常
     */
    PAPER_COMPOSITION_NONE_ANSWER("13006", "组卷失败！该试卷的答案全部为空！"),
    /**
     * 试卷无法关联题目
     */
    PAPER_COMPOSITION_CANNOT_SUBJECT("13007", "组卷失败！试卷无法关联题目！"),
    /**
     * 查询条件错误
     */
    PAPER_COMPOSITION_PARAMS_ERROR("13008", "试卷查询失败，查询条件错误！"),
    /**
     * 既不是公司、组织机构管理员，也不是超级管理员，则没有操作权限
     */
    PAPER_COMPOSITION_NO_PERMISSION("13009", "没有权限操作！"),
    /**
     * 组卷失败，题库获取题目失败！
     */
    PAPER_COMPOSITION_NONE_SUBJECTS("13010", "组卷失败，题库获取题目失败！"),
    /**
     * 预览参数错误，请选择试卷
     */
    PAPER_PREVIEW_PARAMS_ERROR("13011", "预览参数错误，请选择试卷！"),
    /**
     * 上传的试卷不存在异常
     */
    PAPER_NOT_EXITS("13101", "上传的试卷不存在！"),
    /**
     * 存在名称相同的模板
     */
    PAPER_TEMPLATE_SAME_NAME("13102", "存在名称相同的模板！"),
    /**
     * 生成模板试卷失败异常
     */
    PAPER_GENERATE_TEMPLATE("13103", "试卷生成模板失败！"),
    /**
     * 试卷为空试卷异常
     */
    PAPER_NONE_SUBJECTS("13104", "试卷为空试卷！"),
    /**
     * 试卷已被禁用不能进行上传
     */
    PAPER_IS_DISABLE("13105", "试卷已被禁用不能进行上传！"),
    /**
     * 试卷参数错误
     */
    PAPER_PARAMS_NONE_ERROR("13106", "请选择需要上传的试卷！"),
    /**
     * 操作数据库异常
     */
    PAPER_UPLOAD_DATABASE_EXCEPTION("13107", "上传试卷时，数据持久层出现问题！！"),
    /**
     * 下载试卷失败异常
     */
    TEMPLATE_DOWNLOAD_ERROR("13201", "下载试卷失败！"),
    /**
     * 下载试卷参数异常
     */
    TEMPLATE_PARAMS_NONE_ERROR("13202", "请选择需要下载的模板"),
    /**
     * 模板不存在异常
     */
    TEMPLATE_NOT_EXIST("13203", "下载试卷失败！选择的模板不存在！"),
    /**
     * 模板被禁用异常
     */
    TEMPLATE_IS_DISABLE("13204", "下载试卷失败！选择的模板被禁用！"),
    /**
     * 模板为空异常
     */
    TEMPLATE_NONE_SUBJECTS("13205", "该模板为空模板！"),
    /**
     * 不是公司管理员,没有权限操作
     */
    TEMPLATE_DOWNLOAD_NO_PERMISSION("13206", "不是公司管理员,没有权限操作！"),
    /**
     * 操作数据库异常
     */
    TEMPLATE_DOWNLOAD_DATABASE_EXCEPTION("13207", "下载试卷时，数据持久层出现问题！"),
    /**
     * 删除试卷参数异常
     */
    MAINTAIN_DELETE_PAPERS_ERROR("13301", "需要删除的数据为空，请选择试卷！"),
    /**
     * 试卷正在被发布不能删除异常
     */
    MAINTAIN_DELETE_PUBLISHED_ERROR("13302", "试卷正在被发布不能删除！"),
    /**
     * 维护试卷的数据持久化层发生错误
     */
    MAINTAIN_DATABASE_ERROR("13303", "维护试卷的数据持久化层发生错误！"),
    /**
     * 删除试卷异常
     */
    MAINTAIN_DELETE_ERROR("13304", "删除试卷发生错误！"),

    // 考试微服务
    /**
     * 试卷参数错误异常
     */
    PAPER_PARAMS_ERROR("2618", "试卷参数错误！"),
    /**
     * 试卷服务超时错误
     */
    PAPER_TIMEOUT_ERROR("2619","试卷服务超时错误!"),
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
