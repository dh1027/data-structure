package com.heyuanjun.dataStructure.leetCode;

import com.heyuanjun.dataStructure.bst.BST;
import com.heyuanjun.dataStructure.bst.Node;
import com.heyuanjun.dataStructure.utils.TreePrintUtil;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和值: 2
 * 你应该返回如下子树:
 * <p>
 * 2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * Created by deng on 2020/4/2.
 */
public class LeetCode700 {
    public Node searchBST(Node<Integer> root, int val) {
        if (root == null) {
            return null;
        }
        Node node = root;
        if (val < (int) node.e) {
            node = searchBST(root.left, val);
        } else if (val > (int) node.e) {
            node = searchBST(root.right, val);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 3, 5, 8, 1, 4};
        BST<Integer> bst = new BST<>();
        for (int i : nums) {
            bst.add(i);
        }
        TreePrintUtil.pirnt(bst.getRoot());
        LeetCode700 leetCode700 = new LeetCode700();
        Node node = leetCode700.searchBST(bst.getRoot(), 4);
        TreePrintUtil.pirnt(node);
    }
}
