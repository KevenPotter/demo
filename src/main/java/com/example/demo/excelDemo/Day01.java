package com.example.demo.excelDemo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Day01 {
    public static void main(String[] args) throws IOException {
        Workbook wb0 = new HSSFWorkbook();
        FileOutputStream fileOutputStream0 = new FileOutputStream("workbook0.xls");
        wb0.write(fileOutputStream0);
        fileOutputStream0.close();
        Workbook wb1 = new XSSFWorkbook();
        FileOutputStream fileOutputStream1 = new FileOutputStream("workbook1.xlsx");
        wb1.write(fileOutputStream1);
        fileOutputStream1.close();
    }
}
