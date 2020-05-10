package com.heyuanjun.dataStructure.leetCode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的
 * 十进制值输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * Created by deng on 2020/3/27.
 */
public class LeetCode1290 {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        if (head == null) {
            return sum;
        }
        head = reversal(head);
        int i = 0;
        while (head != null) {
            sum += head.val * Math.pow(2, i);
            head = head.next;
            i++;
        }
        return sum;
    }

    public int getDecimalValue1(ListNode head) {
        int sum = 0;
        if (head == null) {
            return sum;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        for (int i = length - 1; i > -1; i--) {
            sum += head.val * Math.pow(2, i);
            head = head.next;
        }
        return sum;
    }

    public int getDecimalValue2(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    public ListNode reversal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur, tail = null;
        cur = head;
        while (cur.next != tail) {
            while (cur.next != tail) {
                int temp = cur.val;
                cur.val = cur.next.val;
                cur.next.val = temp;
                cur = cur.next;
            }
            tail = cur;
            cur = head;
        }
        return head;
    }

    public ListNode reversal1(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4});
        System.out.println((new LeetCode1290()).reversal1(node));
    }
}
