package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author FirojShaik
 *
 */

public class FlowSignUp {
	
		

		/**
		 * All WebElements are identified by @FindBy annotation
		 */
		FlowSignUpDOB objDOBSignUpPage;
		@FindBy(id="com.thefloow.flo:id/edit_text_first_name")
		WebElement firstName;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_surname")
		WebElement surName;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_date_of_birth")
		WebElement dateOfBirth;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_email")
		WebElement textEmail;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_postcode")
		WebElement postCode;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_company_name")
		WebElement companyName;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_password")
		WebElement password;
		
		@FindBy(id="com.thefloow.flo:id/edit_text_confirm_password")
		WebElement confirmPassword;
		
		@FindBy(id="com.thefloow.flo:id/button_register")
		WebElement register;
		
		AppiumDriver<MobileElement> driver;
		
		/**
		 * @param driver
		 */
		public FlowSignUp(AppiumDriver<MobileElement> driver){
			this.driver = driver;
			//This initElements method will create  all WebElements
			PageFactory.initElements(driver, this);
		}
		
		/**
		 * This method fills in User FirstName and SurName values on Signup page.
		 * @param strUserEmail
		 * @param strPasword
		 **/		
		public void enterName(String firstName, String surName)
		{ this.firstName.clear(); this.firstName.sendKeys(firstName); this.surName.clear(); this.surName.sendKeys(surName); } 
		
		/**
		 * This method clicks DateOfBirth field on Signup Page.
		 */
		public void clickDateOfBirth()
		{ 
			this.dateOfBirth.click();
		} 
		
		
		/**
		 * This method fills in EmailAddress field value on Signup page.
		 * @param email
		 */
		public void enterEmail(String email){ 
			this.textEmail.clear(); this.textEmail.sendKeys(email);  }
		
		
		/**
		 * This method fills in PostCode field value on Signup page.
		 * @param postCode
		 */
		public void enterPostCode(String postCode){ 
			this.postCode.clear();this.postCode.sendKeys(postCode);  }
		
		
		/**
		 * This method fills in Company field value on Signup page.
		 * @param company
		 */
		public void enterCompany(String company){ 
			this.companyName.clear();this.companyName.sendKeys(company);  }
		
		
		/**
		 * This method fills in Password field value on Signup page.
		 * @param password
		 * @param confirmPassword
		 */
		public void enterPassword(String password, String confirmPassword)
		{ this.password.clear(); this.password.sendKeys(password); this.confirmPassword.clear(); this.confirmPassword.sendKeys(confirmPassword); } 
		
		
		/**
		 * This method clicks Register button on Signup page
		 */
		public void clickRegister(){
				register.click();//Click on Register button
		}
		
		
		
		/**
		 * This POM method will be exposed in test case to signup in the application
		 */
		public void signUpToFlow(String strFirstName,String strSurName,
				String strEmail,String strPostCode,String strCompany,String strPassword,String strConfirmPassword){
			//Fill First Name and Surname
			this.enterName(strFirstName,strSurName);
			//Fill email address
			this.enterEmail(strEmail);
			//Fill postCode
			this.enterPostCode(strPostCode);
			//Fill Company
			this.enterCompany(strCompany);
			//Fill Password
			this.enterPassword(strPassword, strConfirmPassword);
			//Fill Date of Birth
			this.clickDateOfBirth();
					
		}
	}
