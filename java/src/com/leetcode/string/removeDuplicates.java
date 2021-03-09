package com.leetcode.string;

import java.util.Stack;

/**
 * @ClassName: removeDuplicates
 * @Description: 1047. 删除字符串中的所有相邻重复项
 * @Author: jackey
 * @Create: 2021/3/9 下午7:48
 */
public class removeDuplicates {
    public String removeDuplicates(String S){
        /*转化为一个字符数组*/
        char[]  s=S.toCharArray();
        int len = s.length;
        Stack<Character> stack= new Stack<Character>();

        for (int i = 0;i<len;i++)   {
            if (stack.isEmpty() ||  stack.peek()!=s[i]){
                stack.push(s[i]);
            }else {
                stack.pop();
            }
        }

        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
            str = str.append(c);
        }
        return str.toString();

    }
}
