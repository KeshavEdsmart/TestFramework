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
		String StudentID = "0";
		String ContactFname = "Sel";
		String ContactLname = "Contact";
	
		
		
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
		
//		for (int i=163;i<201;i++) {
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[12]/a/span[2]"))).click();
//			Thread.sleep(4000);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSearch\"]/span"))).click();
//			Thread.sleep(4000);
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/div[1]/a"))).click();
//			Thread.sleep(4000);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("participantFirstName"))).sendKeys(StudentFname + i);
//			driver.findElement(By.id("participantLastName")).sendKeys(StudentLname);
//			driver.findElement(By.id("schoolStudentId")).sendKeys(StudentID + i);
//			Thread.sleep(4000);
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddNewObject"))).click();
//			Thread.sleep(4000);
//			
//			System.out.println(i);
//		}
//		
//		
//		
//		// Create Parents
//		
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[13]/a/span[2]"))).click();
//		Thread.sleep(4000);
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sText"))).sendKeys("s");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSearch\"]/span"))).click();
//		Thread.sleep(4000);
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[3]/div[1]/a"))).click();
//		Thread.sleep(4000);
//		
//		for(int i = 71; i < 201; i++) {
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contactFirstName"))).sendKeys(ContactFname + i);
//			driver.findElement(By.id("contactLastName")).sendKeys(ContactLname);
//			driver.findElement(By.id("contactEmail")).sendKeys(ContactFname + i + "@seleniumtest.com");
//			Thread.sleep(4000);
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddNewObject"))).click();
//			Thread.sleep(4000);
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddNew"))).click();
//			Thread.sleep(4000);
//			
//			System.out.println(i);
//			
//		}
		
		
		//assign Parents to Students
		
		for (int i = 43; i < 201; i ++) {
			
			try {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[12]/a/span[2]"))).click();
				Thread.sleep(2000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sText"))).sendKeys(StudentFname + i);			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSearch\"]/span"))).click();
				Thread.sleep(2000);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"listData-list\"]/tbody/tr[1]/td[7]/button/span"))).click();
				Thread.sleep(2000);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aContacts"))).click();
				Thread.sleep(2000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddContactForStudent"))).click();			
				Thread.sleep(2000);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contacts"))).sendKeys(ContactFname + i);
				Thread.sleep(2000);
			
				driver.findElement(By.id("contacts")).click();
				Thread.sleep(2000);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contactModal\"]//div[2]/span//div[2]"))).click();
				Thread.sleep(1000);
				
				System.out.println(i);
			
			}catch(Exception e) {
				
				System.out.println("retrying with 1 less value of i");
				i--;
				
			}
			
			
		}
		
		
		System.out.println("Complete");	
		
		
		
		
				
				
				
	}

}
