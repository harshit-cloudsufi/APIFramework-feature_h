package sapadapter.stepDefinetions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import resources.APIResources;
import sapadapter.parameter.ConnectionHeader;
import sapadapter.utilities.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefLoadConnection extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    APIResources resourceAPI;
    JsonPath js;
    


    @Given("Base Url is known and headers are valid via load balancer")
    public void baseUrlIsKnownAndHeadersAreValidWithLoadBalancer() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " +
                Utils.getGlobalValue("encodedBaseAuthStringLoad")).
                headers(ConnectionHeader.trueConnectionHeaderLoad());
    }

    @When("user calls {string} with GET http request via load balancer")
    public void userCallsWithGETHttpRequestViaLoadBalancer(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource());
    }

    @Then("Load balancer API call got success with status code {int}")
    public void loadBalancerAPICallGotSuccessWithStatusCode(int int1) {
        assertEquals(int1,response.getStatusCode());
    }

    @Given("Base Url is known for load balancer")
    public void baseUrlIsKnownForLoadBalancer() throws IOException {
        res = given().spec(requestSpecification()).header("Authorization", "Basic " + Utils.getGlobalValue("encodedBaseAuthStringLoad"));

    }

    @Then("Primary mesaage is validated with {string} connection via load balancer")
    public void primaryMesaageIsValidatedWithConnectionViaLoadBalancer(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"primaryMessage"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @Then("Secondary mesaage is validated when {string} connection via load balancer")
    public void secondaryMesaageIsValidatedWhenConnectionViaLoadBalancer(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"secondaryMessage"), StringContains.containsString(Utils.getExceptionCode(message)));

    }

    @Then("Primary code is validated with {string} connection via load balancer")
    public void primaryCodeIsValidatedWithConnectionViaLoadBalancer(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"primaryCode"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @Then("Secondary code is validated with {string} connection via load balancer")
    public void secondaryCodeIsValidatedWithConnectionViaLoadBalancer(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"secondaryCode"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @When("Following parameters are inserted in {string} with GET request as header when mshost is not present connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenMshostIsNotPresentConnectionViaLoadBalancer(String resource) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when msserv is not present connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenMsservIsNotPresentConnectionViaLoadBalancer(String resource) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when group is not present connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenGroupIsNotPresentConnectionViaLoadBalancer(String resource) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when client is not present connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenClientIsNotPresentConnectionViaLoadBalancer(String resource) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header when mshost is (.+) and connection via load balancer$")
    public void following_parameters_are_inserted_in_something_with_get_request_as_header_when_mshost_is_and_connection_via_load_balancer(String resource, String mshost) throws Throwable {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),mshost)
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when wrong msshot is passed like {string} and connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenWrongMsshotIsPassedLikeAndConnectionViaLoadBalancer(String resource, String mshost) throws IOException { res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
            .header(Utils.getGlobalValue("mshost"),mshost)
            .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
            .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
            .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
            .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
            .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
            .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header when msserv is (.+) and connection via load balancer$")
    public void following_parameters_are_inserted_in_something_with_get_request_as_header_when_msserv_is_something_and_connection_via_load_balancer(String resource, String msserv) throws Throwable {

        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),msserv)
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when wrong msserv is passed like {string} and connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenWrongMsservIsPassedLikeAndConnectionViaLoadBalancer(String resource, String msserv) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),msserv)
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header when group is (.+) and connection via load balancer$")
    public void following_parameters_are_inserted_in_something_with_get_request_as_header_when_group_is_something_and_connection_via_load_balancer(String resource, String group) throws Throwable {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),group)
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header when r3name is (.+) and connection via load balancer$")
    public void following_parameters_are_inserted_in_something_with_get_request_as_header_when_r3name_is_and_connection_via_load_balancer(String resource, String r3name) throws Throwable {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("r3name"),r3name)
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when peak_limit is {string} and connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenPeak_limitIsAndConnectionViaLoadBalancer(String resource, String peak_limit) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),peak_limit)
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when pool_capacity is {string} and connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenPool_capacityIsAndConnectionViaLoadBalancer(String resource, String pool_capacity) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),pool_capacity);
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header when lang is (.+) and connection via load balancer$")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenLangIsAndConnectionViaLoadBalancer(String resource, String lang) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),lang)
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

    @When("Following parameters are inserted in {string} with GET request as header when wrong lang is passed like {string} and connection via load balancer")
    public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenWrongLangIsPassedLikeAndConnectionViaLoadBalancer(String resource, String lang) throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),lang)
                .header(Utils.getGlobalValue("mshost"),Utils.getGlobalValue("jco.client.mshost"))
                .header(Utils.getGlobalValue("msserv"),Utils.getGlobalValue("jco.client.msserv"))
                .header(Utils.getGlobalValue("r3name"),Utils.getGlobalValue("jco.client.r3name"))
                .header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
                .header(Utils.getGlobalValue("group"),Utils.getGlobalValue("jco.client.group"))
                .header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
                .header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
        String jsonAsString = response.asString();
        js=new JsonPath(jsonAsString);
    }

}
