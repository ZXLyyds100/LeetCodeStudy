package com.zxl.LeetCode.Solution;

import java.util.List;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
       ListNode first = findListNode(head);
       ListNode second = reverse(first.next);
       ListNode p1 = head;
       ListNode p2 = second;
       boolean result = true;
       while (result && p2 != null) {
           if (p1.val != p2.val) {
               result = false;
           }
           p1 = p1.next;
           p2 = p2.next;
       }
       first.next = reverse(second);
       return result;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode findListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
