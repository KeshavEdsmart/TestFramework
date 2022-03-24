package ParentResponses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentParentCreation {

	public static void main(String[] args) throws InterruptedException {
		
		// Variables used in the script
		
		String Website = "https://admin-release.edsmart.com/home";
		String AdminID = "testautomation@edsmart.com";
		String AdminPass = "A49cBFi9Wbw*x#Q8fg}^#J}w";
		String AccountName = "Selenium Test account";
		String StudentFname = "Sel";
		String StudentLname = "Student";
		String ContactFname = "Sel";
		String ContactLname = "Contact";
		
		
		// Chrome setup and website login using username and password
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(Website);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116"))).sendKeys(AdminID);
		driver.findElement(By.id("idSIButton9")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i0118\"]"))).sendKeys(AdminPass);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
		
		//Signing in Selenium Test account
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[1]/li[2]/a"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sText"))).sendKeys(AccountName);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(1000);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"168329972\"]/td[2]/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bs-navbar-collapse-2\"]/form/span/button"))).click();
		
		
		// Switch Window
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
				
		// Create Student
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[13]/a/span[2]"))).click(); //Click on "Student" in dashboard
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[4]/div[1]/a"))).click(); // Click on "Add new" button
		Thread.sleep(1000);
		
		// Loop to create 100 students
		
		for(int i=1;i<101;i++) {
			driver.findElement(By.id("participantFirstName")).sendKeys(StudentFname + i);
			driver.findElement(By.id("participantLastName")).sendKeys(StudentLname);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddNewObject"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddNew"))).click();
			System.out.println(i);
		}
		
		
		// Add Student ID to all the students
		
		for (int i=1, j=1000; i<101; i++, j++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[13]/a/span[2]"))).click(); //Click on "Student" in dashboard
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sText"))).sendKeys(StudentFname + i);		// Search Student by name
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"listData-list\"]/tbody/tr/td[7]/button"))).click();		//Click on view Student
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnEditObject"))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schoolStudentId"))).sendKeys(String.valueOf(j));
			driver.findElement(By.id("btnAddNewObject")).click();
			Thread.sleep(2000);
			System.out.println(i);
		}
		
		// Create Parent
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[14]/a/span[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div[3]/div[1]/a"))).click();
		Thread.sleep(1000);

		// Loop to create 100 parents

		for(int i=95; i<101; i++) {
			driver.findElement(By.id("contactFirstName")).sendKeys(ContactFname + i);
			driver.findElement(By.id("contactLastName")).sendKeys(ContactLname);
			driver.findElement(By.id("contactEmail")).sendKeys(ContactFname + i + "@seleniumtest.com");
			driver.findElement(By.id("btnAddNewObject")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddNew"))).click();
			Thread.sleep(2000);
			System.out.println(i);
		}
		
		// Link Students with Parents
		// Loop to Link Students with Parents
		
		for(int i=77; i<101; i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[13]/a/span[2]"))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sText"))).sendKeys(StudentFname + i);
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"listData-list\"]/tbody/tr/td[7]/button"))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aContacts"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddContactForStudent"))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contacts"))).sendKeys(ContactFname + i);
			Thread.sleep(2000);
			driver.findElement(By.id("contacts")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contactModal\"]//div[2]/span//div[2]"))).click();
			Thread.sleep(1000);
			System.out.println(i);
		}
		
		System.out.println("Complete");
	}

}
