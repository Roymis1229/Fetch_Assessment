Feature: Fetch Geolocation Data

  @geolocation
  Scenario Outline: Get coordinates for different cities
    Given I have a city "<city>"
    When I request the geolocation API
    And the response should return status code 200
    Then the response should contain valid latitude and longitude

    Examples:
      | city          |
      | Los Angeles  |
      | New York     |
      | Chicago      |
      | San Francisco |
