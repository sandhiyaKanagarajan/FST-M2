package com.ibm.fst.restAssured.GitHub_RestAssured_Project;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;

public class ProjectActivity {
	
	

	// Declare request specification
    RequestSpecification requestSpec;
   
    String SSHKey;
    public static int id;
  
    @BeforeClass
    public void setUp() {
    	
    	
    	// Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // set Authurization token
                .setAuth(oauth2("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"))
                // Set base URL
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();
        
        
       
    }
    
    
   // @Test(priority=1)
    
    public void addSSHKey() {
        String reqBody = "{\"title\":\"testapitkey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQCp6o/DcgneshP1u43pHd8OhTl+Dzgr26KzZxcK2XVab/sxpgjA3ii9Wbg4CzbCWFy6dHkF9hl+4q6kw3krkKoczMukv8+m3l8Mpud3uxZ8jfwZqLM3ROGOaFsBLcJ5zx5zJe6pc84RxpqOMQC7UPz7MVqsqksn88IVgNTG0Q5xPw==\"}";
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post("/user/keys"); // Send POST request
        

        // Print response
        System.out.println(response.asPrettyString());
        
       // Assertion
        response.then().statusCode(201);
 
        
      
    }
    
    @Test(priority=1)
    public void getKeys() {
        Response response = given().spec(requestSpec) // Use requestSpec
        		.when().get("/user/keys"); // Send GET request
 
        // Print response
        
        System.out.println(response.asPrettyString());
        id = response.then().extract().path("id");
        Reporter.log(response.asPrettyString());
       


        // Assertion
        
        response.then().statusCode(200);
    }
    
    
   //  @Test(priority=1)
    public void Keys() {
        Response response = given().spec(requestSpec) // Use requestSpec
        .when().delete("/user/keys/"+id); // Send GET request
 
    // Assertion
        
        response.then().statusCode(204);
    }
}