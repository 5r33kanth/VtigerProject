package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class OrganizationPage {

	// Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgaanizationIcon;

	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;

	@FindBy(name = "employees")
	private WebElement employeesTextField;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement accountTypeDropDown;

	@FindBy(name = "phone")
	private WebElement phoneTextField;

	@FindBy(name = "email1")
	private WebElement emailTextField;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelButton;

	// Initialization

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Utilization
	public void clickCreateOrganizaton() {
		createOrgaanizationIcon.click();
	}

	public void enterOrganizationName(String text) {
		organizationNameTextField.sendKeys(text);
	}

	public void enterEmployees(String number) {
		employeesTextField.sendKeys(number);
	}

	public void selectIndustry(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(industryDropDown, text);

	}

	public void selectAccountType(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(accountTypeDropDown, text);

	}

	public void enterPhoneTextField(String number) {
		phoneTextField.sendKeys(number);
	}

	public void enterEmailTextField(String text) {
		emailTextField.sendKeys(text);
	}

	public void save() {
		saveButton.click();
	}

	public void cancel() {
		cancelButton.click();
	}

}
