package test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFlow {
	
	public static void main(String[] args) {
		
		//https://www.guru99.com/first-webdriver-script.html
		
		System.setProperty("webdriver.chrome.driver","/Users/Sachit/Desktop/selenium/chrome/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//String baseUrl = "http://demo.guru99.com/test/newtours/";
		String baseUrl = "http://demo.guru99.com/";
		String expectedSiteName = "Demo Site";
		
        //String expectedTitle = "Welcome: Mercury Tours";
        //String actualTitle = "";
        
       // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        //actualTitle = driver.getTitle();

        String siteName = driver.findElement(By.id("site-name")).findElement(By.tagName("a")).getText();
       // System.out.println("siteName is "+siteName);
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (siteName.contentEquals(expectedSiteName)){
            System.out.println("Test Passed for site name");
        } else {
            System.out.println("Test Failed for site name");
        }
        
        //validate email address and submit fields
         boolean isEmailFieldDisplayed = driver.findElement(By.name("emailid")).isDisplayed();
         assertMessage(isEmailFieldDisplayed, "Email");
       
         boolean isSubmitButtonDisplayed = driver.findElement(By.name("btnLogin")).isDisplayed();
         assertMessage(isSubmitButtonDisplayed, "Submit");
         
         //Enter Email address
         driver.findElement(By.name("emailid")).sendKeys("testSelenium@mail.com");
         
         String populatedValueOfEmail = driver.findElement(By.name("emailid")).getText();
         
         //Click Submit
         driver.findElement(By.name("btnLogin")).click();
         
         //Validate the next page with accpage fields as User ID : and Password :
         List<WebElement> loggedInFields = driver.findElements(By.className("accpage"));
         
         boolean isUserIdDisplayed = "User ID :".equals(loggedInFields.get(0).getText());
         assertMessage(isUserIdDisplayed, "User Id");
         
         boolean isPasswordDisplayed = "Password :".equals(loggedInFields.get(1).getText());
         assertMessage(isPasswordDisplayed, "Password");
         
         
        //close Fire fox
        driver.close();  
	}

	private static void assertMessage(boolean isPresent, String field) {
		if(isPresent) {
        	 System.out.println("Test Passed for "+field);
         }else {
        	 System.out.println("Test Failed for "+field);
         }
	}

}
