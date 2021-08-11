package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Enter Time-Track")
	private WebElement EnterTimeTrackLink;

	@FindBy(linkText = "View Time-Track")
	private WebElement viewTimeTrackLink;
	
	@FindBy(linkText = "Lock Time-Track")
	private WebElement LockTimeTrackLink;
	
	@FindBy(linkText = "Approve Time-Track")
	private WebElement ApproveTimeTrackLink;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterTimeTrackLink() {
		return EnterTimeTrackLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getViewTimeTrackLink() {
		return viewTimeTrackLink;
	}

	public WebElement getLockTimeTrackLink() {
		return LockTimeTrackLink;
	}

	public WebElement getApproveTimeTrackLink() {
		return ApproveTimeTrackLink;
	}

}
