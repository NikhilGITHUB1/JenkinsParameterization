package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MavenParameterViaPropertyFileTest {
	
	//in this code though we are using properties file
	//we are passing data from the command prompt
	
	public Properties prop;
	public static WebDriver driver;
	
	@Test
	public void MethodTest() throws IOException {
		
		prop = new Properties();
	FileInputStream fis =new FileInputStream("src/test/resources" + File.separator +  "data.properties");
		
		prop.load(fis);
		String browserName = System.getProperty("browser");
		System.out.println(browserName+"this is");
		
		if(browserName.equals("Chrome")) {
			

			System.setProperty("webdriver.chrome.driver","C:\\Users\\kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.get("https://www.google.com");
			
		}
		
		else if(browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\kumar\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
			driver.get("https://www.facebook.com");
			
		}
		
		
	}

}
