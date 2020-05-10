package com.heyuanjun.dataStructure.leetCode;

import com.heyuanjun.dataStructure.bst.BST;
import com.heyuanjun.dataStructure.bst.Node;
import com.heyuanjun.dataStructure.utils.TreePrintUtil;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * Created by deng on 2020/4/2.
 */
public class LeetCode55 {
    public int maxDepth(TreeNode root) {
        return 0;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        BST<Integer> bst = new BST<>();
        for (Integer i : nums) {
            bst.add(i);
        }
        Node root = bst.getRoot();
        TreePrintUtil.pirnt(root);
    }
}
