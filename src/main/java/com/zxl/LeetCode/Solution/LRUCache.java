package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedList {
        DLinkedList prev;
        DLinkedList next;
        int value;
        int key;

        public DLinkedList() {};
        public DLinkedList(int value, int key) {
            this.key = key;
            this.value = value;
        }
    }
    private DLinkedList head;
    private DLinkedList tail;
    private int capacity;
    int size;
    private HashMap<Integer, DLinkedList> cache = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            DLinkedList newNode = new DLinkedList(value, key);
            ++size;
            cache.put(key, newNode);
            addToHead(newNode);
            if (size > capacity) {
                DLinkedList dLinkedList = removeTail();
                cache.remove(dLinkedList.key);
                size--;
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    private void addToHead(DLinkedList node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }
    private DLinkedList removeTail() {
        DLinkedList prev = tail.prev;
        removeNode(prev);
        return prev;
    }
}

