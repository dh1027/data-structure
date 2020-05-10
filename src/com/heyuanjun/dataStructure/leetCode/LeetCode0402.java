package com.heyuanjun.dataStructure.leetCode;

import com.heyuanjun.dataStructure.utils.TreePrintUtil;

import java.util.Arrays;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3  9
 * /   /
 * -10  5
 * <p>
 * Created by deng on 2020/4/2.
 */
public class LeetCode0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int minIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[minIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, minIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, minIndex + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreePrintUtil.pirnt((new LeetCode0402()).sortedArrayToBST(nums));
    }


}
