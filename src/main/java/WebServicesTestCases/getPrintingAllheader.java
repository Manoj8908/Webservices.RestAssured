package WebServicesTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getPrintingAllheader {
	
	@Test
	public void PrintAllHeaders() {
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/api/users?page=2");
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The response body:-->"+ResponseBody);
		
		Headers Allheader=response.headers();
		for(Header heders:Allheader)
		{
			System.out.println(heders.getName()+"  "+heders.getValue());
		}
	}

}
