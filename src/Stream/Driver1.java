package Stream;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver1 {
	public static WebDriver driver;
	public static String str="https://rahulshettyacademy.com/seleniumPractise/#/offers";
	public  static WebDriver getDriver(WebDriver driver, String str) {
		driver= new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

        
        driver.navigate().refresh();

        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get(str);

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
		return driver;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDriver(driver,str);
	}

}
