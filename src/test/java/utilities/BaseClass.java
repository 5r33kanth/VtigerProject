package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

@Listeners(ListnerClass.class)
public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public WebDriverUtilities wu;
	public LoginPage lp;
	public HomePage hp; 
	public ContactsPage cp;
	public OrganizationPage op;
	public LeadsPage ld;
	
	
	@Parameters("browser") //removed 
	@BeforeMethod(alwaysRun = true)
	public void login(String browser) { //removed string browser
		
		wu = new WebDriverUtilities();
		
		driver = wu.launchBrowser(browser); //removed browser
		sdriver = driver;
		
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		cp = new ContactsPage(driver);
		op = new OrganizationPage(driver);
		ld = new LeadsPage(driver);
//		cl = new CalenderPage(driver);
		
		
		wu.maximizeBrowser(driver);
		wu.implicitwait(driver, 20);
		wu.pageLoadingWait(driver, 50);
		
		wu.passUrl(driver);
		
				
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		
		
		hp.signOut(driver);
		wu.closeBrowser(driver);
	}
	
	

}
