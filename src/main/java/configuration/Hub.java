package configuration;

public enum Hub {
	
	LOCAL("local"),
    SAUCE_LABS("sauceLabs"),
	BROWSERSTACK("browsertack"),
	WEB("web");
    public final String runType;

    Hub(String hub) {
        this.runType = hub;
    }


}
