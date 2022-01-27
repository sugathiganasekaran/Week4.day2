package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortttable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		List<String> ll=new ArrayList<String>();
		for(WebElement ff:web) {
			String ss=ff.getText();
			ll.add(ss);
			System.out.println(ll);
		}
		
		driver.findElement(By.className("sorting_asc")).click();
		List<WebElement> webb = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		List<String> lll=new ArrayList<String>();
		for(WebElement fff:webb) {
			String sss=fff.getText();
			lll.add(sss);
			System.out.println(lll);
			Collections.sort(lll);
			
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
}}

