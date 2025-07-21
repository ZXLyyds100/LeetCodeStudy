package com.zxl.LeetCode.Solution;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       /* ListNode l1=list1;
        ListNode l2=list2;
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }*/
        ListNode preHead=new ListNode(-1);
        ListNode pre=preHead;
        ListNode l1=list1;
        ListNode l2=list2;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre.next=l1;
                l1=l1.next;
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        pre.next=l1==null?l2:l1;
        return preHead.next;
    }
}
