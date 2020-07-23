package sapadapter.stepDefinetions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import sapadapter.parameter.ConnectionHeader;
import sapadapter.payload.RFCExecutionPayload;
import sapadapter.utilities.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class StepDefRFCList extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    APIResources resourceAPI;
    JsonPath js;
    RFCExecutionPayload payload;
    String value;
    String payloadVal;

    @Given("Base Url is known to connect with Hana")
    public void baseUrlIsKnownToConnectWithSHana() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(ConnectionHeader.trueConnectionHeaderHana());
    }

    @When("user calls the list by {string} with GET http request")
    public void userCallsTheListByWithGETHttpRequest(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @Then("API call got success with RFC list with status code {int}")
    public void apiCallGotSuccessWithRFCListWithStatusCode(int int1) {
        System.out.println(response.getTime());
        assertEquals(int1,response.getStatusCode());
    }

    @And("list has the {int} types of elements")
    public void listHasTheTypesOfElements(int size) {
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
        assertEquals(js.getMap("$").size(),size);
    }

    @Given("Base Url is known to connect with direct connection for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlIsKnownToConnectWithDirectConnectionForRFCWithQueryRefreshAndFilter(String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionHeader());
    }

    @Given("Base Url is known to connect with connection via load balncer for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlIsKnownToConnectWithConnectionViaLoadBalncerForRFCWithQueryRefreshAndFilter(String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionHeaderLoad());
    }

    @Given("Base Url is known to connect with connection using snc for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlIsKnownToConnectWithConnectionUsingSncForRFCWithQueryRefreshAndFilter(String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionSNC());
    }

    @Given("Base Url is known to connect with S{int} hana connection for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlIsKnownToConnectWithSHanaConnectionForRFCWithQueryRefreshAndFilter(int arg0, String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionHeaderHana());
    }


    @Given("Base Url and {string} is known to connect with direct connection for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlAndIsKnownToConnectWithDirectConnectionForRFCWithQueryRefreshAndFilter(String arg0, String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue(arg0)).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionHeader());

    }

    @Given("Base Url and {string} is known to connect with load balancer connection for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlAndIsKnownToConnectWithLoadBalancerConnectionForRFCWithQueryRefreshAndFilter(String arg0, String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue(arg0)).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionHeaderLoad());
    }

    @Given("Base Url and {string} is known to connect with S{int} HANA connection for RFC with query refresh= {string} and filter= {string}")
    public void baseUrlAndIsKnownToConnectWithSHANAConnectionForRFCWithQueryRefreshAndFilter(String arg0, int arg1, String refresh, String filter) throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue(arg0)).queryParam("refresh",refresh).
                queryParam("filter",filter).
                headers(ConnectionHeader.trueConnectionHeaderHana());
    }

    @Given("Base Url is known to connect with direct connection for RFC schema of {string}")
    public void baseUrlIsKnownToConnectWithDirectConnectionForRFCSchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeader();
        headerMap.put("rfcName",arg0);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(headerMap);
    }

    @Given("Base Url is known to connect with load balancer connection for RFC schema of {string}")
    public void baseUrlIsKnownToConnectWithLoadBalancerConnectionForRFCSchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("rfcName",arg0);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap);
    }

    @Given("Base Url is known to connect with SNC connection for RFC schema of {string}")
    public void baseUrlIsKnownToConnectWithSNCConnectionForRFCSchemaOf(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionSNC();
        headerMap.put("rfcName",arg0);
        res = given().spec(requestSpecification()).headers(headerMap);
    }

    @Given("Base Url is known to connect with S{int} HANA connection for RFC schema of {string}")
    public void baseUrlIsKnownToConnectWithSHANAConnectionForRFCSchemaOf(int arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderHana();
        headerMap.put("rfcName",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("wncodedBaseStringHana")).
                headers(headerMap);
    }

    @And("^RFC API response has (.+) and (.+)$")
    public void rfcAPIResponseHasKeyAndValue(String key, String value ) {
        assertEquals(response.jsonPath().get(key).toString(),value);
    }

    @Then("Response time is greater than {int} ms")
    public void responseTimeIsGreaterThanMs(int t) {
        assertTrue(response.getTime()>t);
    }

    @Then("Response time is less than {int} ms")
    public void responseTimeIsLessThanMs(int t) {
        assertTrue(response.getTime()<t);
    }

    @Given("Base Url is known to connect with direct connection connection and has {string} payload for RFC execution")
    public void baseUrlIsKnownToConnectWithDirectConnectionConnectionAndHasPayloadForRFCExecution(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeader();
        headerMap.put("rfcName",arg0);
        headerMap.put("autocommit","true");
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(headerMap).body(payload.BAPI_CUSTOMER_CREATEFROMDATA1);
    }

    @When("user calls the RFC execution by {string} with GET http request")
    public void userCallsTheRFCExecutionByWithGETHttpRequest(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().post(resourceAPI.getResource()).then().extract().response();
    }

    @Then("Verify RFC {string} has not null Value")
    public void verifyRFCHasNotNullValue(String key) {
        assertFalse(response.jsonPath().get(key).toString().matches(""));

    }

    @Given("Base Url is known to connect with load balancer connection connection and has {string} payload for RFC execution")
    public void baseUrlIsKnownToConnectWithLoadBalancerConnectionConnectionAndHasPayloadForRFCExecution(String arg0) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("rfcName",arg0);
        headerMap.put("autocommit","true");
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body(payload.BAPI_CUSTOMER_CREATEFROMDATA1);
    }



    @Then("Get the {string} value for RFC")
    public void getTheValueForRFC(String arg0) {
        value= response.jsonPath().get(arg0).toString();
        payloadVal="{\"PURCHASEORDER\":"+value+"}";
    }

    @Given("Base Url is known to connect with direct connection connection and has {string} payload {string} for RFC execution and autocommit is {string}")
    public void baseUrlIsKnownToConnectWithDirectConnectionConnectionAndHasPayloadForRFCExecutionAndAutocommitIs(String arg0, String arg1, String arg2) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeader();
        headerMap.put("rfcName",arg0);
        headerMap.put("autocommit",arg2);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthString")).
                headers(headerMap).body(payload.BAPI_CUSTOMER_CREATEFROMDATA1);
    }

    @Given("Base Url is known to connect with loadbalancer connection connection and has {string} payload and autocommit {string} for RFC")
    public void baseUrlIsKnownToConnectWithLoadbalancerConnectionConnectionAndHasPayloadAndAutocommitForRFC(String arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("rfcName",arg0);
        headerMap.put("autocommit",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body(payload.BAPI_CUSTOMER_CREATEFROMDATA1);
    }

    @Then("Validate {string} has not null Value")
    public void validateHasNotNullValue(String key) {
        assertFalse(response.jsonPath().get(key).toString().matches(""));
    }

    @Then("Get the value of {string}")
    public void getTheValueOf(String arg0) {
        value= response.jsonPath().get(arg0).toString();
        payloadVal="{\"CUSTOMERNO\":"+value+"}";
    }

    @Given("Base Url is known to connect with loadbalancer connection connection and has {string} payload and autocommit {string} to verify auto commit for RFC")
    public void baseUrlIsKnownToConnectWithLoadbalancerConnectionConnectionAndHasPayloadAndAutocommitToVerifyAutoCommitForRFC(String arg0, String arg1) throws IOException {
        Map<String,String> headerMap = new HashMap<String,String >();
        headerMap=ConnectionHeader.trueConnectionHeaderLoad();
        headerMap.put("rfcName",arg0);
        headerMap.put("autocommit",arg1);
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(headerMap).body("{\"CUSTOMERNO\":\""+value+"\"}");
    }

    @Then("Verify {string} has value as null")
    public void verifyHasValueAsNull(String key) {
        assertTrue(response.jsonPath().get(key).toString().matches(""));

    }

    @Then("Verify {string} has same value")
    public void verifyHasSameValue(String key) {
        assertEquals(response.jsonPath().get(key).toString(),value);

    }
}
