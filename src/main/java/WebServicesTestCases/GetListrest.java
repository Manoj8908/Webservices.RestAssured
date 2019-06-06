package WebServicesTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetListrest {
	
	@Test
	public void GetListUser()
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/api/users?page=2");
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The response body:-->"+ResponseBody);
		
		int StatusCode = response.getStatusCode();
		System.out.println("The StatusCode is:"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		String StastusLine = response.getStatusLine();
		System.out.println("The StatusLine is :-->"+StastusLine);
		
		//Capture details of Headers from response
		
		String contenttype = response.header("Content-Type");
		System.out.println("The Content Type is:-->"+contenttype);
		Assert.assertEquals(contenttype, "application/json; charset=utf-8");
		
		String contentencoading = response.header("Content-Encoding");
		System.out.println("The Content Type is:-->"+contentencoading);
		Assert.assertEquals(contentencoading, "gzip");
		
	}

}
