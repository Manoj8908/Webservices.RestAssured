package SYSTRANTranslation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTranslate {
	@Test
	public static void SystrantgetTrnaslate()
	{
		RestAssured.baseURI="https://systran-systran-platform-for-language-processing-v1.p.rapidapi.com";
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/translation/text/translate?source={source}&target={target}&input={input}");
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The response body is:::"+ResponseBody);
		int StatusCode = response.getStatusCode();
		System.out.println("The StatusCode is:"+StatusCode);
		
		String StatusLine = response.getStatusLine();
		System.out.println("The Statusline is:"+StatusLine);
		
		Assert.assertEquals(StatusCode, 401);
		
		String ContentType = response.header("Content-Type");
		System.out.println(ContentType);
		Assert.assertEquals(ContentType, "application/json");
	}

}
