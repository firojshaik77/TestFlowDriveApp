package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author FirojShaik
 *
 */
public class FlowSignUpError {

	AppiumDriver<MobileElement> driver;
	
	String[] expectedMsg = new String[]{"Password: 8 characters needed.",
			"Password: 1 number needed.","Password: Confirmation does not match.",
			"You must be over 17 years of age.",
			"Enter a valid e-mail address.","Registration successful, please login."};

	
	/**
	 * @param driver
	 */
	public FlowSignUpError(AppiumDriver<MobileElement> driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
		/**
		 * Get the Message displayed on the screen
		 * @return String
		 */
		public String getMessage() {
			String actualMsg= new String();
				try{	
					
					actualMsg=driver.findElement(By.id("android:id/message")).getText();
					
				}
			catch(NoSuchElementException e){
				
				actualMsg=driver.findElement(By.id("com.thefloow.flo:id/text_view_promo_blurb_1")).getText();
				}
				
		    return actualMsg;
		}
		
		
		/**
		 * This method is used to match the Actual Message with Expected Message
		 */
		public void verifyMessage(){
			String actualMessage=getMessage();
			Assert.assertTrue(actualMessage.equalsIgnoreCase(expectedMsg[0]) || actualMessage.equals(expectedMsg[1])
			|| actualMessage.equals(expectedMsg[2])|| actualMessage.equals(expectedMsg[3]) 
			|| actualMessage.equals(expectedMsg[4]) || actualMessage.equals(expectedMsg[5]) );  
			
		System.out.println("Message displayed in testing Signup Page:\""+actualMessage+"\"");
		
				 
		}
		
		/**
		 * This method clicks the button on error or success screen.
		 */
		public void clickBtn(){
			try{
			   //Click button on the Error page displayed
				driver.findElement(By.id("android:id/button1")).click();
				
			}
			catch(NoSuchElementException exception){
				//Click button on the successful account page
				driver.findElement(By.id("com.thefloow.flo:id/button_success_dismiss")).click();
			}
			}
}
