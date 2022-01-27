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

public class Myntra {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.myntra.com/");
	   driver.manage().window().maximize();
	  
	   WebElement myn=driver.findElement(By.xpath("//a[@class='desktop-main']"));
	   Actions builder=new Actions(driver);
	   builder.moveToElement(myn).perform();
	   driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
	   String items = driver.findElement(By.xpath("//span[text()='9968']")).getText();
	   System.out.println("Total Count:" +items);
	   driver.findElement(By.xpath("//div[text()='258']")).click();
	   driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
	   driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div")).click();
	   driver.findElement(By.xpath("//ul[@class='FilterDirectory-indices']/following-sibling::span[1]")).click();
	   String du = driver.findElement(By.xpath("//div[text()='Duke']")).getText();
	    System.out.println(du);
	    List<WebElement> w = driver.findElements(By.xpath("//h3[@class='product-brand']"));
	    int size=w.size();
		int count=0;
		for (WebElement coat : w) {
			if(coat.getText().contains("Duke"))
				count++;
		}
		if(size==count) {
			System.out.println("All coats are duke brand");}
		else {
			System.out.println("All coats are not duke brand");}
		
	WebElement dd=driver.findElement(By.xpath("//div[text()='Sort by : ']"));
	builder.moveToElement(dd).perform();
    driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
    driver.findElement(By.xpath("//img[@alt='Duke Men Green Puffer Jacket']")).click();
   
	Set<String> WindowHandles = driver.getWindowHandles();
	System.out.println(WindowHandles);
   List<String> list1=new ArrayList<String>(WindowHandles);
   String childwindow=list1.get(1);
   driver.switchTo().window(childwindow);
   WebElement weff= driver.findElement(By.xpath("//strong[text()='Rs. 1299']"));
  	String string=weff.getText();
  	System.out.println(string);
  	
	File srccc =weff.getScreenshotAs(OutputType.FILE);
    File ddes = new File("./images/button51.png");
	  FileUtils.copyFile(srccc, ddes);
	  driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
	  driver.close();
	  
	
	
	
	
	
	
	
	}}
