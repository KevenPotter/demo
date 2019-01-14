package com.example.demo.excelDemo;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Day02 {
    public static void main(String[] args) throws IOException {
        createSheetTest();
    }

    public static void createSheetTest() throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");
        String safeName = WorkbookUtil.createSafeSheetName("[O'Breien's sales*?]");
        Sheet sheet3 = wb.createSheet(safeName);
        FileOutputStream fileOutputStream = new FileOutputStream("workbook.xlsx");
        wb.write(fileOutputStream);
        fileOutputStream.close();
    }
}
