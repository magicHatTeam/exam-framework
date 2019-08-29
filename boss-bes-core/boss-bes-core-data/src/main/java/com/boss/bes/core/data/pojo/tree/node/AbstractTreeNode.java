package com.boss.bes.core.data.pojo.tree.node;

import com.alibaba.fastjson.JSON;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 所有树节点都需要继承的抽象类
 * 继承的时候必须重写toString方法
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-21 15:23
 */
@Valid
public abstract class AbstractTreeNode<T extends AbstractTreeNode> {
    @NotNull(message = "树节点id不能为空")
    @Min(value = 1, message = "树节点id必须大于0")
    private Integer id;
    @NotBlank(message = "节点名称不能为空")
    private String name;

    public AbstractTreeNode() {
    }

    public AbstractTreeNode(@NotNull(message = "树节点id不能为空") @Min(value = 1, message = "树节点id必须大于0") Integer id, @NotBlank(message = "节点名称不能为空") String name, List<T> childList) {
        this.id = id;
        this.name = name;
        this.childList = childList;
    }

    private List<T> childList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getChildList() {
        return childList;
    }

    public void setChildList(List<T> childList) {
        this.childList = childList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
