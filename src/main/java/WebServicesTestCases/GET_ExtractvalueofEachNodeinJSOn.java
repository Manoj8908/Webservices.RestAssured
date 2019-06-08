package WebServicesTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GET_ExtractvalueofEachNodeinJSOn {
	@Test
	public void ExtractValueInJSON()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/delhi");
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("City"));  
		System.out.println(jsonpath.get("Temperature")); 
		System.out.println(jsonpath.get("Humidity")); 
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed")); 
		
		Assert.assertEquals("39.84 Degree celsius", jsonpath.get("Temperature"));
		
		
	}

}
