package com.zxl.LeetCode.Solution;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pre = new ListNode(-1);
        ListNode dumpy = pre;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        pre.next = p1 == null ? p2 : p1;
        return dumpy.next;
    }
}
