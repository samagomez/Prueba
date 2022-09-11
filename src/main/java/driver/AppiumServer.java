package driver;

import java.util.HashMap;
import java.util.logging.Logger;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public enum AppiumServer
{
APPIUM_SERVICE;

private static Logger LOGGER = Logger.getLogger("InfoLogging");
private AppiumDriverLocalService server;

public void start() {
    AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    serviceBuilder.usingAnyFreePort();
    HashMap<String, String> environment = new HashMap<>();
    environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
    serviceBuilder.withEnvironment(environment);

    server = AppiumDriverLocalService.buildService(serviceBuilder);
    server.start();
    server.clearOutPutStreams();
}

public String getUrl() {
    start();
    return server.getUrl().toString();
}

public void stop() {
    if (server != null && server.isRunning()) {
    	LOGGER.info("stop appium server: ".concat(server.getUrl().toString()));
        server.stop();
    }
}


}