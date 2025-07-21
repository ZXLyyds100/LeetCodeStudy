package com.zxl.LeetCode.Solution;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=getLength(head);
        if(length==n){
            return head.next;
        }
        ListNode cur=head;
        for(int i=1;i<length-n;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
    public int getLength(ListNode head){
        int l=0;
        ListNode cur=head;
        while(cur!=null){
            l++;
            cur=cur.next;
        }
        return l;
    }
}
