package Stream;
import Stream.GetPriceFromWebTable1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Stream.Driver1;

public class NavigateNxtPage1 {
	public static WebDriver driver;
	public static List<WebElement> names;
	
	public static List<WebElement> getName(WebDriver driver){
		
		names= driver.findElements(By.xpath("//tr/td[1]"));
		return names;
	}
	
	public static String setPrice(WebElement s) {
		//scan the name colm with getText --> Rice --> print price of Rice
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
	public static void getDesiredPrice(WebDriver driver) {
		List<String> priceSize ;
		
		do {
			getName(driver);
			priceSize=getName(driver).stream().filter(s->s.getText().contains("Rice")).map(s->setPrice(s)).collect(Collectors.toList());
			if(priceSize.size()<1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
			else {
				priceSize.stream().forEach(s->System.out.println("The price of Rice is "+s));
				//System.out.println(priceSize);
				System.out.println(priceSize.get(0));
			}
		}
		while(priceSize.size()<1); 
			
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
        driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
        getDesiredPrice(driver);
        
        
	}

}
