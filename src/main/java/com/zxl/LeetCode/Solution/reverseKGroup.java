package com.zxl.LeetCode.Solution;


public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] tuple = reverse(head, tail);
            head = tuple[0];
            tail = tuple[1];
            prev.next = head;
            tail.next = nex;
            head = tail.next;
            prev = tail;
        }
        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail) {
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return new ListNode[]{tail, head};

    }

    public static void main(String[] args) {

    }
}
