package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author FirojShaik
 *
 */

public class FlowLoginError {

	AppiumDriver<MobileElement> driver;
	
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(xpath="//android.widget.ScrollView/android.widget.TextView")
	WebElement LoginError;//Locate LoginError
	
	
	@FindBy(id="android:id/button1")
	WebElement errorPageBtn;//Locate the button
	
	//Expected Error Messages
	String expectedMsg1="User name/password not found. Are you registered?";
	String expectedMsg2="Please enter an address in the correct format: abc@xyz.com";
	
	/**
	 * @param driver
	 */
	public FlowLoginError(AppiumDriver<MobileElement> driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
		/**
		 * @return String with Login Error message 
		 */
		public String getErrorMessage(){
		 return	LoginError.getText();//Get the Login Error message
		}
		
		
		/**
		 * Match the actual Error with expected Error
		 */
		public void verifyErrorMessage(){
			String actualError=getErrorMessage();//Verify the error messages
			Assert.assertTrue(actualError.equalsIgnoreCase(expectedMsg1) || actualError.equals(expectedMsg2));
			System.out.println("The actual Error for the test case is :\""+actualError+"\"");
		}
		
		
		public void clickBtn(){
			errorPageBtn.click();//click the button on the error page
			}
}
