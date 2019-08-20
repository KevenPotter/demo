package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("String");
        list.add(123);
        list.add(1.2);
        System.out.println(list.set(1, "add"));
        System.out.println(list);
        System.out.println("元素个数: " + list.size());
        System.out.println("下标为0的元素: " + list.get(0));
        System.out.println("下标为2的元素: " + list.get(2));
//        System.out.println("下标为3的元素: " + list.get(3));
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list.add(1);
        System.out.println("判断容器是否为空: " + list1.isEmpty());
        System.out.println("判断是否包含a字符串: " + list1.contains("a"));
        System.out.println("C字符串在容器中的位置: " + list1.indexOf("c"));
        list1.remove(0);
        System.out.println("移除容器中第一个元素后: " + list1);
        list1.remove(new Integer(1));
        System.out.println("移除容器中第1元素后: " + list1);
        list1.add(1, "d");
        System.out.println("在容器下标为1的位置添加字符串d: " + list1);
        list.add(list1);
        System.out.println(list);
    }
}
