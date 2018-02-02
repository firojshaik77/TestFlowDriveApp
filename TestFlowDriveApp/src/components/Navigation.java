package components;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pagefactory.FlowSignUp;

/**
 * @author FirojShaik
 *
 */
public class Navigation {
	//Locate the Create Account Link and store in a final variable
	private static final By CREATE_ACCOUNT_LINK = By.id("com.thefloow.flo:id/text_view_create_account");
	private AppiumDriver<MobileElement> driver;
	
	/**
	 * @param driver
	 */
	public Navigation(AppiumDriver<MobileElement> driver) {
				      this.driver = driver;		
		   }
	

	/**
	 * @return FlowSignUp page
	 */
	public FlowSignUp navigateToCreateAccountPage() {
			//Click on Create Account Link
		      driver.findElement(CREATE_ACCOUNT_LINK).click();
		      return new FlowSignUp(driver);
		
		   }

}
