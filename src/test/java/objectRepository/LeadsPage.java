package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class LeadsPage {
	
	//Declaration
	
	@FindBy(xpath = "/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a")
	private WebElement createLeadIcon;
	
	@FindBy(name = "salutationtype")
	private WebElement salutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "company")
	private WebElement companyTextField;
	
	@FindBy(id = "designation")
	private WebElement titleTextField;
	
	@FindBy(name = "leadsource")
	private WebElement leadsrcDropDown;
		
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(id = "mobile")
	private WebElement mobileTextField;
	
	@FindBy(name = "leadstatus")
	private WebElement leadStatus;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelButton;
	
	
	//Initialization
	
		public LeadsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		//Utilization
		public void clickCreateLeadIcon() {
			createLeadIcon.click();
		}
		
		public void selectSalutation(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionByVisibleText(salutationDropDown, text);

		}
		public void enterFirstName(String text) {
			firstNameTextField.sendKeys(text);
		}
		
		public void enterLastName(String text) {
			lastNameTextField.sendKeys(text);
		}
		
		public void enterCOmpany(String text) {
			companyTextField.sendKeys(text);
		}
		
		public void enterDesignationTitle(String text) {
			titleTextField.sendKeys(text);
		}
		
				
		public void selectLeadSrc(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionByVisibleText(leadsrcDropDown, text);

		}
		
		public void industry(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionByVisibleText(industryDropDown, text);
			
		}
		
		
		public void enterMobileTextField(String number) {
			mobileTextField.sendKeys(number);
		}	
	
		
		public void enterEmailTextField(String text) {
			emailTextField.sendKeys(text);
		}
		
		public void leadStatus(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionByVisibleText(leadStatus, text);
			
		}
		
		public void save() {
			saveButton.click();
		}
		
		public void cancel() {
			cancelButton.click();
		}
		

	

}
