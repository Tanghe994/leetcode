package com.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName: stack_min
 * @Description: TODO
 * @Author: jackey
 * @Create: 2021/3/9 下午3:28
 */
public class stack_min {
    private Stack<Integer> MainStack = new Stack<Integer>();
    private Stack<Integer> MinStack = new Stack<Integer>();

    /**
     * Push 入栈操作
     * @param element
     */
    public void push(int element) {
        MainStack.push(element);

        /*如果辅助栈为空，或者新元素小于或等于辅助栈栈顶，则将新元素压入辅助栈*/
        if (MinStack.empty()|| element<= MinStack.peek()){
            MinStack.push(element);
        }
    }
    /**
     * 出栈操作
     */
    public Integer pop() {
        //如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if (MainStack.peek().equals(MinStack.peek())) {
            MinStack.pop();
        }
        return MainStack.pop();
    }

    /**
     * 获取栈的最小元素
     */
    public int getMin() throws Exception {
        if (MainStack.empty()) {
            throw new Exception("stack is empty");
        }

        return MinStack.peek();
    }

    public static void main(String[] args) throws Exception {
        stack_min stack = new stack_min();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }

}
