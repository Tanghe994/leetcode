package com.leetcode.stack;

import java.util.ResourceBundle;
import java.util.Stack;

/**
 * @ClassName: calculate
 * @Description: TODO
 * @Author: jackey
 * @Create: 2021/3/11 上午11:48
 */
public class calculate {
    public int calculate(String s) {
        /*创建一个栈*/
        Stack<Integer> ops = new Stack<>();
        int sign = 1;

        int rss = 0;
        int n = s.length();
        for (int i = 0; i < n; ) {
            switch (s.charAt(i)) {
                case (' '):
                    i++;
                case ('+'):
                    sign=ops.peek();
                    i++ ;
                case ('-'):
                    sign=-ops.peek();
                    i++;
                case ('('):
                    ops.push(sign);
                    i++;
                case (')'):
                    ops.pop();
                    i++;
                default:
                    long num = 0;
                    while (i<n&&Character.isDigit(s.charAt(i))){
                        num = num*10 + s.charAt(i)-'0';
                        i++;
                    }
                    rss += sign*num;
            }
        }


        return rss;


    }
}
