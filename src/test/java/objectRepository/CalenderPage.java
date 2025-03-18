package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;
import utilities.WebDriverUtilities;

public class CalenderPage {
	
	GenericUtilities gu;
	WebDriverUtilities wu;
	
	//Declaration
	@FindBy(xpath = "//*[@id=\"mnuTab\"]/form/table/tbody/tr[2]/td[1]/table/tbody/tr/td")
	private WebElement AddCalender;
	
	@FindBy(linkText = "Call")
	private WebElement callRemainder;
	
	@FindBy(name = "subject")
	private WebElement eventName;
	
	@FindBy(name = "location")
	private WebElement location;
	
	@FindBy(name = "eventstatus")
	private WebElement eventStatusDropDown;
	
	@FindBy(name = "taskpriority")
	private WebElement priorityDropDown;
	
	
	
	//Initialization
	public CalenderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void addToCalendar(WebDriver driver) {
		gu = new GenericUtilities();
		wu = new WebDriverUtilities();
		gu.mouseHoverOn(driver, AddCalender);
		
		callRemainder.click();	
	}
	
	public void enterEventName(String text) {
		eventName.sendKeys(text);
		
	}
	
	public void enterLocation(String text) {
		location.sendKeys(text);
		
	}
	
	public void selectEventStatusDropDown(String text) {
		
		gu.selectOptionByVisibleText(eventStatusDropDown, text);
		
	}
	
	public void selectPriorityDropDown(String text) {
		
		gu.selectOptionByVisibleText(priorityDropDown, text);
		
	}
	
	
	
	

}
