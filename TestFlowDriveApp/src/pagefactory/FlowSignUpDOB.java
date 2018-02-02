package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author FirojShaik
 *
 */
public class FlowSignUpDOB {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(id="android:id/numberpicker_input")
	List<WebElement> dateOfBirth;
	@FindBy(id="android:id/button1")
	WebElement btnOK;
	AppiumDriver<MobileElement> driver;	
				
		/**
		 * @param driver
		 */
		public FlowSignUpDOB(AppiumDriver<MobileElement> driver){
			this.driver = driver;
			//This initElements method will create  all WebElements
			PageFactory.initElements(driver, this);
			
		}
		
	
		
		/**
		 * This method fills in month of birth,day of birth and year of birth values on Signup page.
		 * @param monthOfBirth
		 * @param dayOfBirth
		 * @param yearOfBirth
		 */
		public void enterDOB(String monthOfBirth,String dayOfBirth,String yearOfBirth)
		{ 
		this.dateOfBirth.get(0).clear();
		this.dateOfBirth.get(0).sendKeys(monthOfBirth);
		this.dateOfBirth.get(1).clear();
		this.dateOfBirth.get(1).sendKeys(dayOfBirth); 
		this.dateOfBirth.get(2).clear();
		this.dateOfBirth.get(2).sendKeys(yearOfBirth);
		this.btnOK.click();
		}
		
				
		
		
		
	}
