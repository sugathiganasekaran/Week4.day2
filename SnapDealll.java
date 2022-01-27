package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealll{
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	   WebElement elee=driver.findElement(By.xpath("//span[@class='catText']"));
	  Actions builder=new Actions(driver);
	  builder.moveToElement(elee).perform();
	 driver.findElement(By.xpath("//span[@class='linkTest']")).click();
     String items = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
	  System.out.println("Get the Count:" +items);
	  
	  driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
	  String rt1 = driver.findElement(By.xpath("//span[@data-price='539']")).getText();
	 System.out.println("First Shoe Price:" +rt1);
	 
	  WebElement we = driver.findElement(By.className("sort-selected"));
	  we.click();
	  driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
	  String t2rs = driver.findElement(By.xpath("//span[@data-price='489']")).getText();
	   System.out.println("Second Shoe Price:" +t2rs);
	 if(rt1.equals(t2rs)) {
		 System.out.println("Sorted Improperly");}
	else {
		System.out.println("Sorted Properly");}
	
	  WebElement yy=driver.findElement(By.name("fromVal"));
	  yy.clear();
	 yy.sendKeys("900");
	  WebElement zz=driver.findElement(By.name("toVal"));
	  zz.clear();
	  zz.sendKeys("1200");
	  driver.findElement(By.xpath("//div[text()[normalize-space()='GO']]")).click();
	  driver.findElement(By.xpath("//div[@data-displayname='Color']//div")).click();
	   driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
	   String color = driver.findElement(By.xpath("//a[@class='clear-filter-pill  ']")).getText();
	   System.out.println(color);
	  
	   if(color.contains("Navy")) {
		   System.out.println("Filtered");
	   }else {
		   System.out.println("Not Filtered");
	   }
	   
	   WebElement wegg=driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
	  wegg.click();
	  String rs = driver.findElement(By.xpath("//span[text()='1,099 ']")).getText();
	  System.out.println("Price:" +rs);
	  String off = driver.findElement(By.xpath("//span[text()='83% Off']")).getText();
	  System.out.println("Discount price:" +off);
	  File srccc = wegg.getScreenshotAs(OutputType.FILE);
      File ddes = new File("./images/button11.png");
	  FileUtils.copyFile(srccc, ddes);
	  driver.close();
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	}}
