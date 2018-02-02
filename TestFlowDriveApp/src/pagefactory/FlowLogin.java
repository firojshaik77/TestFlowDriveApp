package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import components.Navigation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author FirojShaik
 *
 */

public class FlowLogin {

		
		AppiumDriver<MobileElement> driver;
		
		/**
		 * All WebElements are identified by @FindBy annotation
		 */
		@FindBy(id="com.thefloow.flo:id/edit_text_email")
		WebElement loginEmail; //Locate Email address field
		
		//Locate Password field
		@FindBy(id="com.thefloow.flo:id/edit_text_password")
		WebElement loginPassword;
		
		//Locate Login button
		@FindBy(id="com.thefloow.flo:id/btn_login")
		WebElement login;
		
		public final Navigation navigation;

		/**
		 * @param driver
		 */
		public FlowLogin(AppiumDriver<MobileElement> driver){
			this.driver = driver;
			this.navigation= new Navigation(driver);
			//This initElements method will create  all WebElements
			PageFactory.initElements(driver, this);
		}
		
		
		/**
		 * @return boolean
		 */
		public boolean validateLoginpage(){
	        boolean elements = false;
	      //Validate if Login Page is displayed
	        if(loginEmail.isDisplayed()){
	        	if(loginPassword.isDisplayed()){
	        	elements = true;
	        	}
	        }
	        else{
	            elements = false;
	        }
	        return elements;


	    }
		
		/**
		 * @param strUserEmail
		 */
		public void setUserName(String strUserEmail){
			loginEmail.clear();
			loginEmail.sendKeys(strUserEmail);//Set user email in textbox
			
		}
		
		
		/**
		 * @param strPassword
		 */
		public void setPassword(String strPassword){
		loginPassword.clear();
		loginPassword.sendKeys(strPassword);//Set password in password textbox
		}
		
		public void clickLogin(){
				login.click();//Click on login button
		}
		
		
		/**
		 * This POM method will be exposed in test case to login in the application
		 * @param strUserEmail
		 * @param strPasword
		 **/
		public void loginToFlow(String strUserEmail,String strPasword){
			this.setUserName(strUserEmail);//Fill Email address
			this.setPassword(strPasword);//Fill password
			this.clickLogin();//Click Login button
					
		}
		
		
		/**
		 * @return navigation
		 */
		public Navigation navigation() {
			//Required to invoke methods in Navigation from the Login page
			      return navigation;			
			   }

	}
