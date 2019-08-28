package com.boss.bes.core.data.pojo.basevo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 删除数据使用的VO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 11:35
 */
@Valid
public abstract class BaseRemoveVO {
    @NotNull(message = "待删除的id集合不能为空")
    private List<String> idList;

    public BaseRemoveVO(@NotNull(message = "待删除的id集合不能为空") List<String> idList) {
        this.idList = idList;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }
}
