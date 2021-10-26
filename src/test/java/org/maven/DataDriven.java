package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.poi.hssf.record.IterationRecord;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	
	public static void main(String[] args) throws IOException {
				
		File f = new File("C:\\Users\\91770\\eclipse-workspace\\Day1\\Excel\\data.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet my = wb.getSheet("Sheet1");
		
		Row PartiRow = my.getRow(1);
		
		Cell PartCel = PartiRow.getCell(4);
		
		Cell C = PartiRow.getCell(1);
		
		for (int i = 0; i < my.getPhysicalNumberOfRows(); i++) {
			Row iterateRow = my.getRow(i);
		
		for (int j = 0; j < iterateRow.getPhysicalNumberOfCells(); j++) {
			Cell iterateCell = iterateRow.getCell(j);
			System.out.println(iterateCell);
		}
	  }
	}
}

