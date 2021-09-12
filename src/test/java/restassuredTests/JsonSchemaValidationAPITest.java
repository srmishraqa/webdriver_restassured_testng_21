package restassuredTests;

import  io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class JsonSchemaValidationAPITest {

    @Test
    public void testResponse() throws ParseException {
        Response response = given().
                baseUri("https://api.spacexdata.com").
                basePath("/v3").
                get();
        System.out.println("Actual Response Code : " + response.getStatusCode());
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Response Code Mismatched");
    }

    @Test
    public void validateJsonSchema() {
        given().baseUri("https://api.spacexdata.com").
                basePath("/v3").
                get().then().assertThat().
                body(matchesJsonSchemaInClasspath("spacexHome.json"));
    }
}
