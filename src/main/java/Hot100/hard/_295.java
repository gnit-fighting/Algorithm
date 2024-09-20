package Hot100.hard;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * 思路：
 * 1. 升序：左半边维护一个最大堆
 *        ：右半边维护一个最小堆
 * 2. 中位数：最大堆的堆顶、最小堆的堆顶 决定
 * 3. n 为奇数，左最大堆比右最小堆多一个元素，中位数为左最大堆的堆顶
 *    n 为偶数，中位数为左右堆顶的平均值
 * 4. 插入元素：O(logn):插入元素到最大堆/最小堆可能导致元素的上升和下沉，树的高度为logn
 *    获取中位数：O(1)
 */
public class _295 {

    class MedianFinder {
        int size;
        PriorityQueue<Integer> lMaxHeap ;
        PriorityQueue<Integer> rMinHeap;

        public MedianFinder() {
            size = 0 ;
            lMaxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
            rMinHeap = new PriorityQueue<Integer>((o1, o2) -> o1-o2);
        }

        public void addNum(int num) {
            Integer lmax = lMaxHeap.peek();
            Integer rmax = rMinHeap.peek();
            //1.插入前 size 为奇数
            if (size%2==1) {
                //1.1 num >= lmax ; num插入到右最小堆
                if (num>=lmax) {
                    rMinHeap.offer(num);
                }
                //1.2 num < lmax; num 插入到左最大堆
                //    左最大堆元素个数溢出，将堆顶元素插入右最小堆
                else {
                    lMaxHeap.offer(num);
                    Integer poll = lMaxHeap.poll();
                    rMinHeap.offer(poll);
                }
            }

            //2.插入前 size为偶数
            if (size%2==0) {
                //2.1 num<=lmax;num插入到左最大堆
                if (lmax==null||num<=lmax) {
                    lMaxHeap.offer(num);
                }
                //2.2 num > lmax ;num 插入右最大堆
                //    右最小堆元素个数溢出，将堆顶元素插入左最小堆
                else {
                    rMinHeap.offer(num);
                    Integer poll = rMinHeap.poll();
                    lMaxHeap.offer(poll);
                }
            }
            size++;
        }

        public double findMedian() {
            if (size==0) {
                return 0;
            }
            if (size%2==0) {
                return (lMaxHeap.peek()+rMinHeap.peek())/2.0;
            }
            return  lMaxHeap.peek();
        }
    }
}
