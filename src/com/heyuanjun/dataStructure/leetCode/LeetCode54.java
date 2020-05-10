package com.heyuanjun.dataStructure.leetCode;

import com.heyuanjun.dataStructure.bst.BST;
import com.heyuanjun.dataStructure.bst.Node;
import com.heyuanjun.dataStructure.utils.TreePrintUtil;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * Created by deng on 2020/4/2.
 */
public class LeetCode54 {
    public int kthLargest(Node root, int k) {
        Stack<Integer> list = new Stack<Integer>();
        sort(root, list);
        for (int i = 1; i <= k; i++) {
            if (i == k) {
                return list.pop();
            }
            list.pop();
        }
        return 0;
    }

    private void sort(Node root, Stack list) {
        if (root == null) {
            return;
        }
        sort(root.left, list);
        list.push(root.e);
        sort(root.right, list);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        BST<Integer> bst = new BST<>();
        for (int i : nums) {
            bst.add(i);
        }
        TreePrintUtil.pirnt(bst.getRoot());
        LeetCode54 leetCode54 = new LeetCode54();
        int i = leetCode54.kthLargest(bst.getRoot(), 3);
        System.out.println(i);
    }
}
