package com.heyuanjun.dataStructure.leetCode;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * Created by deng on 2020/3/27.
 */
public class LeetCode243 {
    public boolean isPalindrome(ListNode head) {
        //如果链表只有一个有效节点或者没有有效节点，return true
        if (head == null || head.next == null) {
            return true;
        }
        ListNode quick = head;
        ListNode slow = head;
        //快慢指针，快指针一次走两步，慢指针一次走一步
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        //从slow开始反转后半段链表
        ListNode pre = null;
        ListNode p = slow;
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        //对比前半段和后半段的data值是否相同
        while (pre != null) {
            if (pre.val == head.val) {
                pre = pre.next;
                head = head.next;
            } else {
                return false;
            }
        }
        //返回true
        return true;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 2, 1});
        System.out.println((new LeetCode243()).isPalindrome(node));
    }
}
