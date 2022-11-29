package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.aspectj.lang.annotation.Before;

@SpringBootTest
public class LoginTest {

	@Before(value = "")
	public void setup() {
		RestAssured.baseURI = "http://localhost:8081";
		
	}
	
	@Test
	public void whenRequestedSuccessfulLogin_thenLogIn() {
     	with()
    	.body(new Login(
    			"testing",
    			"testing"))
    	.when()
    	.request("POST", RestAssured.baseURI+"/login")
    	.then()
    	.statusCode(200);
}
	
	@Test
	public void whenRequestedWrongLogin_thenNotLogIn() {
     	with()
    	.body(new Login(
    			"testing",
    			"wrong_password"))
    	.when()
    	.request("POST", RestAssured.baseURI+"/login")
    	.then()
    	.statusCode(403);
}
	
	@Test
	public void whenRequestedNullLogin_thenNotLogIn() {
     	with()
    	.body(new Login(
    			))
    	.when()
    	.request("POST", RestAssured.baseURI+"/login")
    	.then()
    	.statusCode(403);
}


}
