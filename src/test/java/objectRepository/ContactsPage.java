package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class ContactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	
	@FindBy(name = "salutationtype")
	private WebElement salutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "leadsource")
	private WebElement leadsrcDropDown;
	
	@FindBy(id = "title")
	private WebElement titleTextField;
		
	@FindBy(id = "department")
	private WebElement departmentTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(id = "mobile")
	private WebElement mobileTextField;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelButton;
	
	//Initialization
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization
	public void clickCreateContactIcon() {
		createContactIcon.click();
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
	
	
	public void selectLeadSrc(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(leadsrcDropDown, text);

	}
	
	public void enterTitle(String text) {
		titleTextField.sendKeys(text);
	}
	
	public void enterDepartmentTextField(String text) {
		departmentTextField.sendKeys(text);
	}
	
	public void enterEmailTextField(String text) {
		emailTextField.sendKeys(text);
	}
	
	public void enterMobileTextField(String number) {
		mobileTextField.sendKeys(number);
	}
	
	public void save() {
		saveButton.click();
	}
	
	public void cancel() {
		cancelButton.click();
	}
	

}
