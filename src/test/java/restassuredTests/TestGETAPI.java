package restassuredTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class TestGETAPI {

    String accessToken = "d7938d0a9e5dbd50ce0f9b2442ea92bc43554e7a515381480be02ec70ada37b0";

    @Test
    public void getCall() throws ParseException {
        //passing rest assured headers as MAP
        Map<String, Object> headerMap = new HashMap<String, Object>();
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

        JsonPath jsonPath = new JsonPath(response.asString());
        Object ob = jsonPath.get("data[1].name");
        String name = ob.toString().toLowerCase();
        System.out.println(name);
        Assert.assertTrue(name.contains("rep"));

    }
}
