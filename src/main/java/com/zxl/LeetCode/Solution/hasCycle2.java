package com.zxl.LeetCode.Solution;

import java.util.HashSet;
import java.util.Set;

public class hasCycle2 {
    public ListNode detectCycle(ListNode head) {
      /*  Set<ListNode>s=new HashSet<>();
        ListNode pos=head;
        while(pos!=null){
            if(s.contains(pos)){
                return pos;
            }else {
                s.add(pos);
            }
            pos=pos.next;
        }
        return null;*/
        if(head==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;
            }
            if(fast==slow){
                ListNode ptr=fast;
                while(ptr!=slow){
                    slow=slow.next;
                    ptr=ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
