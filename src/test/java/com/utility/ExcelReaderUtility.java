package com.utility;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String filename) {
		// TODO Auto-generated method stub

		
		File xlsxFile= new File(System.getProperty("user.dir")+"\\test-data\\"+filename);
		XSSFWorkbook xssfworkBook = null;
		XSSFSheet xssfSheet = null ;
		List<User> userList= new ArrayList<User>();
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Iterator<Row> rowIterator;
		
		try {
			xssfworkBook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfworkBook.getSheet("TestData");
			rowIterator = xssfSheet.iterator();
			
			rowIterator.next();//Skipping the column name
			
			while(rowIterator.hasNext())
			{
				
				
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell= row.getCell(1);
				User user = new User(emailAddressCell.toString(),passwordCell.toString());
				userList.add(user);
				
				
				
				
			}
			
			xssfworkBook.close();
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList.iterator();
		
		
		
		
	}

}



