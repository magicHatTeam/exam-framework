package com.boss.bes.core.data.pojo.basevo.tree;


import apple.laf.JRSUIUtils;
import com.boss.bes.core.data.pojo.basevo.tree.node.AbstractTreeNode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 树结构的VO对象，使用时需要指定节点的类型
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-21 15:30
 */
@Valid
public class TreeVO<T extends AbstractTreeNode> {
    @NotNull(message = "树节点不能为空")
    private List<T> treeNodeList;

    public List<T> getTreeNodeList() {
        return treeNodeList;
    }

    public void setTreeNodeList(List<T> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }

    public TreeVO() {}

    public TreeVO(@NotNull(message = "树节点不能为空") List<T> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }

    @Override
    public String toString() {
        return "TreeVO{" +
                "treeNodeList=" + treeNodeList +
                '}';
    }
}
