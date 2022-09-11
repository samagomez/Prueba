import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApi extends BaseClass {

	@SuppressWarnings("unchecked")
	@Test(priority = 1)
	public void getTokenGT() {
		RestAssured.baseURI = BaseUriUrl;
		RequestSpecification request = RestAssured.given().header("Authorization", "Basic dXNyX2NubF9pYjpkZW1v")
				.header("Content-Type", "application/json").header("Accept", "application/json").auth().basic(UsernameBa, PasswordBa);
		JSONObject requestParams = new JSONObject();
		requestParams.put("codAgencia", CodAgencia);
		requestParams.put("channel", Channel);
		requestParams.put("username", Username);
		requestParams.put("view", View);
		requestParams.put("application", Application);
		requestParams.put("suscriptionID", SuscriptionID);
		request.body(requestParams.toJSONString());
		Response response = request.request(Method.POST, GetToken);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
