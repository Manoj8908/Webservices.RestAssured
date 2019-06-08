package WebServicesTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ValidateJsonBodyResponse {
	@Test
	public void validatejsonbodyResp()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpreq = RestAssured.given();
		
		Response response = httpreq.request(Method.GET,"/delhi");
		String ResponseBody = response.getBody().asString();
		
		//To validate the response body
		System.out.println("The Response body is:"+ResponseBody);
		Assert.assertEquals(ResponseBody.contains("Delhi"), true);
		
		/*Headers Allheaders = response.headers();
		for(Header header :Allheaders) 
		{
			System.out.println(header.getName()+" : "+header.getValue());
		}*/
	}

}
