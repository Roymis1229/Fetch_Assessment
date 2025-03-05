package org.fetch.utilities;

import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import static org.fetch.utilities.APIClient.getGeoCoordinates;

public class GeoLocator {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -cp target/classes org.fetch.utilities.GeoLocator \"City, State\" \"ZipCode\"");
            return;
        }

        List<String> locations = Arrays.asList(args);
        List<Response> responses = getGeoCoordinates(locations);

        for (int i = 0; i < responses.size(); i++) {
            Response response = responses.get(i);
            if (response.getStatusCode() == 200 && !response.jsonPath().getList("").isEmpty()) {
                double lat = response.jsonPath().getDouble("[0].lat");
                double lon = response.jsonPath().getDouble("[0].lon");
                String name = response.jsonPath().getString("[0].name");
                String state = response.jsonPath().getString("[0].state");

                System.out.println("Location: " + locations.get(i));
                System.out.println("Latitude: " + lat + ", Longitude: " + lon);
                System.out.println("City: " + name + ", State: " + state);
                System.out.println("----------------------------------");
            } else {
                System.out.println("Error: Could not retrieve data for " + locations.get(i));
            }
        }
    }
}
