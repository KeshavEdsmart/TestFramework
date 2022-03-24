package ParentResponses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentResponse {

	public static void main(String[] args) throws Exception {
		
		String Website = "https://app-release.edsmart.com/r/";
		
		
		
		// Chrome setup

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		String numKids = "5";
		String name = "Selenium";
		String number = "0214586355";
		String relation = "Father";
		
		
		// Import the Excel file with the response ID data
		
		File source = new File("C:\\EDSMART\\Selenium\\Edsmart Data\\ResponseData.xlsx");		//Excel file path
		FileInputStream inputStream = new FileInputStream(source);				//Create input stream
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);					//Create workbook
		XSSFSheet sheet = workbook.getSheetAt(0);								//Access the excel sheet
		XSSFCell value = null;	    //Variable to store cell
		String cellValue = null;							// Store cell value
		int flag = 0;
		
		
		int totalRows = sheet.getLastRowNum();									//Store number of rows
		
		System.out.println(totalRows); 
		
		// Loop to check values
		
		for(int i=1; i<= totalRows; i++) {
			
			value = sheet.getRow(i).getCell(0);							//Store cell 
			
			cellValue = value.getStringCellValue();				//Store cell value
			
			System.out.println(i + "	" + cellValue); 			// Print value
			
			driver.get(Website + cellValue);				// Open browser with link
			driver.manage().window().maximize();			// Maximise browser
			
			
			// Select "Agree" on consent dropdown
			WebElement down = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fieldId10-contactResponseId")));
			Select select = new Select (down);
			Thread.sleep(1000);
			select.selectByValue("9");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fieldId5-fieldValueNvarchar3"))).sendKeys(numKids+i);
			driver.findElement(By.id("fieldId6-fieldValueNvarchar4")).sendKeys(name+i);
			driver.findElement(By.id("fieldId7-fieldValueNvarchar5")).sendKeys(number);
			driver.findElement(By.id("fieldId8-fieldValueNvarchar6")).sendKeys(relation);
			driver.findElement(By.id("btnResponse")).click();
			
			try {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPrintResponse")));
			}catch (Exception e){
				flag++;
			}
			
			
			
			driver.switchTo().newWindow(WindowType.TAB);
			

		}
		
		System.out.println("Complete");
		System.out.println(flag);
		
		
		
		
	
		
		
		
		workbook.close();

	}

}
