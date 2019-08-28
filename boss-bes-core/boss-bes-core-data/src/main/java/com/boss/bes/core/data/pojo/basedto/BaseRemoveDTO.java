package com.boss.bes.core.data.pojo.basedto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Iterator;
import java.util.List;

/**
 * 删除数据使用的DTO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 11:35
 */
@Valid
public abstract class BaseRemoveDTO {
    @NotNull(message = "待删除的id集合不能为空")
    private List<Long> idList;

    public BaseRemoveDTO() {}

    public BaseRemoveDTO(@NotNull(message = "待删除的id集合不能为空") List<Long> idList) {
        this.idList = idList;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        Iterator<String> source = idList.iterator();
        while (source.hasNext()) {
            this.idList.add(Long.valueOf(source.next()));
        }
    }
}
