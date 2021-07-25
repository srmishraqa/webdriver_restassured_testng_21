package restassuredTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class TestGETAPI {

    String accessToken = "d7938d0a9e5dbd50ce0f9b2442ea92bc43554e7a515381480be02ec70ada37b0";

    @Test
    public void getCall() throws ParseException {
        //passing rest assured headers as MAP
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("authorization", "Bearer " + accessToken);

        Response response = given().
                baseUri("https://gorest.co.in").
                basePath("public/v1/users").
                headers(headerMap).
                get();

        // Convert String response to JSON
        String result = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        System.out.println(json);

        Assert.assertEquals(response.getStatusCode(), 200, "Status Mismatched");

        // Converted Response of String type to JSON Object type
        // And then tried to match key , as we find values by Key, the return type is Object
        // So we have to convert it to string to do the assertions
        JsonPath jsonPath = new JsonPath(response.asString());
        Object ob = jsonPath.get("data[1].name");
        String name = ob.toString().toLowerCase();
        System.out.println(name);
        Assert.assertTrue(name.contains("rep"));

    }
}
