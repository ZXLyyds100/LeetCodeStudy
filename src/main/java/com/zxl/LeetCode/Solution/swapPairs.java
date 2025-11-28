package com.zxl.LeetCode.Solution;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        /*if(head==null||head.next==null){//递归到末节点或者只有一个节点的时候停止
            return head;
        }
        ListNode newHead=head.next;
        head.next=swapPairs(newHead.next);
        newHead.next=head;
        return newHead;*/
        ListNode dummyNode = new ListNode(0, head);
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return dummyNode.next;
    }
}
