package com.demo.ExcelProject;
import java.io.IOException;
import java.util.Map;

public class ExcelReadHashMap {
	
	public void readData () {
		
		try {
			Map<String, String> testData = ExcelRead.getMapData();
			
			System.out.println(testData.get("url"));
			System.out.println(testData.get("username"));
			System.out.println(testData.get("password"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ExcelReadHashMap data =  new ExcelReadHashMap();
	    data.readData();
	  }

}
