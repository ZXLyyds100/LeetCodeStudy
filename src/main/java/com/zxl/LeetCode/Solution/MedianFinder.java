package com.zxl.LeetCode.Solution;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> queueMin = new PriorityQueue<>();
    PriorityQueue<Integer> queueMax = new PriorityQueue<>();
    public MedianFinder() {
        queueMin = new PriorityQueue<>((a, b) -> b - a);
        queueMax = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || num < queueMin.peek()) {
            queueMin.offer(num);
            if (queueMin.size() > queueMax.size() + 1) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMin.size() < queueMax.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queueMin.size() == queueMax.size()) {
            return (queueMin.peek() + queueMax.peek()) / 2.0;
        } else {
            return queueMin.peek();
        }
    }
}
