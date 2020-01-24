package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public void switchToFrameButton() {
		driver.switchTo().frame("intercom-borderless-frame");
	}
	/*
	public static object[][] getTestData(String sheetname){
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}try {
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}
	}*/
}
