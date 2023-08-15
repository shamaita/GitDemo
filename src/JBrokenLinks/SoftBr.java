package JBrokenLinks;
import java.util.List;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SoftBr {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\\\driver\\\\chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

        driver.navigate().refresh();

        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links=driver.findElements(By.cssSelector(".gf-li a"));

        SoftAssert a=new SoftAssert();

        for(WebElement link:links) {

               String url=link.getAttribute("href");

               String name=link.getText();

               //(HttpURLConnection) conn=(HttpURLConnection) new URL(url).openConnection();

               HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();

               conn.setRequestMethod("HEAD");

               conn.connect();

               int code=conn.getResponseCode();
               a.assertTrue(code<400,"This Link is broken "+"The name is "+name+" "+url);

//            if(code>400) {

//                   System.out.println(name+"is a bad request because status codse is "+code);

//                   Assert.assertTrue(false);

//

//}

              

        }

 a.assertAll();
	}

}
