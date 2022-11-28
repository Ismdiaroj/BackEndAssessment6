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
class BackEndAssessment6ApplicationTests {

	@Before(value = "")
	public void setup() {
		RestAssured.baseURI = "http://localhost:8081";
		
	}

	@Test
	public void whenRequestGet_thenOK() {
		when().request("GET",RestAssured.baseURI).then().statusCode(200);
	}
	
	@Test
	public void whenRequestedPost_thenCreated() {
	     	with()
	    	.body(new OportunidadDTO(
	    			1001,
	    			"Ismael",
	    			"ismael@correo.com",
	    			"666123456",
	    			"Descripcion_Oportunidad"
	    			))
	    	.when()
	    	.request("POST", RestAssured.baseURI+"/add")
	    	.then()
	    	.statusCode(201);
	}
	
	@Test
	public void whenRequestedPostNullEmail_thenNotCreated() {
	     	with()
	    	.body(new OportunidadDTO(
	    			1001,
	    			"Ismael",
	    			"666123456",
	    			"Descripcion_Oportunidad"))
	    	.when()
	    	.request("POST", RestAssured.baseURI+"/add")
	    	.then()
	    	.statusCode(201);
	}
	
	@Test
	public void whenRequestedPostExistingEmail_thenNotCreated() {
	     	with()
	    	.body(new OportunidadDTO(
	    			1001,
	    			"Ismael",
	    			"existing@correo.com",
	    			"666123456",
	    			"Descripcion_Oportunidad"))
	    	.when()
	    	.request("POST", RestAssured.baseURI+"/add")
	    	.then()
	    	.statusCode(201);
	}

}
