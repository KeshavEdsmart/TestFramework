package parentInterview;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentParentCreation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String Website = "https://desa-admin-dv.edsmart.com/home";
		String AdminID = "testautomation@edsmart.com";
		String AdminPass = "A49cBFi9Wbw*x#Q8fg}^#J}w";
		String AccountName = "Selenium Test";
		String StudentFname = "Sel";
		String StudentLname = "Student";
		String StudentID = "1";
		
		
		// Chrome setup and website login using username and password
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(Website);
		driver.manage().window().maximize();
				
		WebDriverWait wait = new WebDriverWait(driver,10);
				
		// Sign into admin
		
		Thread.sleep(1000);
		driver.findElement(By.id("office-365-login")).click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116"))).sendKeys(AdminID);
		driver.findElement(By.id("idSIButton9")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))).sendKeys(AdminPass);
		driver.findElement(By.id("idSIButton9")).click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
		
		// Log into school
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[1]/li[2]/a"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sText"))).sendKeys(AccountName);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"168326387\"]/td[2]/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bs-navbar-collapse-2\"]/form/span/button"))).click();
		
		
		// Switch Window
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		
		// Create Students
		
		for (int i=1;i<5;i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[12]/a/span[2]"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSearch\"]/span"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/div[1]/a"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("participantFirstName"))).sendKeys(StudentFname + i);
			driver.findElement(By.id("participantLastName")).sendKeys(StudentLname);
			driver.findElement(By.id("schoolStudentId")).sendKeys(StudentID + i);
			Thread.sleep(1000);
			driver.findElement(By.id("btnAddNewObject")).click();
			Thread.sleep(1000);
		}
		
		
		System.out.println("Complete");	
		System.out.println("print");
		System.out.println("first");
		
		
		
				
				
				
	}

}
