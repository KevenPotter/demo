package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void stringContains() {
        String single = "Time2015011419074500000000mc2234141242over";
        if (single.contains("Time")) {
//            System.out.println(Long.valueOf(single.subSequence(single.indexOf("mc"), single.indexOf("over")).toString().replace("mc", "")));
            System.out.println(new SimpleDateFormat("HHmm").format(new Date()));
            System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        } else {
            System.out.println("啥也没有");
        }


        String single2 = "stamc1112veenslfnptstcu0vo0pw0el0ptstcu0vo0pw0el0ptstcu2792vo235pw361el348ptstcu0vo0pw0el0ptstcu0vo0pw0el0ptstcu0vo0pw0el0ptstcu0vo0pw0el0ptstcu0vo0pw0el0no000018721253eq00026608rcend";
        System.out.println(single2.length());
    }

    @Test
    public void byteToInt() {
        System.out.println((byte) -127 & 0XFF);
        File file = new File("a.txt");
    }


}
