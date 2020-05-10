package com.heyuanjun.dataStructure.leetCode;

/**
 * Created by deng on 2020/3/25.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is not null");
        }
        val = arr[0];
        ListNode temp = this;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode node = this;
        stringBuilder.append("Head: ").append(node.val).append("-->");
        node = node.next;
        while (node != null) {
            stringBuilder.append(node.val).append("-->");
            node = node.next;
        }
        stringBuilder.append("Null tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 3, 6, 6, 8});
        System.out.println(node);
    }
}
