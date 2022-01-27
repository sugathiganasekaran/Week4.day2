package week4.day2;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
	   driver.findElement(By.id("nav-search-submit-button")).click();
	   String pp = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
	   System.out.println("Price of First Product:" +pp);
	   
	   
	   
	   WebElement mouse = driver.findElement(By.xpath("//i[contains(@class='a-icon a-icon-star-small')]"));
	   Actions builder=new Actions(driver);
	   builder.moveToElement(mouse).perform();
	   String cusrate=driver.findElement(By.xpath("//span[text()='4.3 out of 5'])[6]")).getText();
	   System.out.println("Customer Rating is:" +cusrate);
       String star=driver.findElement(By.xpath("//div[@class='a-meter-bar a-meter-filled']")).getText();
       System.out.println(star);
	   
	  driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
	   Set<String> WindowHandles = driver.getWindowHandles();
		System.out.println(WindowHandles);
	   List<String> list=new ArrayList<String>(WindowHandles);
       String childwindow=list.get(1);
       driver.switchTo().window(childwindow);
      File src = driver.getScreenshotAs(OutputType.FILE);
   	  File des = new File("./images/button33.png");
      FileUtils.copyFile(src, des);
      driver.findElement(By.id("add-to-cart-button")).click(); 
      
      
      String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
	  System.out.println("SubTotal:" +subtotal);
	  if(pp.contains(subtotal)) {
		  System.out.println("Verfied");
	  }else
		  System.out.println("not verfied");
	
	
	
	
	
	   
	}}
