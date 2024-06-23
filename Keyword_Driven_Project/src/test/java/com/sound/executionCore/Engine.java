package com.sound.executionCore;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import com.sound.constants.Constants;
import com.sound.keywords.ActionKeywords;
import com.sound.utilities.ExcelUtilities;
import com.sound.utilities.Locators;

public class Engine {
	ActionKeywords actionkeywords;
	Method[] methods;
	public static String keyword;
	public static By Locator;
	
	public void getKeywordsFromActions() {
		actionkeywords=new ActionKeywords();
		methods=actionkeywords.getClass().getMethods();
	}
	
	public void executeKeywords() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(int i=0;i<methods.length;i++) {
			if(methods[i].getName().equalsIgnoreCase(ExcelUtilities.keywordColumnValue)) {
				methods[i].invoke(actionkeywords);
				break;
			}
		} 
	}
	
	public void findWebElementsToBeUsed() {
		switch(ExcelUtilities.LocatorName) {
		case Constants.ID:
			Locator=Locators.getId(ExcelUtilities.LocatorValue);
			break;
		case Constants.NAME:
			Locator=Locators.getName(ExcelUtilities.LocatorValue);
			break;
		case Constants.CLASS_NAME:
			Locator=Locators.getClassName(ExcelUtilities.LocatorValue);
			break;
		case Constants.XPATH:
			Locator=Locators.getXpath(ExcelUtilities.LocatorValue);
			break;
		case Constants.LINK_TEXT:
			Locator=Locators.getLinkText(ExcelUtilities.LocatorValue);
			break;
		case Constants.PARTIAL_LINK_TEXT:
			Locator=Locators.getPartialLinkText(ExcelUtilities.LocatorValue);
			break;
		case Constants.CSS_SELECTOR:
			Locator=Locators.getCssSelector(ExcelUtilities.LocatorValue);
			break;
		}
	}

	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ExcelUtilities utilities=new ExcelUtilities();
		utilities.readExcelFile(Constants.EXCEL_LOCATION);
		Engine engine=new Engine();
		engine.getKeywordsFromActions();
//		int locatorColumn=3;
//		int keywordColumn=locatorColumn+1;
//		int dataColumn=locatorColumn+2;
		for(int row=1;row<=ExcelUtilities.totalRows;row++) {
			 utilities.getLocatorsKeywordsData(row,Constants.LOCATOR_COLUMN,Constants.KEYWORD_COLUMN,Constants.KEYWORD_COLUMN);
			 engine.findWebElementsToBeUsed();
			 
			 engine.executeKeywords();          
			
	
		}

	}

}
