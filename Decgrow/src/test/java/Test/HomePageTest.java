package Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.HomePageObject;
import PageObject.SearchedProdcutsPageObject;



public class HomePageTest {
	WebDriver driver;
	HomePageObject hpo;
	SearchedProdcutsPageObject spo;

	@BeforeTest
	@Parameters("browser")
	void intisetup(String browser) {
	if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webDriver.chrome.driver","D:\\testing data\\automation\new selinum files\\"
	+ "chromedriver-win64 new\\chromedriver-win64\\chromedriver.exe"    );
     driver =new ChromeDriver();}
	
	else if(browser.equalsIgnoreCase("edge")) {
     System.setProperty("WebDriver.edge.driver", "D:\\testing data\\automation\new selinum files\\"
     + "chromedriver-win64 new\\chromedriver-win64\\edgedriver.exe");
     driver= new EdgeDriver();}
	}

	@BeforeClass
	@Parameters("url")
	void launchURL(String url) {
	driver.navigate().to(url);	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));}

	@Test(priority=1)
	void UrlTest() {
	String ActualUrl=driver.getCurrentUrl()	;
	Assert.assertEquals(ActualUrl,"https://groww.in/","url test is successful");}

	@Test(priority=2)
	void logoTest() {
	hpo =new HomePageObject(driver);
	hpo.SetSearchbarFiled("Adani Green Energy"+Keys.ENTER);
	boolean actuallogo=	hpo.isLogoPresent();
	Assert.assertEquals(actuallogo,true, "Logo Test is Successful");}


	@Test(priority=3)
	void  PageHeaderTest() {
		String parentwin=driver.getWindowHandle();
		System.out.println("Parent Window address =" +parentwin);

		Set<String> allwin=driver.getWindowHandles();
		System.out.println("all window hadles= "+allwin);
	    for(String childwin : allwin ) {
		if(! childwin .equalsIgnoreCase(parentwin)) {
		driver.switchTo().window(childwin)	;	
		
	spo = new SearchedProdcutsPageObject(driver);
	spo.Validateheadertext("Adani Green Energy");}}}

	@Test(priority=5)
	void loginoptionbutton() {
		
		String parentwin=driver.getWindowHandle();
		System.out.println("Parent Window address =" +parentwin);

		Set<String> allwin=driver.getWindowHandles();
		System.out.println("all window hadles= "+allwin);
	    for(String childwin : allwin ) {
		if(! childwin .equalsIgnoreCase(parentwin)) {
		driver.switchTo().window(childwin)	;	
		
	spo.loginoptionclick();}}}

	@Test(priority=4)
	void chaintest() {
	hpo.OptionChain();
	}

	@AfterClass

	void ClaoseBrowser() throws InterruptedException {
		Thread.sleep(2000);
	driver.quit();
}}
