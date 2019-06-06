package WebServicesTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SampleGetTest {
	
	@Test
	public void GetWeaatherList()
		{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		// Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody = response.getBody().asString();
		//To Extract the Status Code
		System.out.println("Response Body is =>  " + responseBody);
		int StatusCode=response.getStatusCode();
		System.out.println(StatusCode);
		//To Extract the status line
		String StatuslIne = response.getStatusLine();
		System.out.println(StatuslIne);
		
		Assert.assertEquals(StatusCode, 200);
		 }
} 
