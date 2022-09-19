import static driver.DriverManager.DRIVER;
import static configuration.Config.CONFIG;
import static driver.AppiumServer.APPIUM_SERVICE;
import static driver.BrowserstackLocalServer.BROWSERSTACK_SERVICE;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.WebDriverRunner;

//base class
public class BaseClass {
	
	public static String BaseUriUrl = "", GetToken = "", CodAgencia = "", Channel = "", Username = "",
			View = "", Application = "", UsernameBa="", PasswordBa="", ComplementUrl="", WebUrl= "", SuscriptionID="";

	@BeforeClass(alwaysRun = true)
	@Parameters(value = { "platform" })
	public void beforeTest(ITestContext context, String platform) throws IOException {

		try {
			CONFIG.setTestEnvironment();
			switch (platform.toLowerCase()) {
			case "chrome":
				DRIVER.chromeDriverConnection();
				DRIVER.maximizeBrowser();
				break;
			case "firefox":
				DRIVER.firefoxDriverConnection();
				DRIVER.maximizeBrowser();
				WebDriverRunner.setWebDriver(DRIVER.getURL(WebUrl+ComplementUrl));
				break;
			case "edge":
				DRIVER.edgeDriverConnection();
				DRIVER.maximizeBrowser();
				WebDriverRunner.setWebDriver(DRIVER.getURL(WebUrl+ComplementUrl));
				break;
			case "android":
				DRIVER.setDriver(platform);
				WebDriverRunner.setWebDriver(DRIVER.getDriver());
				break;
			case "ios":
				DRIVER.setDriver(platform);
				WebDriverRunner.setWebDriver(DRIVER.getDriver());
				break;
			case "browserstack_ios":
				BROWSERSTACK_SERVICE.start(platform);
				DRIVER.setDriver(platform);
				WebDriverRunner.setWebDriver(DRIVER.getDriver());
				break;
			case "browserstack_android":
				BROWSERSTACK_SERVICE.start(platform);
				DRIVER.setDriver(platform);
				WebDriverRunner.setWebDriver(DRIVER.getDriver());
				break;
			case "browserstack_web":
				BROWSERSTACK_SERVICE.start(platform);
				DRIVER.setDriver(platform);
				WebDriverRunner.setWebDriver(DRIVER.getDriver2());
				DRIVER.getDriver2().manage().window().maximize();
				DRIVER.getDriver2().get(WebUrl);
				break;
			case "api":
				// System.out.println(platform);
				break;

			default:

			}
			// UI DATA


			// API DATA
			BaseUriUrl = System.getProperty("baseapiurl");
			GetToken = System.getProperty("getToken");
			CodAgencia = System.getProperty("codAgencia");
			Username = System.getProperty("username");
			Channel = System.getProperty("channel");
			View = System.getProperty("view");
			Application = System.getProperty("application");
			SuscriptionID = System.getProperty("suscriptionID");
			UsernameBa = System.getProperty("usernameBA");
			PasswordBa = System.getProperty("passwordBA");
			WebUrl = System.getProperty("webUrl");

		} catch (Exception e)

		{
			System.out.println(e);
		}

	}

	
	@AfterClass(alwaysRun = true)
	public void afterTest(final ITestContext testContext) {
		try {
			DRIVER.closeDriver();
			APPIUM_SERVICE.stop();
			// BROWSERSTACK_SERVICE.stop();

		} catch (Exception e) {

			// Do Something
			// dont someting
		}
	}

}
