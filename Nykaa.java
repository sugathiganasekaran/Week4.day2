package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.nykaa.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   Actions builder=new Actions(driver);
	   WebElement ele = driver.findElement(By.xpath("//a[text()='brands']"));
	   builder.moveToElement(ele).perform();
      driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]")).click();
      String title = driver.getTitle();
      System.out.println(title);
      driver.findElement(By.xpath("//div[@class='css-0']//button[1]")).click();
      driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
      driver.findElement(By.xpath("//div[@class='filter-action']//div")).click();
     driver.findElement(By.xpath("//div[@class=' css-15dbf9i']")).click();
     driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
     driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']")).click();
     driver.findElement(By.xpath("//div[@id='filters-strip']/div[1]/div[1]/div[6]/div[1]")).click();
     driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
     String text = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
     System.out.println(text);
     if(text.contains("Shampoo")) {
    	 System.out.println("Filter Applied");}
     else {
    	 System.out.println("Filter not Applied");}
     
     driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
     Set<String> WindowHandles = driver.getWindowHandles();
		System.out.println(WindowHandles);
		List<String> list=new ArrayList<String>(WindowHandles);
        String childwindow=list.get(1);
        driver.switchTo().window(childwindow);
        
        WebElement selectSIZE = driver.findElement(By.className("css-1c1c89s"));
        selectSIZE.click();
        Select ss=new Select(selectSIZE);
        ss.selectByIndex(2); 
        
        String ddd  = driver.findElement(By.xpath("//span[text()='₹150']")).getText();
        System.out.println(ddd);
        
        driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='1']")).click();
        
        driver.switchTo().frame(0);
        String grandTotal =driver.findElement(By.xpath("(//div[text()='220'])[2]")).getText();
       System.out.println("Grand Total: " +grandTotal);
        driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
       driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
       driver.switchTo().defaultContent();
       String text1 = driver.findElement(By.xpath("//span[text()='220']")).getText();
       System.out.println(text1);
        if(grandTotal.equals(text1)) {
        	System.out.println("same");}
        else {
        	System.out.println("not same");}
        
    	driver.quit();
    	
	
	
	
     
	}}

