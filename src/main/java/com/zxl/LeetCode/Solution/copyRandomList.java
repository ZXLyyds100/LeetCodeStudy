package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.PriorityQueue;

public class copyRandomList {
   /* HashMap<Node, Node> mp = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!mp.containsKey(head)) {
            Node newNode = new Node(head.val);
            mp.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return mp.get(head);
    }*/
   public Node copyRandomList(Node head) {
       if (head == null) return null;
       for (Node node = head; node != null; node = node.next.next) {
           Node newNode = new Node(node.val);
           newNode.next = node.next;
           node.next = newNode;
       }
       for (Node node = head; node != null; node = node.next.next) {
           Node newNode = node.next;
           newNode.random = node.random != null ? node.random.next : null;
       }
       Node newHead = head.next;
       for (Node node = head; node != null; node = node.next) {
           Node newNode = node.next;
           node.next = node.next.next;
           newNode.next = node.next != null ? newNode.next.next : null;
       }
       return newHead;
   }

}
