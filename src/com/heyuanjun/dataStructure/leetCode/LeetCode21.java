package com.heyuanjun.dataStructure.leetCode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * Created by deng on 2020/3/25.
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;
        while (l1 != null) {
            if (l1.next == null) {
                l1.next = l2;
                break;
            }
            l1 = l1.next;
        }
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = null;
        ListNode cur = head;
        while (cur.next != tail) {
            while (cur.next != tail) {
                if (cur.val > cur.next.val) {
                    int temp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = temp;
                }
                cur = cur.next;
            }
            tail = cur;
            cur = head;
        }
        return head;
    }

    /*我们直接将以上递归过程建模，首先考虑边界情况。
    特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，
    所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个的头元素更小，
    然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。*/
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 2, 6, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4, 5});
        ListNode l3 = new ListNode(new int[]{1, 3});
//        System.out.println(ListNode.nodeToString((new LeetCode21()).exChane(l3)));
        System.out.println(((new LeetCode21()).mergeTwoLists(l1, l2)));
    }
}
