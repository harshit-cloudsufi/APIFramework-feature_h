package sapadapter.stepDefinetions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.JSONParser;
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

public class iDocStepdefs extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    APIResources resourceAPI;
    JsonPath js;
    JsonObject jsonObject;

    @Given("Base Url is known to for iDoc connect with direct connection")
    public void baseUrlIsKnownforidocToConnectWithDirectConnection() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(ConnectionHeader.trueConnectionHeader());
    }

    @When("user calls the iDoc list by {string} with http request")
    public void userCallsTheiDocListByWithHttpRequest(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @Then("API call got success with iDoc list with status code {int}")
    public void apiCallGotSuccessWithiDocListWithStatusCode(int int1) {
        assertEquals(int1,response.getStatusCode());

    }

    @And("iDoc list has the {int} types of obj")
    public void iDocListHasTheTypesOfobj(int size) {
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
        System.out.println(js.getList("$").size());

        assertEquals(js.getList("$").size(),size);
    }

    @Given("Base Url is known to for iDoc connect with connection via load balncer")
    public void baseUrlIsKnownforidocToConnectWithConnectionViaLoadBalncer() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(ConnectionHeader.trueConnectionHeaderLoad());
    }

    @Given("Base Url is known to for iDoc connect with S{int} hana connection")
    public void baseUrlIsKnownforidocToConnectWithSHanaConnection(int arg0) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(ConnectionHeader.trueConnectionHeaderHana());
    }

    @Given("Base Url is known to for iDoc connect with connection using snc")
    public void baseUrlIsKnownforidocToConnectWithConnectionUsingSnc() throws IOException {
        res = given().spec(requestSpecification()).
                headers(ConnectionHeader.trueConnectionSNC());
    }

    @Given("Base Url is known to for iDoc connect with direct connection for iDoc schema of {string}")
    public void baseUrlIsKnownforidocToConnectWithDirectConnectionForiDocSchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeader();
        headerMap.put("iDocName",arg0);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(headerMap);
    }

    @Given("Base Url is known to for iDoc connect with load balancer connection for iDoc schema of {string}")
    public void baseUrlIsKnownforidocToConnectWithLoadBalancerConnectionForiDocSchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("iDocName",arg0);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap);
    }

    @Given("Base Url is known to for iDoc connect with SNC connection for iDoc schema of {string}")
    public void baseUrlIsKnownforidocToConnectWithSNCConnectionForiDocSchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionSNC();
        headerMap.put("iDocSchema",arg0);
        res = given().spec(requestSpecification()).headers(headerMap);
    }

    @Given("Base Url is known to for iDoc connect with S{int} HANA connection for iDoc schema of {string}")
    public void baseUrlIsKnownforidocToConnectWithSHANAConnectionForiDocSchemaOf(int arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderHana();
        headerMap.put("iDocName",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(headerMap);
    }

    @Then("Primary mesaage is validated with {string} for iDoc list")
    public void primaryMesaageIsValidatedWithForiDocList(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"primaryMessage"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @Then("Secondary mesaage is validated when {string} for iDoc")
    public void secondaryMesaageIsValidatedWhenForiDoc(String key) throws IOException {
        Assert.assertThat(getJsonPath(response,"secondaryMessage"),StringContains.containsString(Utils.getExceptionCode(key)));

    }

    @Then("Primary code is validated with {string} for iDoc")
    public void primaryCodeIsValidatedWithForiDoc(String key) throws IOException {
        assertEquals(getJsonPath(response,"primaryCode"),Utils.getExceptionCode(key));
    }

    @Then("Secondary code is validated with {string} for iDoc")
    public void secondaryCodeIsValidatedWithForiDoc(String key) throws IOException {
        assertEquals(getJsonPath(response,"secondaryCode"),Utils.getExceptionCode(key));
    }

    @And("^iDoc API response has (.+) and (.+)$")
    public void aPIResponseHasAnd(String key, String value) throws Throwable {
        assertEquals(response.jsonPath().get(key).toString(),value);
    }

    @And("iDoc inbound file has {string} and {string}")
    public void idocInboundFileHasAnd(String arg0, String arg1) throws IOException {
        js=new JsonPath(new File("C:\\Users\\cloud2\\MATMAS05_Mon_Jul_20_10_09_44_GMT_2020.json"));
        assertEquals(arg1,js.get(arg0));
    }

    @Given("Base Url is known to for idoc-activateListener connect with S{int} HANA connection")
    public void baseUrlIsKnownToForIdocActivateListenerConnectWithSHANAConnection(int arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderHana();
        headerMap.put("jco.server.gwhost","10.132.0.4");
        headerMap.put("jco.server.gwserv","3300");
        headerMap.put("jco.server.progid","LSGOOGLE");
        headerMap.put("jco.server.connection_count","3");
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(headerMap).body("{\n" +
                "\"type\": \"IDOC\",\n" +
                "\"idocType\": \"MATMAS\",\n" +
                "\"idoc\": \"MATMAS05\",\n" +
                "\"releaseNumber\": \"754\"\n" +
                "}");
    }

    @Given("Base Url is known to connect with s{int} connection connection and has {string} payload and autocommit {string} for inbound file creation")
    public void baseUrlIsKnownToConnectWithSConnectionConnectionAndHasPayloadAndAutocommitForInboundFileCreation(int arg0, String rfc, String autocommit) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderHana();
        headerMap.put("rfcName",rfc);
        headerMap.put("autocommit",autocommit);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(headerMap).body("{\n" +
                "\t\"IV_MATNO\": \"SG-CFP-ADAPTER\",\n" +
                "\t\"IV_MSGTYP\": \"MATMAS\",\n" +
                "\t\"IV_LOGSYST\": \"LSGOOGLE\",\n" +
                "\t\"IV_ALLSEND\": \"X\"\n" +
                "}");
    }


    @When("user calls the iDoc list by {string} with post http request")
    public void userCallsTheIDocListByWithPostHttpRequest(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().post(resourceAPI.getResource()).then().extract().response();
    }
}
