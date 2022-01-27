package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   WebElement tra=driver.findElement(By.id("txtStationFrom"));
	   tra.clear();
	   tra.sendKeys("MS",Keys.ENTER);
	   Thread.sleep(500);
	  tra.sendKeys(Keys.TAB);
	   WebElement train= driver.findElement(By.id("txtStationTo"));
	   train.clear();
	   train.sendKeys("MS",Keys.ENTER);
	   Thread.sleep(500);
	   driver.findElement(By.id("chkSelectDateOnly")).click();
	   List<WebElement> nName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		List<String> list = new ArrayList<String>();
	for(WebElement tt:nName) {
		String st=tt.getText();
		list.add(st);
		System.out.println(st);
		Collections.sort(list);
		System.out.println(list);
	}
	
	int size=nName.size();
	System.out.println("No of trains:" +size);
	
	
	
	
	}
	
}


