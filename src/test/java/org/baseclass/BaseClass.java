package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void windowMaximize() {

		driver.manage().window().maximize();

	}

	public static void launchUrl(String url) {

		driver.get(url);

	}

	public static void currentPageTitle() {

		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void currentPageUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void passtext(String Value, WebElement ref) {

		ref.sendKeys(Value);

	}

	public static void login(WebElement log) {

		log.click();

	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void getAttributeValue(WebElement Ref) {
		
		 String att = Ref.getAttribute("value");
		   System.out.println("Print the value for the sendkeys :" + att);
		
	}
	public static JavascriptExecutor js;

	public static void scrollpage(WebElement target) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", target);

	}
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void javascriptClick(WebElement targetWebelement) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", targetWebelement);

	}

	public static void javascriptgetattribute(WebElement targetWebelement) {

		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", targetWebelement);
	}

	public static void javascriptsetattribute(WebElement targetWebelement, String value) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", targetWebelement);
	}

	public static void screenshoot(String imageName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File("C:\\Users\\91770\\eclipse-workspace\\Day1\\Screenshot\\" + imageName + ".png");
		FileUtils.copyFile(source, destination);
	}

	public static Actions a;

	public static void movetoelement(WebElement target) {

		a = new Actions(driver);
		a.moveToElement(target).perform();

	}

	public static void dragAndDrop(WebElement source, WebElement target) {

		a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void contextClick() {
		a.contextClick().perform();
	}

	public static void doubleclick() {
		a.doubleClick();
	}

	public static void sendValueToSearch(WebElement Ref, String value) {

		a.keyDown(Keys.SHIFT).sendKeys(Ref, value).keyUp(Keys.SHIFT).perform();
	}

	public static void excelGetValue(String fileName, String sheetName , int rowNum , int cellNum) throws IOException {
		File f = new File("C:\\Users\\91770\\eclipse-workspace\\Day1\\Excel\\" + fileName + ".xlsx");

		FileInputStream fis = new FileInputStream(f);
		
		// instance

		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet Sheet = wb.getSheet(sheetName);
		
		Row row = Sheet.getRow(rowNum);
		
		Cell cell = row.getCell(cellNum);
		
		int cellType = cell.getCellType();
		String value;
		if (cellType == 1) {
			
			 value = cell.getStringCellValue();
		}else if (DateUtil.isCellDateFormatted(cell)) {
			 Date dateCellValue = cell.getDateCellValue();
			 SimpleDateFormat s = new SimpleDateFormat("E, MMM dd yyyy ");
			 value = s.format(dateCellValue);
		} else {
			
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			 value = String.valueOf(1);
		}
		
		System.out.println(value);
		
	}

	public static void excelCreation (int rowNum , int cellNum , String sheetName, String value ,String folderName) throws IOException {

		File f = new File("C:\\Users\\91770\\eclipse-workspace\\Day1\\Excel\\"+ folderName +".xlsx");

		Workbook workb = new XSSFWorkbook();

		Sheet Cresh = workb.createSheet(sheetName);

		Row createRow = Cresh.createRow(rowNum);

		Cell createCell = createRow.createCell(cellNum);

		createCell.setCellValue(value);

		FileOutputStream Fos = new FileOutputStream(f);

		workb.write(Fos);
		
		System.out.println("Writed");
	}

	public static void cellCreation(String sheetName , int cellNum ,String folderName , int rowNum, String value) throws IOException {
		
		File f = new File("C:\\Users\\91770\\eclipse-workspace\\Cucumber1\\Excel\\" + folderName + ".xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell createCell = row.createCell(cellNum);
		createCell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		System.out.println("writed...");

	}
	
	public static void createRow(int rowNum, int cellNum , String sheetName, String value, String folderName ) throws IOException {

		File f = new File("C:\\Users\\91770\\eclipse-workspace\\Cucumber1\\Excel\\" + folderName + ".xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		Cell createCell = row.createCell(cellNum);
		createCell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		System.out.println("writed...");

	}
	public static void updateToParticularCell(String existValue,String newValue, String sheetName , int rowNum, String folderName, int cellNum) throws IOException {
		
		File f = new File("C:\\Users\\91770\\eclipse-workspace\\Day1\\Excel"+folderName +".xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fis);
		
		Sheet sheet = w.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String scv = cell.getStringCellValue();
		
		if (scv.equals(existValue)) {
			
			cell.setCellValue(newValue);
		}
		
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

}
