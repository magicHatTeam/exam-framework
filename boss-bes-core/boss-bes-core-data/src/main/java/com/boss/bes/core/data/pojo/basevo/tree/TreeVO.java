package com.boss.bes.core.data.pojo.basevo.tree;


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
public class TreeVO<T extends AbstractTreeNode> {
    @Valid
    @NotNull(message = "树节点不能为空")
    private List<T> treeNodeList;

    public List<T> getTreeNodeList() {
        return treeNodeList;
    }

    public void setTreeNodeList(List<T> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }
}
