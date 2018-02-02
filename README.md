# TestFlowDriveApp
TestFlowDriveApp with Appium
Below are the steps to run the  ‘TestFlowDriveApp’  project. 
Step1: Install Appium v1.7.2 server
Step2: Launch Eclipse .(I have used Mars.2 for executing the tests)
Step3:Import the ‘TestFlowDriveApp’  project
Step4:Configure Eclipse with Selenium WebDriver Jars(selenium-java-3.8.1) .Import the below jar files by clicking on Add External JARs.
client-combined-3.8.1.jar
client-combined-3.8.1-sources.jar
 byte-buddy-1.7.5.jar
commons-codec-1.10.jar
commons-exec-1.3.jar
commons-logging-1.2.jar
gson-2.8.2.jar
guava-23.0.jar
httpclient-4.5.3.jar
httpcore-4.4.6.jar
Step5: Configure Eclipse with Selenium Android Driver Jar.
Selenium-android-driver.jar
Step6: Configure Eclipse with Appium Java Client Jar
java-client-6.0.0-BETA2.jar
Step7:Configure Eclipse with JUnit Jar
junit-4.12.jar
Step8:List of other JAR files hamcrest-core, commons-lang and JXL
hamcrest-core-1.3.jar
commons-lang3-3.7.jar
jxl-2.6.12

Step9: Configure Eclipse with TestNG Plugin.
Step10: Ensure that the Flow Drive app is available on the mobile device.
Step11: Connect your mobile device to your computer using USB cable. 
Step12: Get the Device Name, Platform Name and Platform Version of the connected device.
Step13: Now open command prompt and run this command: adb devices. This will give the information about the device id.
Step14: Open the test.FlowLoginWithPageFactory.java file under TestFlowDriveApp Project in Eclipse. 
Step15: Replace the deviceName(in line number 66),device id (in line number 67), platform Name(in line number 68), platform version (in line number 69) given in the code with the connected device information.
Step16: Start the appium server on Host 0.0.0.0 and port 4723.
Step17: From Eclipse, select the testsuite testflowdriveapp.xml and click on Run As TestNG Suite.
