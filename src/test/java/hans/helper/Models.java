package hans.helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Models {
    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "66444c30b5ced22dd0ab26a5");
    }

    public static Response getUserById(String endpoint, String id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + id;
        return request.when().get(finalEndpoint);
    }

    public static Response getListOfTags(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateNewUser(String endpoint) {
        String firstName = Utility.generateRandomName();
        String lastName = Utility.generateRandomName();
        String email = Utility.generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response postCreateNewUserWithInvalidEmail(String endpoint) {
        String firstName = Utility.generateRandomName();
        String lastName = Utility.generateRandomName();
        String email = "test";

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + id;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String id) {
        String firstName = Utility.generateRandomName();
        String lastName = Utility.generateRandomName();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);


        setupHeaders();
        String finalEndpoint = endpoint + "/" + id;
        return request.body(payload.toString()).when().put(finalEndpoint);
    }

}
