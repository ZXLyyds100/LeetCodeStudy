package com.zxl.LeetCode.Solution;




import java.util.HashSet;
import java.util.Set;

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*Set<ListNode>visited=new HashSet<>();
        ListNode temp=headA;
        while(temp!=null){
            visited.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(visited.contains(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;*/

        ListNode pA=headA;
        ListNode pB=headB;
        while(pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
}
