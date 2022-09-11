package configuration;

public enum Platform {

	FIREFOX("firefox"),
    CHROME("chrome"),
	SAFARI("safari"),
	IOS("ios"),
	ANDROID("android"),
	BROWSERSTACK("browserstack");
	public final String device;

    Platform(String platformType) {
        this.device = platformType;
    }

}
