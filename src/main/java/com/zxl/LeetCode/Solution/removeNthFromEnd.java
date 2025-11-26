package com.zxl.LeetCode.Solution;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
    public int getLength(ListNode head){
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        return cnt;
    }
}
