package com.example.demo;

import static io.restassured.RestAssured.with;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class AccionFutura {

	@Before(value = "")
	public void setup() {
		RestAssured.baseURI = "http://localhost:8081";
	}
	
	@Test
	public void whenRequestedPostFutureContact_thenCreated() {
	     	with()
	    	.body(new ContactoDTO(
	    			"2022-12-12", //fecha
	    			1001,//oportunidad_id
	    			"email" //canal de contacto
	    			))
	    	.when()
	    	.request("POST", RestAssured.baseURI+"/add")
	    	.then()
	    	.statusCode(201);
	}
	
	@Test
	public void whenRequestedPostInvalidFutureDate_thenNotCreated() {
	     	with()
	    	.body(new ContactoDTO(
	    			"1999-12-12", //fecha
	    			1001,//oportunidad_id
	    			"email" //canal de contacto
	    			))
	    	.when()
	    	.request("POST", RestAssured.baseURI+"/add")
	    	.then()
	    	.statusCode(201);
	}

}
