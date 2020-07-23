package sapadapter.stepDefinetions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.JSONParser;
import gherkin.deps.com.google.gson.JsonDeserializationContext;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import resources.APIResources;
import sapadapter.parameter.ConnectionHeader;
import sapadapter.payload.BapiExecutionPayload;
import sapadapter.utilities.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import sapadapter.parameter.ConnectionHeader;
import sapadapter.utilities.Utils;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.*;



public class StepDefBapi extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    APIResources resourceAPI;
    JsonPath js;
    BapiExecutionPayload payloadData;
    String value;
    String payload;




    @Given("Base Url is known to connect with direct connection")
    public void baseUrlIsKnownToConnectWithDirectConnection() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(ConnectionHeader.trueConnectionHeader());
    }

    @When("user calls the bapi list by {string} with GET http request")
    public void userCallsTheBapiListByWithGETHttpRequest(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @Then("API call got success with Bapi list with status code {int}")
    public void apiCallGotSuccessWithBapiListWithStatusCode(int int1) {
        assertEquals(int1,response.getStatusCode());

    }

    @And("Bapi list has the {int} types of elements")
    public void bapiListHasTheTypesOfElements(int size) {
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
        assertEquals(js.getMap("$").size(),size);
    }

    @Given("Base Url is known to connect with connection via load balncer")
    public void baseUrlIsKnownToConnectWithConnectionViaLoadBalncer() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(ConnectionHeader.trueConnectionHeaderLoad());
    }


    @Given("Base Url is known to connect with S{int} hana connection")
    public void baseUrlIsKnownToConnectWithSHanaConnection(int arg0) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(ConnectionHeader.trueConnectionHeaderHana());
    }

    @Given("Base Url is known to connect with connection using snc")
    public void baseUrlIsKnownToConnectWithConnectionUsingSnc() throws IOException {
        res = given().spec(requestSpecification()).
                headers(ConnectionHeader.trueConnectionSNC());
    }

    @Given("Base Url and {string} is known to connect with direct connection")
    public void baseUrlAndIsKnownToConnectWithDirectConnection(String user) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue(user)).
                headers(ConnectionHeader.trueConnectionHeader());
    }

    @Given("Base Url and {string} is known to connect with load balancer connection")
    public void baseUrlAndIsKnownToConnectWithLoadBalancerConnection(String user) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue(user)).
                headers(ConnectionHeader.trueConnectionHeaderLoad());
    }
    @Given("Base Url and {string} is known to connect with snc connection")
    public void baseUrlAndIsKnownToConnectWithSncConnection(String arg0) {Map<String, String> headerMap =new HashMap<>();

    }
    @Given("Base Url and {string} is known to connect with S{int} HANA connection")
    public void baseUrlAndIsKnownToConnectWithSHANAConnection(String user, int arg1) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue(user)).
                headers(ConnectionHeader.trueConnectionHeaderHana());
    }

    @Given("Base Url is known to connect with direct connection for BAPI schema of {string}")
    public void baseUrlIsKnownToConnectWithDirectConnectionForBAPISchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeader();
        headerMap.put("bapiName",arg0);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(headerMap);
    }
    @And("^API response has (.+) and (.+)$")
    public void aPIResponseHasAnd(String key, String value) throws Throwable {
        assertEquals(response.jsonPath().get(key).toString(),value);
    }

    @Given("Base Url is known to connect with load balancer connection for BAPI schema of {string}")
    public void baseUrlIsKnownToConnectWithLoadBalancerConnectionForBAPISchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("bapiName",arg0);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap);
    }

    @Given("Base Url is known to connect with SNC connection for BAPI schema of {string}")
    public void baseUrlIsKnownToConnectWithSNCConnectionForBAPISchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionSNC();
        headerMap.put("bapiSchema",arg0);
        res = given().spec(requestSpecification()).headers(headerMap);
    }

    @Given("Base Url is known to connect with S{int} HANA connection for BAPI schema of {string}")
    public void baseUrlIsKnownToConnectWithSHANAConnectionForBAPISchemaOf(int arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderHana();
        headerMap.put("bapiName",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(headerMap);
    }

    @Then("Primary mesaage is validated with {string} for Bapi list")
    public void primaryMesaageIsValidatedWithForBapiList(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"primaryMessage"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @Then("Secondary mesaage is validated when {string} for bapi")
    public void secondaryMesaageIsValidatedWhenForBapi(String key) throws IOException {
        Assert.assertThat(getJsonPath(response,"secondaryMessage"),StringContains.containsString(Utils.getExceptionCode(key)));

    }

    @Then("Primary code is validated with {string} for bapi")
    public void primaryCodeIsValidatedWithForBapi(String key) throws IOException {
        assertEquals(getJsonPath(response,"primaryCode"),Utils.getExceptionCode(key));
    }

    @Then("Secondary code is validated with {string} for bapi")
    public void secondaryCodeIsValidatedWithForBapi(String key) throws IOException {
        assertEquals(getJsonPath(response,"secondaryCode"),Utils.getExceptionCode(key));
    }



    @Given("Base Url is known to connect with loadbalancer connection connection and has {string} payload and autocommit {string}")
    public void baseUrlIsKnownToConnectWithLoadbalancerConnectionConnectionAndHasPayloadAntAutocommit(String arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("bapiName",arg0);
        headerMap.put("Autocommit",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body(payloadData.PurchaseOrderFRE);
    }

    @When("user calls the bapi execution by {string} with GET http request")
    public void userCallsTheBapiExecutionByWithGETHttpRequest(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().post(resourceAPI.getResource()).then().extract().response();

    }

    @Then("Verify {string} has not null Value")
    public void verifyHasNotNullValue(String key) {
        assertFalse(response.jsonPath().get(key).toString().matches(""));
    }

    @Then("Get the {string} value")
    public void getTheValue(String arg0) {
       value= response.jsonPath().get(arg0).toString();
       payload="{\"PURCHASEORDER\":"+value+"}";
    }

    @Given("Base Url is known to connect with loadbalancer connection connection and has {string} payload and autocommit {string} to verify auto commit")
    public void baseUrlIsKnownToConnectWithLoadbalancerConnectionConnectionAndHasPayloadAndAutocommitToVerifyAutoCommit(String arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("rfcName",arg0);
        headerMap.put("Autocommit",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body("{\"PURCHASEORDER\":"+value+"}");

    }

    @Then("Verify {string} has same value as above")
    public void verifyHasSameValueAsAbove(String key) {
        assertEquals(response.jsonPath().get(key).toString(),value);
    }

    @Then("Verify {string} has null value")
    public void verifyHasNullValue(String key) {
        assertTrue(response.jsonPath().get(key).toString().matches(""));
    }

    @Given("Base Url is known to connect with loadbalancer connection connection and has invalid comp code {string} payload and autocommit {string}")
    public void baseUrlIsKnownToConnectWithLoadbalancerConnectionConnectionAndHasInvalidCompCodePayloadAndAutocommit(String arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("bapiName",arg0);
        headerMap.put("Autocommit",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body(payloadData.CreateFromData1InvalidComp_Code);
    }

    @And("Verify {string} has message {string}")
    public void verifyHasMessage(String key, String val) {
        assertTrue(response.jsonPath().get(key).toString().contains(val));

    }

    @Given("^Base Url is known to connect with loadbalancer connection connection and has invalid Purchase organisation \"([^\"]*)\" payload and autocommit \"([^\"]*)\" replace (.+) with (.+)$")
    public void baseUrlIsKnownToConnectWithLoadbalancerConnectionConnectionAndHasInvalidPurchaseOrganisationSomethingPayloadAndAutocommitSomethingReplaceWith(String arg0, String arg1, String key, String value) throws Throwable {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("bapiName",arg0);
        headerMap.put("Autocommit",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body(payloadData.PurchaseOrderFRE.replace(key,value));
    }
    @And("^Verify (.+) has error message (.+)$")
    public void verifyHaserrorMessage(String jsonpath, String message) throws Throwable {
        assertTrue(response.jsonPath().get(jsonpath).toString().contains(message));
    }


}
