package com.boss.bes.core.data.pojo.basedto;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-28 19:32
 */
@Valid
public abstract class BaseInfoDTO<T extends BaseModDTO> {
    /**
     * 显示在表格中的VO集合（因为表格中的单个VO和增加/删除VO类似）
     */
    private List<T> dataList;
    /**
     * 当前查询条件下总共的数据条数
     */
    private Long dataCount;

    public BaseInfoDTO() {
    }

    public BaseInfoDTO(List<T> dataList, Long dataCount) {
        this.dataList = dataList;
        this.dataCount = dataCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }
}
