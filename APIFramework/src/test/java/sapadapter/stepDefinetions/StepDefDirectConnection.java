package sapadapter.stepDefinetions;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import static org.junit.Assert.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import sapadapter.parameter.ConnectionHeader;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import sapadapter.utilities.Utils;

public class StepDefDirectConnection extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	APIResources resourceAPI;

	@Given("Base Url is known and headers are valid")
	public void add_Place_Payload_with() throws IOException {
		res = given().spec(requestSpecification()).header("Authorization", "Basic " +
				Utils.getGlobalValue("encodedBaseAuthString")).
				headers(ConnectionHeader.trueConnectionHeader());
	}

	@When("user calls {string} with GET http request")
	public void user_calls_with_http_request(String resource) {
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource());
	}

	@Then("API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(int int1) {
		assertEquals(int1,response.getStatusCode());
	}

	@Given("Base Url is known and password is invalid")
	public void base_Url_is_known_and_password_is_invalid() throws IOException {
		res = given().spec(requestSpecification()).header("Authorization", "Basic " + "aWRhZG1pbjppZGVzMTaa").
				headers(ConnectionHeader.trueConnectionHeader());
	}

	@When("user calls {string} with GET http request and capture response")
	public void user_calls_with_http_request_and_capture_response(String resource) {
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@Then("API call got the response with status code {int}")
	public void the_API_call_got_the_exception_with_status_code(int int1) {
		assertEquals(int1,response.getStatusCode());
	}
	@And("Primary mesaage is validated")
	public void the_primary_mesaage_is_validated() throws IOException {
		String primaryMessage=getJsonPath(response,"primaryMessage");
		assertEquals(primaryMessage,Utils.getExceptionCode("authPrimaryMessage"));
	}

	@And("Secondary mesaage is validated")
	public void the_secondary_mesaage_is_validated() throws IOException {
		assertEquals(Utils.getExceptionCode("authSecondaryMessage"),getJsonPath(response,"secondaryMessage"));
	}

	@And("Primary code is validated")
	public void and_the_primary_code_is_validated() throws IOException {
		assertEquals(Utils.getExceptionCode("authPrimaryCode"),getJsonPath(response,"primaryCode"));
	}

	@And("Secondary code is validated")
	public void and_the_Secondary_code_is_validated() throws  IOException {
		assertEquals(Utils.getExceptionCode("authSecondaryCode"),getJsonPath(response,"secondaryCode"));
	}

	@Given("Base Url is known")
	public void base_Url_is_known() throws IOException {
		res = given().spec(requestSpecification()).header("Authorization", "Basic " + Utils.getGlobalValue("encodedBaseAuthString"));
	}

	@When("Following parameters are inserted in {string} with GET request as header when client is not present")
	public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenClientIsNotPresent(String resource) throws IOException {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("jco.destination.pool_capacity"),Utils.getGlobalValue("pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("Following parameters are inserted in {string} with GET request as header when ashost is not present")
	public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenAshostIsNotPresent(String resource) throws IOException {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("jco.destination.pool_capacity"),Utils.getGlobalValue("pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("Following parameters are inserted in {string} with GET request as header when sysnr is not present")
	public void followingParametersAreInsertedInWithGETRequestAsHeaderWhenSysnrIsNotPresent(String resource) throws IOException {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("jco.destination.pool_capacity"),Utils.getGlobalValue("pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@Then("Primary mesaage is validated with {string}")
	public void primaryMesaageIsValidatedWhenParameterIsMissing(String message) throws IOException {
		Assert.assertThat(getJsonPath(response,"primaryMessage"),StringContains.containsString(Utils.getExceptionCode(message)));
	}

	@Then("Secondary mesaage is validated when {string}")
	public void secondaryMesaageIsValidatedWhenParameterIsMissing(String key) throws IOException {
		Assert.assertThat(getJsonPath(response,"secondaryMessage"),StringContains.containsString(Utils.getExceptionCode(key)));
	}

	@Then("Primary code is validated with {string}")
	public void primaryCodeIsValidatedWhenParameterIsMissing(String key) throws IOException {
		assertEquals(getJsonPath(response,"primaryCode"),Utils.getExceptionCode(key));
	}

	@Then("Secondary code is validated with {string}")
	public void secondaryCodeIsValidatedWhenParameterIsMissing(String key) throws IOException {
		assertEquals(getJsonPath(response,"secondaryCode"),Utils.getExceptionCode(key));
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header and client is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenClient(String resource, String clientValue) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),clientValue)
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();

	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header and sysnr is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenSysnrIs(String resource, String sysnr) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),sysnr)
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header and ashost is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenAshost(String resource, String ashost) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),ashost)
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header and lang is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenLang(String resource, String lang) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),lang)
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header and peak_limit is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenpeaklimit(String resource, String peakLimit) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),peakLimit)
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as header and pool_capacity is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenpoolcapacity(String resource, String poolCapacity) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),poolCapacity);
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \\\"([^\\\"]*)\\\" with GET request as a header and client is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenClientIsInvalid(String resource, String clientValue) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),clientValue)
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \\\"([^\\\"]*)\\\" with GET request as a header and sysnr is (.+)$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenSysnrIsInvalid(String resource, String sysnr) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),sysnr)
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as a header and lang is \"([^\"]*)\"$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenLngIsInvalid(String resource, String lang) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),lang)
				.header(Utils.getGlobalValue("ashost"),Utils.getGlobalValue("jco.client.ashost"))
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}

	@When("^Following parameters are inserted in \"([^\"]*)\" with GET request as a header and ashost is \"([^\"]*)\"$")
	public void followingParametersAreInsertedInSomethingWithGetRequestAsHeaderWhenAshostgIsInvalid(String resource, String ashost) throws Throwable {
		res=res.header(Utils.getGlobalValue("lang"),Utils.getGlobalValue("jco.client.lang"))
				.header(Utils.getGlobalValue("ashost"),ashost)
				.header(Utils.getGlobalValue("sysnr"),Utils.getGlobalValue("jco.client.sysnr"))
				.header(Utils.getGlobalValue("client"),Utils.getGlobalValue("jco.client.client"))
				.header(Utils.getGlobalValue("peak_limit"),Utils.getGlobalValue("jco.destination.peak_limit"))
				.header(Utils.getGlobalValue("pool_capacity"),Utils.getGlobalValue("jco.destination.pool_capacity"));
		resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().get(resourceAPI.getResource()).then().extract().response();
	}
}