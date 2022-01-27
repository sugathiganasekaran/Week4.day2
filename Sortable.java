package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Actions builder=new Actions(driver);
        driver.switchTo().frame(0);
        WebElement it2=driver.findElement(By.xpath("//li[text()='Item 2']"));
        WebElement it1=driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement it5=driver.findElement(By.xpath("//li[text()='Item 5']"));
        WebElement it6=driver.findElement(By.xpath("//li[text()='Item 6']"));
	builder.dragAndDrop(it2, it1).dragAndDrop(it6,it5).perform();
	driver.switchTo().defaultContent();
	
	
	
	
	
	
	}}
