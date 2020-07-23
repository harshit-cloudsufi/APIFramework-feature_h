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
import sapadapter.payload.BapiExecutionPayload;
import sapadapter.utilities.Utils;

import java.io.IOException;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

public class stepDefSNC extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    APIResources resourceAPI;
    JsonPath js;
    @Given("Base Url is known and headers are valid for connection using SNC")
    public void base_Url_is_known_and_headers_are_valid_for_connection_using_SNC() throws IOException {
        res = given().spec(requestSpecification()).
                headers(ConnectionHeader.trueConnectionSNC());
    }

    @When("user calls {string} with GET http request for connection using  SNC")
    public void user_calls_with_GET_http_request_for_connection_using_SNC(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource());
    }

    @Then("SNC connection API call got success with status code {int}")
    public void snc_connection_API_call_got_success_with_status_code(int int1) {
        assertEquals(int1, response.getStatusCode());
    }

    @Given("Base Url {string} is known for SNC connection")
    public void baseUrlIsKnownForSNCConnection(String resource) throws IOException {
        res = given().spec(requestSpecification());
        resourceAPI = APIResources.valueOf(resource);
    }

    @Then("Primary mesaage is validated with {string} connection for SNC connection")
    public void primaryMesaageIsValidatedWithConnectionForSNCConnection(String message) throws IOException {
        System.out.println(getJsonPath(response,"primaryMessage"));
        System.out.println(StringContains.containsString(Utils.getExceptionCode(message)));
        Assert.assertThat(getJsonPath(response,"primaryMessage"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @Then("Secondary mesaage is validated when {string} connection for SNC connection")
    public void secondaryMesaageIsValidatedWhenConnectionForSNCConnection(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"secondaryMessage"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @When("Following parameters are inserted with GET request as header when client is not present connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenClientIsNotPresentConnection() throws IOException {
        res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @Then("Primary code is validated with {string} connection for SNC connection")
    public void primaryCodeIsValidatedWithConnectionForSNCConnection(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"primaryCode"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @Then("Secondary code is validated with {string} connection for SNC connection")
    public void secondaryCodeIsValidatedWithConnectionForSNCConnection(String message) throws IOException {
        Assert.assertThat(getJsonPath(response,"secondaryCode"), StringContains.containsString(Utils.getExceptionCode(message)));
    }

    @When("Following parameters are inserted with GET request as header when Sysnr is not present connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSysnrIsNotPresentConnection() throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when ashost is not present connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenAshostIsNotPresentConnection() throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when snc_partnername is not present connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSnc_partnernameIsNotPresentConnection() throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when snc_lib is not present connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSnc_libIsNotPresentConnection() throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when client is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenClientIsForSNCConnection(String client) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),client)
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when lang is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenLangIsForSNCConnection(String lang) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),lang)
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when Sysnr is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSysnrIsForSNCConnection(String Sysnr) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Sysnr)
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when Ashost is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenAshostIsForSNCConnection(String ashostSNC) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),ashostSNC)
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when SNC_Mode is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSNC_ModeIsForSNCConnection(String snc_mode) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),snc_mode)
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when snc_partnername is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSnc_partnernameIsForSNCConnection(String snc_partnername) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),snc_partnername)
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when snc_myname is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSnc_mynameIsForSNCConnection(String snc_myname) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),snc_myname)
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when snc_qop is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSnc_qopIsForSNCConnection(String snc_qop) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),snc_qop)
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),Utils.getGlobalValue("jco.client.snc_lib"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when snc_lib is {string} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenSnc_libIsForSNCConnection(String snc_lib) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.clientSNC"))
                .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
                .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
                .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
                .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
                .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
                .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
                .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"))
                .header(Utils.getGlobalValue("snc_lib"),snc_lib);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }

    @When("Following parameters are inserted with GET request as header when client is int {int} for SNC connection")
    public void followingParametersAreInsertedWithGETRequestAsHeaderWhenClientIsForSNCConnection(int client) throws IOException {
        res=res.header(Utils.getGlobalValue("client"),"001")
            .header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
            .header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
            .header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashostSNC"))
            .header(Utils.getGlobalValue("snc_mode"),Utils.getGlobalValue("jco.client.snc_mode"))
            .header(Utils.getGlobalValue("snc_partnername"),Utils.getGlobalValue("jco.client.snc_partnername"))
            .header(Utils.getGlobalValue("snc_qop"),Utils.getGlobalValue("jco.client.snc_qop"))
            .header(Utils.getGlobalValue("snc_myname"),Utils.getGlobalValue("jco.client.snc_myname"));
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().get(resourceAPI.getResource()).then().extract().response();
    }


    @When("user calls the bapi execution by {string} with GET http request ")
    public void userCallsTheBapiExecutionByWithGETHttpRequestUsingPayload(String resource) {
        resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        response = res.when().post(resourceAPI.getResource()).then().extract().response();
    }

}
