package Hot100.mid;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 每日温度
 */
public class _739 {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈
        //从左向右看
        //栈中保存的是 当前还未确定 ans 的下标
        //栈顶到栈底 递增
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);

        }
        return ans;
    }

    public int[] dailyTemperatures0(int[] temperatures) {
        /**
         * 单调栈
         */
        //从右向左遍历
        //单调栈 从栈顶到栈底递增 -- 想象折线图为一座座山
        //栈中存放数组下标，元素大小可根据下标访问数组直接获得
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
