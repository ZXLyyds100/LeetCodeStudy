package com.zxl.LeetCode.Solution;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }
    public ListNode mergeLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l + r >> 1;
        return mergerTwoList(mergeLists(lists, l, mid), mergeLists(lists, mid + 1, r));
    }
    public ListNode mergerTwoList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode aPtr = a;
        ListNode bPtr = b;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        if (aPtr != null) {
            tail.next = aPtr;
        }
        if (bPtr != null) {
            tail.next = bPtr;
        }
        return dummy.next;
    }
}
