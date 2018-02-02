package pagefactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author FirojShaik
 *
 */

public class FlowTerms {
		
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(id="com.thefloow.flo:id/btn_agree")
	WebElement btnAgree;
	AppiumDriver<MobileElement> driver;
	
	/**
	 * @param driver
	 */
	public FlowTerms(AppiumDriver<MobileElement> driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	
			/**
			 * This method validates the Terms and Conditions Page.
			 * @return boolean
			 */
			public boolean validateTermspage(){
		        
		        try {
		            return btnAgree.isDisplayed();
		          }
		     catch (NoSuchElementException ignored) {
		            return false;
		          }		        
		    }
			
			
			/**
			 * This method clicks on I Agree button
			 */
			public void AgreeTerms(){
				
				//Click Login button
				btnAgree.click();//Click on Agree button
						
			}
}
