/* Mobile Automation Exercise
 * Question 1
 * Developed by Mohammad Nazmul Haq
 */

package mobile.Excercise.One;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class MyAndroidTest {
	public	static String baseurl;
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
		
		//Instantiating android driver
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		baseurl="https://finance.yahoo.com";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Navigated to Yahoo Finance mobile web application");
				
		WebElement web = driver.findElement(By.xpath("//input[@name='p']"));
		web.click();
		web.sendKeys("AA");
		System.out.println("Stock Code AA is entered for a company name ALCOA CORPORATION exchanged on the NYSE");
		web.sendKeys(Keys.ENTER);
		
		WebElement text=driver.findElement(By.xpath("//*[@id='hero']/section/p[1]/span[1]"));
		String currentPrice=text.getText();
		System.out.println("Current price of AA is: "+currentPrice);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		//driver.findElement(By.xpath("//button[@class='_209rh']")).click();
		driver.findElement(By.xpath("//*[@id='hero']/section/div/ul/li[5]/button")).click();
		
		driver.quit();
	}

}
