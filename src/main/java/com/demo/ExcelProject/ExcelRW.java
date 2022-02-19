package com.demo.ExcelProject;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
    public static void main(String[] args) 
    {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"NAME", "LASTNAME", "EMAIL", "PASSWORD", "COMPANY", "ADDRESS", "CITY", "ZIP_CODE", "MOBILE_PHONE"});
        data.put("2", new Object[] {"Alfonso", "Rivera", "Alfonsozr98@gmail.com", "Hola123@", "Hexaware", "Calle X, #2", "Leon", "76000", "4427894462"});
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        System.out.println(keyset);
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("person.xlsx"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Completed");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
