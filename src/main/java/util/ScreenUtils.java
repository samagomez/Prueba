package util;

import static driver.DriverManager.DRIVER;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AuthenticatesByFinger;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public interface ScreenUtils {

	public static final long WAIT = 60;

	static void waitForVisibility(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DRIVER.getDriver(), ScreenUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	static void waitForInvisibility(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DRIVER.getDriver(), ScreenUtils.WAIT);
		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}

	static void scrollDown(int pixelsToScroll) {
		Point targetPoint = new Point(getRightCenterScreenBoundary(), getYAxisScreenCenter());
		TouchAction<? extends WebElement> action = new TouchAction<>(DRIVER.getDriver());
		action.press(point(targetPoint)).waitAction(new WaitOptions().withDuration(ofMillis(1300L)))
				.moveTo(point(getRightCenterScreenBoundary(), getYAxisScreenCenter() - pixelsToScroll)).release()
				.perform();
	}

	static void scrollDownTimes(int times) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		for (int i = 0; i < times; i++) {
			scrollDown(250);
		}
		TimeUnit.SECONDS.sleep(1);
	}

	static WebElement findItemWithScrollingUsingBy(WebElement element, int interactions) {

		for (int i = 0; i < interactions; i++) {
			if (!element.isDisplayed()) {
				scrollDown(600);
			} else {
				return element; // you can add .click() here instead of returning the element
			}
		}
		Assert.fail("Element not found");
		return null;
	}

	static void findItemUsingBy(WebElement element1, WebElement element2, int interactions) {
		for (int i = 0; i < interactions; i++) {
			if (!element2.isDisplayed()) {
				swipeElementAndroid(element1, "LEFT");
			}
			if (!element2.isDisplayed()) {
				scrollDown(500);

			}

		}
	}

	static WebElement findItemOnList(WebElement element, int interactions) {
		for (int i = 0; i < interactions; i++) {
			if (!element.isDisplayed()) {
				scrollDown(500);
			} else {
				return element;
			}
		}
		return null;

	}

	static void clickOnPoint(int x, int y) {
		Point targetPoint = new Point(x, y);
		TouchAction<? extends WebElement> action = new TouchAction<>(DRIVER.getDriver());
		action.tap(point(targetPoint)).release().perform();
	}

	static void recoverFocus() {
		Point targetPoint = new Point(getScreenWidth() / 2, getScreenHeight() - 80);
		TouchAction<? extends WebElement> action = new TouchAction<>(DRIVER.getDriver());
		action.tap(point(targetPoint)).perform();
	}

	static int getYAxisScreenCenter() {
		return getScreenHeight() / 2;
	}

	static int getXAxisScreenCenter() {
		return getScreenWidth() / 2;
	}

	static int getRightCenterScreenBoundary() {
		return getScreenWidth() - 1;
	}

	static int getScreenHeight() {
		return DRIVER.getDriver().manage().window().getSize().getHeight();
	}

	static int getScreenWidth() {
		return DRIVER.getDriver().manage().window().getSize().getWidth();
	}

	static int getScrollStepToTop() {
		return (int) (getYAxisScreenCenter() / 0.8);
	}

	@SuppressWarnings("rawtypes")
	static void swipeElementAndroid(WebElement el, String dir) {

		System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions
		final int ANIMATION_TIME = 200;
		final int PRESS_TIME = 200;
		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;

		Rectangle rect = el.getRect();

		edgeBorder = 0;

		switch (dir) {
		case "DOWN": // from up to down
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			break;
		case "UP": // from down to up
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			break;
		case "LEFT": // from right to left
			pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			break;
		case "RIGHT": // from left to right
			pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(DRIVER.getDriver()).press(pointOptionStart)
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();

		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\\n" + e.getMessage());
			return;
		}
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	@SuppressWarnings("rawtypes")
	static void swipeElementByPixels(WebElement el, String dir) {
		System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions
		final int ANIMATION_TIME = 200;
		final int PRESS_TIME = 300;
		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;

		Rectangle rect = el.getRect();

		edgeBorder = 0;

		switch (dir) {
		case "DOWN": // from up to down
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			break;
		case "UP": // from down to up
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			break;
		case "LEFT": // from right to left
			pointOptionStart = PointOption.point((rect.x + 100) + rect.width - edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			break;
		case "RIGHT": // from left to right

			pointOptionStart = PointOption.point((rect.x - 100) + edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			System.out.println("pointOptionStart: " + pointOptionStart);
			System.out.println("pointOptionEnd: " + pointOptionEnd);
			break;
		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(DRIVER.getDriver()).press(pointOptionStart)
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();

		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\\n" + e.getMessage());
			return;
		}
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	// Swipe Screen
	static void swipe(Duration duration) throws InterruptedException {
		boolean isAndroid = DRIVER.getDriver() instanceof AndroidDriver<?>;
		TimeUnit.SECONDS.sleep(2);

		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), getScreenWidth() / 2,
				((getScreenHeight() / 12) * 11)));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		if (isAndroid) {
			duration = duration.dividedBy(3);
		} else {
			swipe.addAction(new Pause(input, duration));
			duration = Duration.ZERO;
		}
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), getScreenWidth() / 2,
				((getScreenHeight() / 12) * 3)));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		DRIVER.getDriver().perform(ImmutableList.of(swipe));

		TimeUnit.SECONDS.sleep(2);
	}

	@SuppressWarnings("rawtypes")
	static void backAndroidButton() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		((AndroidDriver) DRIVER.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
	}

	static void Setlocation() {
		DRIVER.getDriver().setLocation(new Location(13.683254, -89.274384, 932));
	}

	@SuppressWarnings("deprecation")
	static void ClickKeyboard(String Code) {
		DRIVER.getDriver().getKeyboard().sendKeys(Code);

	}

	static void LongPressClick(WebElement webElement) throws InterruptedException {

		new Actions(DRIVER.getDriver()).clickAndHold(webElement).perform();

	}

	static void SingleTap(WebElement webElement) throws InterruptedException {
		new Actions(DRIVER.getDriver()).doubleClick(webElement).perform();
	}

	static void FingerPrint() {
		((AuthenticatesByFinger) DRIVER.getDriver()).fingerPrint(1);
	}

	static String evaluateTimeZone() {
		String greetings = null;
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar c = Calendar.getInstance(timeZone);
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

		if (timeOfDay >= 0 && timeOfDay < 12) {
			greetings = "Buenos días";
		} else if (timeOfDay >= 12 && timeOfDay < 18) {
			greetings = "Buenas tardes";
		} else if (timeOfDay >= 18 && timeOfDay < 24) {
			greetings = "Buenas noches";
		}		
		return greetings;
	}

	static void CloseApp() {
		DRIVER.getDriver().closeApp();
	}

	static void RelaunchApp() {
		DRIVER.getDriver().launchApp();
	}
	static void HideKeyboard() {
		DRIVER.getDriver().hideKeyboard();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static ArrayList GetProductsCode(String BaseUriUrl, String ITipoClient, String Imis, String IProduct, String GetClientProducts) {
		RestAssured.baseURI = BaseUriUrl;
		RequestSpecification request = RestAssured.given().header("canal", "10")
				.header("Content-Type", "application/json").header("Accept", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("itipoCliente", ITipoClient);
		requestParams.put("imis", Imis);
		requestParams.put("iproducto", IProduct);
		request.body(requestParams.toJSONString());
		Response response = request.request(Method.POST, GetClientProducts);
		ArrayList b = response.getBody().jsonPath().get("data.products.productnumber");
		return b;
	}
	
	@SuppressWarnings("unchecked")
	static Integer GetProductsQuantity(String BaseUriUrl, String ITipoClient, String Imis, String IProduct, String GetClientProducts) {
		RestAssured.baseURI = BaseUriUrl;
		RequestSpecification request = RestAssured.given().header("canal", "10")
				.header("Content-Type", "application/json").header("Accept", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("itipoCliente", ITipoClient);
		requestParams.put("imis", Imis);
		requestParams.put("iproducto", IProduct);
		request.body(requestParams.toJSONString());
		Response response = request.post(GetClientProducts);
		Integer a = response.getBody().jsonPath().get("totalElements");
		return a;
	}
	
}
