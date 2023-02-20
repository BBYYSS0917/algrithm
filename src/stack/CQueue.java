package stack;

import java.util.Stack;

/**
 * 用两个栈实现队列，队列是先进先出
 *
 * @author BaiJY
 * @date 2023/02/20
 **/
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        //主要思想：每次delete head的时候stack2缓存了一批数据
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.empty() ? -1 : stack2.pop();
    }


    public static void main(String[] args) {

        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
    }
}
