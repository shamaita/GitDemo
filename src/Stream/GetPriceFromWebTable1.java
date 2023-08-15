package Stream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;



public class GetPriceFromWebTable1 {
	public static List<WebElement> names;
	
	public static void sorting(WebDriver driver) {
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
        //List<WebElement> names= driver.findElements(By.cssSelector("table[class='table table-bordered'] td:nth-child(1)"));
         names= driver.findElements(By.xpath("//tr/td[1]"));
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
	
	
	public static String setPrice(WebElement s) {
		//scan the name colm with getText --> Rice --> print price of Rice
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
	public static void printPrice(List<WebElement> names) {
		//scan the name colm with getText --> Rice --> print price of Rice
				List<String> price=names.stream().filter(s->s.getText().contains("Beans")).map(s->setPrice(s)).collect(Collectors.toList());
				price.stream().forEach(s->System.out.println(s));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

        
        driver.navigate().refresh();

        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        
        sorting(driver);
        printPrice(names);
		
	}

}
