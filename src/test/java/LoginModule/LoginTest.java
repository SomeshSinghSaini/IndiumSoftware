package LoginModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.BaseClass;
import pom.HomePage;
import pom.LoginPage;
import utils.ConfigProperty;
import utils.ExcelData;
import utils.Screenshot;

@Listeners(Screenshot.class)
public class LoginTest extends BaseClass {
	
	@Test(dataProvider = "LoginCredentials")
	public void login(String username, String password) throws IOException {
		String url = ConfigProperty.getPropertyValue("url");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextbox().sendKeys(username);
		lp.getPasswordTextbox().sendKeys(password);
		lp.getLoginButton().click();
		HomePage hp = new HomePage(driver);
		try {
			hp.getViewTimeTrackLink().click();
			hp.getLockTimeTrackLink().click();
			hp.getApproveTimeTrackLink().click();			
			hp.getEnterTimeTrackLink().click();
			hp.getLogoutLink().click();	
		}catch(NoSuchElementException e){
			Assert.fail("invalid credentials");
		}
	}
	
	@DataProvider(name = "LoginCredentials")
	Object[][] getData() throws EncryptedDocumentException, IOException{
		return ExcelData.getExcelValue("login");
	}
}
