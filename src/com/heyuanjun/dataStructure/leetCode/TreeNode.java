package com.heyuanjun.dataStructure.leetCode;

import com.heyuanjun.dataStructure.bst.Node;

/**
 * 树节点
 * Created by deng on 2020/4/2.
 */
public class TreeNode extends Node {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        super(x);
        val = x;
    }

    public TreeNode getLeftChild() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRightChild() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
