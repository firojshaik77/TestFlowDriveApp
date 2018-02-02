package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pagefactory.FlowLogin;
import pagefactory.FlowLoginError;
import pagefactory.FlowSignUp;
import pagefactory.FlowSignUpDOB;
import pagefactory.FlowSignUpError;
import pagefactory.FlowTerms;

/*
* @author FirojShaik
* The below Test Case runs against Appium instance deployed on local machine.
*/

public class FlowLoginWithPageFactory {

	AppiumDriver<MobileElement> driver;
	FlowLogin objLoginPage;
	FlowLoginError objLoginErrorPage;
	FlowTerms objTermsPage;
	FlowSignUp objSignUpPage;
	FlowSignUpDOB objSignUpDOBPage;
	FlowSignUpError objSignUpErrorPage;
	DesiredCapabilities caps;
	File appDir = new File(System.getProperty("user.dir"));
	String testDataPath = appDir.toString().concat("/testdata/testData.xls");
		
	/**
	 * This method is to set up appium with application.
	 * @BeforeSuite is part of Test Suite level annotations and
	 * is used to specify setup actions before the test suite begins 
	 * 
	 */
	
	@BeforeSuite
	public void setup(){
		
		/**
		 * * *File app = new File(appDir, "8b3d8e298a.apk");**
		 * This line of code is needed when the apk file has to installed on the testing device during the setup.
		 * Uncomment the below line and place the apk file in user directory if apk installation is needed on the test device.
		 */
		
		//File app = new File(appDir, "8b3d8e298a.apk");
		
		/**
		 * Set the Desired Capabilities.
		 * Refer Read me file and update the device information.
		 */
        caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy Tab A"); //Device Name of the mobile phone
		caps.setCapability("udid", "4ce2b326");  //Device ID of the mobile phone
		caps.setCapability("platformName", "Android"); //Platform Name of the testing device
		caps.setCapability("platformVersion", "6.0");//Platform version of the testing device
		/**
		 * If the apk installation is also needed, uncomment the below line to pick the 
		 * apk file and do the installation
		 */
		//caps.setCapability("app", app.getAbsolutePath());
		
		caps.setCapability("appPackage", "com.thefloow.flo");
		caps.setCapability("appActivity", "com.thefloow.flo.activity.LauncherActivity");
		caps.setCapability("noReset", "true");
		//Instantiate Appium Driver
		try{
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objLoginPage = new FlowLogin(driver);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
			
		}
		
	/**
	 * Test for Terms and Conditions page
	 */
	@Test(priority=0)
	public void agreeTermPage()
	{
		objTermsPage = new FlowTerms(driver);	
		if(objTermsPage.validateTermspage() == true){
			objTermsPage.AgreeTerms();
            System.out.println("Clicked on I Agree button found on Terms and Conditions page");
        }
        else{
            System.out.println("Terms and Conditions page not found");
        }
		
	}
	
	/**
	 * Test to automate the verification of error messages on login
	 * @param emailAddr
	 * @param password
	 */
	@Test(priority=1,dataProvider="userLogin",groups="FlowLogin")
	public void testLoginPage(String emailAddr,String password){		
	//Create Login Page object
	if(objLoginPage.validateLoginpage() == true){
	objLoginPage.loginToFlow(emailAddr, password);
	 System.out.println("Submitted Login Page with email address:\""+emailAddr+"\" and password:\""+password+"\"");
	// Create Error page object
	objLoginErrorPage = new FlowLoginError(driver);
	//Verify Error message
	objLoginErrorPage.verifyErrorMessage();
	objLoginErrorPage.clickBtn();
	
    }
    else{
        System.out.println("Login page not found");
	}

	}
	
	
	/**
	 * Navigate to Signup page from the Login Page
	 */
	@AfterGroups("FlowLogin")
	public void navigateToSignUpPage()
	{
		objSignUpPage = objLoginPage.navigation.navigateToCreateAccountPage();
		
	}
	
	
	/**
	 * Test to automate the Account Creation and validation
	 * @param firstName
	 * @param surName
	 * @param monthOfBirth
	 * @param dayOfBirth
	 * @param yearOfBirth
	 * @param email
	 * @param postCode
	 * @param company
	 * @param password
	 * @param confirmPassword
	 */
	@Test(priority=2,dataProvider="userSignUp",groups="FlowSignUp")
	public void testSignUpPage(String firstName,String surName,String monthOfBirth,
			String dayOfBirth,String yearOfBirth,
			String email,String postCode,String company,String password,String confirmPassword){
		
			
		objSignUpPage.signUpToFlow(firstName, surName,email,postCode,company,password,confirmPassword);
		objSignUpDOBPage = new FlowSignUpDOB(driver);
		objSignUpDOBPage.enterDOB(monthOfBirth,dayOfBirth,yearOfBirth);
		objSignUpPage.clickRegister();
		objSignUpErrorPage = new FlowSignUpError(driver);
		//Verify the Messages displayed 
		objSignUpErrorPage.verifyMessage();
		objSignUpErrorPage.clickBtn();
		
				
	}
	
	
	/**
	 * Method to get Test data for Login page
	 * @return arrayObject with Login email address and password.
	 */
	@DataProvider(name="userLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = ExcelHelper.getExcelData(testDataPath,"LoginData");
		return arrayObject;
	}

	/**
	 * @return arrayObject with test data for user Account creation
	 */
	@DataProvider(name="userSignUp")
	public Object[][] signUpData() {
		Object[][] arrayObject = ExcelHelper.getExcelData(testDataPath,"SignUpData");
		return arrayObject;
	}
	
    /**
     * @AfterSuite –  is used to specify tear down actions after the test suite ends
     */
    @AfterSuite
    public void afterSuite(){
       driver.quit();  //quit the driver
    }

	
}
