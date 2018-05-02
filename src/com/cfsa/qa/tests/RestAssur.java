package com.cfsa.qa.tests;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
//import io.restassured.module.jsv.JsonSchemaValidator.*;
//import io.restassured.module.jsv.JsonSchemaValidator.*;

public class RestAssur {

    public void rest() {

        RestAssured.baseURI = "http";
        Response response=get("");
        given().expect();

    }



}
