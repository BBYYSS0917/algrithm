package stack;

import java.util.Stack;

/**
 * @author BaiJY
 * @date 2023/02/20
 **/
public class MinStack {

    private int min;
    int size = 0;
    int top = 0;
    Stack<Integer> stack1;
    Stack<Integer> stack2;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (x < min) {
            min = x;
            stack2.push(x);
        }

        size++;
    }

    public void pop() {
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
//        System.out.println(minStack.min());
    }
}
