package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;

	@FindBy(xpath="//div [@style ='margin-left: -2px;']//div[@class='valign-wrapper pos-rel']//img[@alt='Groww Logo'] ")
	private WebElement logo; 

	@FindBy(xpath="//input[@id='globalSearch23']")
	private  WebElement Searchbar;

	@FindBy(xpath="'//span[text()='Adani Green Energy']")
	private WebElement Searchicon;

	@FindBy (xpath="//div[@id='suggestionsadani-green-energy-ltd']//*[@class='contentPrimary absolute-center']")
	private WebElement pageOption;

	public HomePageObject(WebDriver driver){
	this.driver =driver;
	PageFactory.initElements(driver, this);	}

	public boolean isLogoPresent() {
	boolean logoflag=logo.isDisplayed()	;
	return logoflag;}


	public boolean SearchbarPresent() {
	boolean searchbarflag=Searchbar.isEnabled();
	return searchbarflag;}

	public void SetSearchbarFiled(String input) {
	Searchbar.sendKeys(input);}

	public void OptionChain() {
	pageOption.click();}


}
