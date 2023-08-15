package Stream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class PerformWebTableSorting {
	
	public static void sorting(WebDriver driver) {
		//Click on the colm
		//Capture all the webElements in a list
		//get text of all WebElements into new list-->Original List
		//sort in the list of step 3 -->Sorted list
		//Compare Original list vs Sorted Lists
		
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		//xpath traverse
		//(//table[@class='table table-bordered'])//td[1]
		//CSS traverse
		
		
		List<WebElement> names= driver.findElements(By.cssSelector("table[class='table table-bordered'] td:nth-child(1)"));
		
		List<String> originalNames=names.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList=originalNames.stream().sorted().collect(Collectors.toList());
		if(sortedList.equals(originalNames)) {
			System.out.println("Successfully Sorted");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		}
		
		
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", ".\\\\drivers\\\\chromedriver.exe");

       //WebDriver driver= new ChromeDriver();
		WebDriver driver= new EdgeDriver();

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

        driver.navigate().refresh();

        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        sorting(driver);

	}

}
