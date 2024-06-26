package Hot100.hard;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 */
public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //单调队列
        //先让第一个窗口的元素进入单调队列
        int[] result = new int[nums.length-k+1];
        int j = 0;
        Queue myQueue = new Queue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        result[j++] = myQueue.getpeek();



        //后面：进一个元素，出一个元素，获取最大值
        for (int i = k; i <nums.length ; i++) {
            myQueue.push(nums[i]);
            myQueue.pop(nums[i-k]);
            result[j++] = myQueue.getpeek();

        }
        return result;

    }

    class Queue {
        LinkedList<Integer> queue = new LinkedList<>();

        int getpeek() {
            return queue.getFirst();
        }

        void pop(int x) {
            if (x == queue.getFirst()) {
                queue.pollFirst();

            }

        }

        void push(int x) {
            if (queue.isEmpty()) {
                queue.add(x);
                return;
            }

            while (!queue.isEmpty() && x > queue.getLast()) {
                queue.pollLast();
            }
            //出循环后，这里 x>= queue.getLast()
            queue.add(x);
        }
    }
}
