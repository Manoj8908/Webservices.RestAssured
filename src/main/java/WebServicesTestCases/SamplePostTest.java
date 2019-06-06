package WebServicesTestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class SamplePostTest {
	
	@Test
	public void PostRegistraion()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		//Specifying the request payload in JSON Format
		JSONObject requestparameter = new JSONObject();
		requestparameter.put("FirstName", "ManojSituu");
		requestparameter.put("LastName", "Kumarr");
		requestparameter.put("UserName", "ManojSitu89088");
		requestparameter.put("Password", "ManojSitu1234");
		requestparameter.put("Email", "ManojSitu1@yahoo.com");
		
		//Add a header stating the request body is a json
		request.header("Content-Type","application/json");
		//Add the JSOn to the body of Request
		request.body(requestparameter.toJSONString());
		//post the request and check the response
		Response response = request.post("/register");
		//To print the Response
		System.out.println("Response body is --->"+response.body().asString());
		
		int StatusCode = response.getStatusCode();
		System.out.println("The Statuscode is:-->"+StatusCode);
		Assert.assertEquals(StatusCode, 201);
		
		String SuccessMessage = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(SuccessMessage, "OPERATION_SUCCESS");
		
		
		
	}

}
