package Stream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterOnWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

        driver.navigate().refresh();

        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String name="Rice";
        
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(name);
        List<WebElement> names=driver.findElements(By.xpath("//tr/td[1]"));
        //Checking how many element display
        List<WebElement> newNames=names.stream().filter(s->s.getText().contains(name)).collect(Collectors.toList());
        
        //compare
        Assert.assertEquals(names, newNames);
        
        
	}

}
