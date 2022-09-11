package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static configuration.ProjectProperties.HUB;
import static configuration.ProjectProperties.USER_DIR;
import static configuration.ProjectProperties.DEVICE_PLATFORM4;
import static configuration.ProjectProperties.DEVICE_PLATFORM5;
import static configuration.ProjectProperties.DEVICE_PLATFORM6;

import com.browserstack.local.Local;

public enum BrowserstackLocalServer
{
BROWSERSTACK_SERVICE;
	private final String DESIRED_CAPABILITIES_PATH_DIR = USER_DIR.concat("/resources/desired_capabilities/");


	Local bsLocal = new Local();
	HashMap<String, String> bsLocalArgs;

	
	String propFileName;
	String propertie;

	public HashMap<String, String> setUp(String platform) throws FileNotFoundException, IOException {
		propFileName = getDesiredCapabilitiesPath(platform);
		Properties appProps = new Properties();
		appProps.load(new FileInputStream(propFileName));
		String propertie = appProps.getProperty("browserstack.key");
		bsLocalArgs = new HashMap<String, String>();
		{
			
			bsLocalArgs.put("key",propertie);	
		}
		return bsLocalArgs;
	}

	public void start(String platform) throws Exception {
			bsLocal.start(setUp(platform));
	
	}
	
	public void stop() throws Exception {
		bsLocal.stop();
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

	

		
}