package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class SearchedProdcutsPageObject {
	WebDriver driver;
	
	@FindBy (xpath="//h1[text()='Adani Green Energy']")
	private WebElement pageHeader;

	@FindBy(xpath="//div[text()='LOGIN']")
	private WebElement loginbuttn;

	public SearchedProdcutsPageObject  (WebDriver driver) {
	this.driver= driver;	
	PageFactory.initElements(driver, this);}

	public  void  Validateheadertext(String expectedheader){
	String actualheader= pageHeader.getText();
    Assert.assertEquals(actualheader, expectedheader, "successfully navigated to header page");}



	public void loginoptionclick() {
		loginbuttn.click();	}
}
