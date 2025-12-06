package com.zxl.LeetCode.Solution;

import javax.print.attribute.standard.SheetCollate;
import java.util.List;

public class sortList {
    /*    public ListNode sortList(ListNode head) {
            return sortList(head,null);
        }
        public ListNode sortList(ListNode head,ListNode tail){
            if(head==null){
                return null;
            }
            if(head.next==tail){
                head.next=null;
                return head;
            }
            ListNode fast=head,slow=head;
            while(fast!=tail){
                fast=fast.next;
                slow=slow.next;
                if(fast!=tail){
                    fast=fast.next;
                }
            }
            ListNode mid=slow;
            ListNode list1=sortList(head,mid);
            ListNode list2=sortList(mid,tail);
            return merge(list1,list2);
        }
        public ListNode merge(ListNode head1,ListNode head2){
            ListNode dummy=new ListNode(0);
            ListNode temp=dummy;
            ListNode temp1=head1,temp2=head2;
            while(temp1!=null&&temp2!=null){
                if(temp1.val<= temp2.val){
                    temp.next=temp1;
                    temp1=temp1.next;
                }else{
                    temp.next=temp2;
                    temp2=temp2.next;
                }
                temp=temp.next;
            }
            if(temp1!=null){
                temp.next=temp1;
            }
            if(temp2!=null){
                temp.next=temp2;
            }
            return dummy.next;
        }*/
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        // 从1开始
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                // head2可能为null
                for (int i = 1; i < subLength && cur!= null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }

                cur = next;
            }
        }
        return dummy.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        return dummy.next;
    }

}
