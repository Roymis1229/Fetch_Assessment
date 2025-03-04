package org.fetch.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.fetch.utilities.APIClient;

import static org.junit.Assert.*;

public class ApiTestsSteps {
    private String city;
    private Response response;

    @Given("I have a city {string}")
    public void i_have_a_city(String city) {
        this.city = city;
    }

    @When("I request the geolocation API")
    public void i_request_the_geolocation_api() {
        response = APIClient.getGeoCoordinates(java.util.List.of(city)).get(0);
    }

    @Then("the response should return status code {int}")
    public void the_response_should_return_status_code(int expectedStatusCode) {
        assertEquals("Unexpected status code!", expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain valid latitude and longitude")
    public void the_response_should_contain_valid_latitude_and_longitude() {
        assertEquals("Expected HTTP 200", 200, response.getStatusCode());
        assertNotNull("Latitude is missing", response.jsonPath().getDouble("[0].lat"));
        assertNotNull("Longitude is missing", response.jsonPath().getDouble("[0].lon"));
    }
}