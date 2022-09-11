package configuration;

public interface ProjectProperties {
	
	String USER_DIR = System.getProperty("user.dir");
    String BUILD_ENVIRONMENT = System.getProperty("build_env", Environment.TEST.env);
    String DEVICE_PLATFORM = System.getProperty("platform", Platform.FIREFOX.device);
    String DEVICE_PLATFORM2 = System.getProperty("platform", Platform.CHROME.device);
    String DEVICE_PLATFORM3 = System.getProperty("platform", Platform.SAFARI.device);
    String DEVICE_PLATFORM4 = System.getProperty("platform", Platform.ANDROID.device);
    String DEVICE_PLATFORM5 = System.getProperty("platform", Platform.IOS.device);
    String DEVICE_PLATFORM6 = System.getProperty("platform", Platform.BROWSERSTACK.device);
    String HUB = System.getProperty("hub", Hub.LOCAL.runType);

}
