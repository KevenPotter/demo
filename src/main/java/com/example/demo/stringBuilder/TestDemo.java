package com.example.demo.stringBuilder;

public class TestDemo {

    public static void main(String[] args) {
        String str = "111";
        String a = "111";
        String str2 = a + "";
//        String str2 = "111" + "";
        System.out.println(str == str2);
    }
}

class test {

    private static int sum = 0;

    public static void main(String[] args) {
        int a = 1;//a为第一个数据F(1)
        int b = 1;//a为第一个数据F(2)
        Fibonacci(a, b, 10);//循环10个数
    }

    public static void Fibonacci(int a, int b, int n) {
        if (sum >= 2) {
            int Fin = a + b;
            System.out.println(Fin);
            sum++;
            if (sum < n) {
                Fibonacci(b, Fin, n);//递归，b为前一个数，Fin是当前的数，递归后Fin是当前数的前一位
            }
        } else {
            int Fin = a;
            System.out.println(Fin);
            sum++;
            Fibonacci(a, b, n);
        }
    }
}
