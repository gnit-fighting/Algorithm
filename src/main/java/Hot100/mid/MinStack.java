package Hot100.mid;

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> priorityQueue;

    public MinStack() {
        stack = new Stack<>();
        priorityQueue = new PriorityQueue<>();

    }

    public void push(int val) {
        stack.push(val);
        priorityQueue.add(val);


    }

    public void pop() {
        Integer pop = stack.pop();
        priorityQueue.remove(pop);
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return priorityQueue.peek();

    }
}