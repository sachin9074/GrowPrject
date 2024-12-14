import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonUtility {
WebDriver driver=null;
	
	
public 	Webdriver intisetup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webDriver.chrome.driver","D:\\testing data\\automation\new selinum files\\"
		+ "chromedriver-win64 new\\chromedriver-win64\\chromedriver.exe"    );
	     driver =new ChromeDriver();}
		
		else if(browser.equalsIgnoreCase("edge")) {
	     System.setProperty("WebDriver.edge.driver", "D:\\testing data\\automation\new selinum files\\"
	     + "chromedriver-win64 new\\chromedriver-win64\\edgedriver.exe");
	     driver= new EdgeDriver();
		}
		return driver; 
		}
public void launchURL(String url) {
driver.navigate().to(url);	
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));}
}




