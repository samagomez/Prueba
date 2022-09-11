package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import configuration.ProjectProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


import static configuration.ProjectProperties.HUB;
import static configuration.ProjectProperties.USER_DIR;
import static driver.AppiumServer.APPIUM_SERVICE;
import static configuration.Config.CONFIG;
import static configuration.ProjectProperties.DEVICE_PLATFORM;
import static configuration.ProjectProperties.DEVICE_PLATFORM2;
import static configuration.ProjectProperties.DEVICE_PLATFORM3;
import static configuration.ProjectProperties.DEVICE_PLATFORM4;
import static configuration.ProjectProperties.DEVICE_PLATFORM5;
import static configuration.ProjectProperties.DEVICE_PLATFORM6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public enum DriverManager {
	
	DRIVER;
	
	public WebDriver driver;
	
	private final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private final ThreadLocal<AppiumDriver<MobileElement>> mobileDriver = new ThreadLocal<>();
	private final String DESIRED_CAPABILITIES_PATH_DIR = USER_DIR.concat("/resources/desired_capabilities/");
	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
	private String getHubURL() {
	    return APPIUM_SERVICE.getUrl();
	}

	private DesiredCapabilities getLocalDesiredCapabilities(String fileName) {
		 LOGGER.info("file name: "+fileName);
		return CONFIG.computeDesiredCaps(fileName);
	}
	
	
	
	public boolean isFireFoxPlatform() {

	    return DEVICE_PLATFORM.contentEquals("firefox");
	}
	
	public boolean isChromePlatform() {

	    return DEVICE_PLATFORM2.contentEquals("chrome");
	}
	
	public boolean isSafariPlatform() {

	    return DEVICE_PLATFORM3.contentEquals("safari");
	}
	
	public boolean isAndroidPlatform() {

	    return DEVICE_PLATFORM4.contentEquals("android");
	}
	
	public boolean isIosPlatform() {

	    return DEVICE_PLATFORM5.contentEquals("ios");
	}
	
	private String getDesiredCapabilitiesPath(String platform) {
		String DesiredCapabilitiePath = "";
		
		if(platform.equals("android"))
		{
			DesiredCapabilitiePath = DESIRED_CAPABILITIES_PATH_DIR.concat(HUB)
            .concat("_")
            .concat(DEVICE_PLATFORM4)
            .concat(".properties");
		}
		if(platform.equals("ios"))
		{
			DesiredCapabilitiePath = DESIRED_CAPABILITIES_PATH_DIR.concat(HUB)
            .concat("_")
            .concat(DEVICE_PLATFORM5)
            .concat(".properties");
		}
		if(platform.equals("browserstack_ios"))
		{
			DesiredCapabilitiePath = DESIRED_CAPABILITIES_PATH_DIR.concat(HUB)
            .concat("_")
            .concat(DEVICE_PLATFORM6)
            .concat(".properties");
		}
		if(platform.equals("browserstack_android"))
		{
			DesiredCapabilitiePath = DESIRED_CAPABILITIES_PATH_DIR
            .concat(HUB)
            .concat("_")
            .concat(DEVICE_PLATFORM6)
            .concat("_android")
            .concat(".properties");
		}
		
		if(platform.equals("browserstack_web"))
		{
			DesiredCapabilitiePath = DESIRED_CAPABILITIES_PATH_DIR
	        .concat(HUB)
	        .concat("_")
	        .concat(DEVICE_PLATFORM6)
	        .concat("_web")
	        .concat(".properties");
		}
		
		
		return DesiredCapabilitiePath;
	}

	private DesiredCapabilities getDesiredCapabilities(String platform) 
	{
		return getLocalDesiredCapabilities(getDesiredCapabilitiesPath(platform));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setDriver(String remoteAddress, DesiredCapabilities capabilities, String platform)
	{
		if(platform.equals("android"))
		{
			 try {
			        mobileDriver.set(new AndroidDriver<>(new URL(remoteAddress), capabilities));
			    } catch (MalformedURLException e) {
			        e.printStackTrace();
			    }
		}
		else if(platform.equals("ios"))
		{
			 try {
		    	 mobileDriver.set(new IOSDriver<>(new URL(remoteAddress), capabilities));
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
		}
		else if(platform.equals("browserstack_ios"))
		{
			 try {
		    	 mobileDriver.set(new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities));
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
		}
		else if(platform.equals("browserstack_android"))
		{
			try {
		    	 mobileDriver.set(new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities));
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
		}
		
		else if(platform.equals("browserstack_web"))
		{
			 try {
		    	 webDriver.set(new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities));
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public void setDriver(String platform)
	{
		setDriver(getHubURL(),getDesiredCapabilities(platform), platform);
	}
	
	
	public WebDriver chromeDriverConnection() {
		 String configPath = ProjectProperties.USER_DIR
	                .concat("/resources/drivers/");
		 System.setProperty("webdriver.chrome.driver", configPath +"chromedriver.exe");
		 driver = new ChromeDriver();
		 webDriver.set(driver);
		 return driver;	 
	 }	 

	 public WebDriver firefoxDriverConnection() {
		 String configPath = ProjectProperties.USER_DIR
	                .concat("/resources/drivers/");
		 System.setProperty("webdriver.gecko.driver", configPath +"geckodriver.exe");
		 driver = new FirefoxDriver();
		 webDriver.set(driver);
		return driver;	 
	 }
	 
	 public WebDriver edgeDriverConnection() {
		 String configPath = ProjectProperties.USER_DIR
	                .concat("/resources/drivers/");
		 System.setProperty("webdriver.edge.driver", configPath +"msedgedriver.exe");
		 driver = new EdgeDriver();
		 webDriver.set(driver);
		return driver;	 
	 }
	 
	 public void maximizeBrowser() {
		 driver.manage().window().maximize();
	 }
	  
	 public AppiumDriver<MobileElement> getDriver() {
		    return mobileDriver.get();
		}
	 
	 public WebDriver getDriver2() {
			return webDriver.get();
	    }
	 
	 public WebDriver getURL(String url) {
		 driver.get(url);
		return driver;
	 }
	 
	public void closeDriver() {	
		 AppiumDriver<MobileElement> result;
		 result = getDriver();
		 
		 if(result != null)
		 {
			 getDriver().quit(); 
		 }
		 else
		 {
			 getDriver2().quit();
		 }  
	        
		 }
}
