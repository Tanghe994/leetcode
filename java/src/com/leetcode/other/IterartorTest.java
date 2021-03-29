package com.leetcode.other;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName: IterartorTest
 * @Description: TODO
 * @Author: jackey
 * @Create: 2021/3/29 上午11:16
 */
public class IterartorTest {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<>();

        sites.add("google");
        sites.add("runoob");
        sites.add("taobao");
        sites.add("jindgong");

        Iterator<String> it = sites.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }

        System.out.println(sites);
    }
}
