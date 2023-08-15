package JsExecutor;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scrolling {
	public static int sum=0;
	

	 public static int totalSum(WebDriver driver,int sum) {

	              List<WebElement> amount=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

	             

	              for(WebElement i:amount) {

	                     int num=Integer.parseInt(i.getText());

	                     sum+=num;

	              }

	              System.out.println("Sum of the ammount is : "+sum);

	             

	      

	              return sum;

	       }


	 public static int TotalAmount(WebDriver driver) {

	       int str=Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());

	       System.out.println("Expected value is :" +str);

	       return str;

	}

	      

	 

	 

	 

	 

	       public static void main(String[] args) {

	              // TODO Auto-generated method stub

	              System.setProperty("webdriver.chrome.driver", ".\\\\driver\\\\chromedriver.exe");

	              WebDriver driver= new ChromeDriver();

	              driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

	              driver.navigate().refresh();

	              //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

	              driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	              driver.manage().window().maximize();

	              driver.manage().deleteAllCookies();

	              WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

	              JavascriptExecutor jse = (JavascriptExecutor) driver;

	              jse.executeScript("window.scrollBy(0,500)");

	              String str="document.querySelector('.tableFixHead').scrollTop=5000";

	              jse.executeScript(str);

	             

	              int current=totalSum(driver,sum);

	              int expect=TotalAmount(driver);

	             

	              /* if(current==expect) {

	                     System.out.println("Actual value is Equal to Expected value ");

	              }

	              else {

	                     System.out.println("Not equal");

	              }

	              */

	              Assert.assertEquals(expect, current);
	              
	              //Git
	              System.out.println("Hi welcome to git");
	              
	              System.out.println("This is my senond line");

	      


	}

}
