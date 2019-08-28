package com.boss.bes.core.data.pojo.basedto;

import java.util.List;

/**
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-28 19:32
 */
public abstract class BaseInfoDTO<T extends BaseModDTO> {
    /**
     * 显示在表格中的VO集合（因为表格中的单个VO和增加/删除VO类似）
     */
    private List<T> dataList;
    /**
     * 当前分页条件下，一页中拥有的数据条数
     */
    private Integer pageSize;
    /**
     * 当前分页条件下，一页中拥有的数据条数
     */
    private Integer pageNum;
    /**
     * 当前查询条件下总共的数据条数
     */
    private Integer dataCount;

    public BaseInfoDTO() {
    }

    public BaseInfoDTO(List<T> dataList, Integer pageSize, Integer pageNum, Integer dataCount) {
        this.dataList = dataList;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.dataCount = dataCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }
}
