package org.fetch.utilities;

import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class APIClient {

    public static List<Response> getGeoCoordinates(List<String> locations) {
        List<Response> responses = new ArrayList<>();
        for (String location : locations) {
            responses.add(fetchGeoData("q", location));
        }
        return responses;
    }

    private static Response fetchGeoData(String param, String value) {
        return given()
                .queryParam(param, value)
                .queryParam("appid", ConfigurationReader.getProperty("apiKey"))
                .when()
                .get(ConfigurationReader.getProperty("fetch.baseURI") + "/geo/1.0/direct")
                .then()
                .extract()
                .response();
    }

}