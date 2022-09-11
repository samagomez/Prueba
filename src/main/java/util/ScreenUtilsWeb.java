package util;

import static driver.DriverManager.DRIVER;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface ScreenUtilsWeb {
	public static final long WAIT = 60;

	static void waitForVisibility(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DRIVER.getDriver2(), ScreenUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	@SuppressWarnings("unchecked")
	static String getTokenGT(String BaseUriUrl, String CodAgencia, String Channel, String Username, String View,
			String Application, String UsernameBa, String PasswordBa, String GetToken, String SuscriptionID) {

		String gtToken = "";
		try {
			RestAssured.baseURI = BaseUriUrl;
			RequestSpecification request = RestAssured.given().header("Authorization", "Basic dXNyX2NubF9pYjpkZW1v")
					.header("Content-Type", "application/json").header("Accept", "application/json").auth()
					.basic(UsernameBa, PasswordBa);
			JSONObject requestParams = new JSONObject();
			requestParams.put("codAgencia", "");
			requestParams.put("channel", "");
			requestParams.put("username", Username);
			requestParams.put("view", View);
			requestParams.put("application", Application);
			requestParams.put("suscriptionID", SuscriptionID);
			request.body(requestParams.toJSONString());
			Response response = request.request(Method.POST, GetToken);
			Assert.assertEquals(response.getStatusCode(), 200);
			JsonPath jsonPathEvaluator = response.jsonPath();
			gtToken = jsonPathEvaluator.get("token");
			//rama master  
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return gtToken;
	}
//mis cambios
}
