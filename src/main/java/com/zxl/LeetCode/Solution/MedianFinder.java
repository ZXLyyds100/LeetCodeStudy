package com.zxl.LeetCode.Solution;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> queMin;// 大根堆存较小部分
    PriorityQueue<Integer> queMax;// 小根堆存较大部分
    // 保证大根堆最多只比小根堆多1，小根堆数量<=大根堆，并且最多比大根堆少1
    public MedianFinder() {
        queMin = new PriorityQueue<>((a, b) -> b - a);
        queMax = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num < queMin.peek()) {
            queMin.offer(num);
            if (queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
