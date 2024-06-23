package com.sound.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtilities {
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	public static String LocatorColumnValue;
	public static String LocatorName;
	public static String LocatorValue;
	public static String keywordColumnValue;
	public static String dataColumnValue;
	public static int totalRows;
	
 public void readExcelFile(String location) throws IOException {
	 file=new FileInputStream(location);
	 workbook=new XSSFWorkbook(file);
	 sheet=workbook.getSheet("Sheet1");
	 totalRows=sheet.getLastRowNum();
 }
 public void getLocatorsKeywordsData(int row,int locatorColumn,int keywordColumn,int dataColumn) {
	 LocatorColumnValue=sheet.getRow(row).getCell(locatorColumn).toString().trim();
	 if(!LocatorColumnValue.contains("NA")) {
		 LocatorName=LocatorColumnValue.split("=")[0].toString().trim();
		 LocatorValue=LocatorColumnValue.split("=")[1].toString().trim();
	 }else {
		 LocatorName="NA";
		 LocatorValue="NA";
	 }
	 keywordColumnValue=sheet.getRow(row).getCell(keywordColumn).toString().trim();
	 dataColumnValue=sheet.getRow(row).getCell(dataColumn).toString().trim();
	 System.out.println(LocatorName+": "+LocatorValue+" Keyword: "+keywordColumnValue+" Data: "+dataColumnValue);
 }
 
 
}
