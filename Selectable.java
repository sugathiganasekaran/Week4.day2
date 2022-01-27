package week4.day2;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
	   driver.manage().window().maximize();
	 
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame(0);
     WebElement item2 = driver.findElement(By.xpath("//li[text()='Item2']"));
     WebElement item4 = driver.findElement(By.xpath("//li[text()='Item4']"));
     WebElement item6 = driver.findElement(By.xpath("//li[text()='Item6']"));	
     WebElement item7 = driver.findElement(By.xpath("//li[text()='Item7']"));		
	Actions builder=new Actions(driver);
	builder.keyDown(Keys.CONTROL).click(item2)
	.click(item4).click(item6).click(item7).keyUp(Keys.CONTROL).perform();
	driver.switchTo().defaultContent();
	
	
	
	
	
	
	}
}
