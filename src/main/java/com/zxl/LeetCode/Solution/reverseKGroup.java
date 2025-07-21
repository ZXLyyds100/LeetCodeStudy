package com.zxl.LeetCode.Solution;


public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode(0);
        hair.next=head;
        ListNode pre=hair;
        while(head!=null){
            ListNode tail=pre;
            for(int i=0;i<k;i++){
                tail=tail.next;
                if(tail==null){
                    return hair.next;
                }
            }
            ListNode nex=tail.next;
            ListNode[] reverse = reverse(head, tail);
            head=reverse[0];
            tail=reverse[1];
            pre.next=head;
            tail.next=nex;
            pre=tail;
            head=tail.next;
        }
        return hair.next;
    }
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode prev=tail.next;
        ListNode cur=head;
        while(prev!=tail){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return new ListNode[]{tail,head};
    }

}
