package com.example.demo.signal;

public class Converter {

    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    public static void main(String[] args) {
        String a = "78, 78, 69, 67, 84, 32, 105, 112, 46, 99, 110, 58, 52, 52, 51, 32, 72, 84, 84, 80, 47, 49, 46, 49, 13, 10, 85, 115, 101, 114, 45, 65, 103, 101, 110, 116, 58, 32, 67, 104, 114, 111, 109, 101, 47, 55, 48, 46, 48, 46, 51, 53, 51, 56, 46, 55, 55, 32, 83, 97, 102, 97, 114, 105, 47, 53, 51, 55, 46, 51, 54, 13, 10, 72, 111, 115, 116, 58, 32, 105, 112, 46, 99, 110, 13, 10, 65, 99, 99, 101, 112, 116, 45, 69, 110, 99, 111, 100, 105, 110, 103, 58, 32, 103, 122, 105, 112, 44, 32, 100, 101, 102, 108, 97, 116, 101, 13, 10, 65, 99, 99, 101, 112, 116, 58, 32, 42, 47, 42, 13, 10, 13, 10";
        String stringResult = asciiToString(a.replace(" ", ""));
        System.out.println(stringResult);
    }
}
