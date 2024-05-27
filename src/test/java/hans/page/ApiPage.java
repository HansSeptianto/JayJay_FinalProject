package hans.page;

import hans.helper.Endpoint;
import hans.helper.Models;
import hans.helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiPage {
    String setURL, global_id;
    Response res;

    public void prepareURL(String url) {
        switch (url) {
            case "GET_USER_BY_ID":
                setURL = Endpoint.GET_USER_BY_ID;
                break;
            case "CREATE_USER":
                setURL = Endpoint.CREATE_USER;
                break;
            case "UPDATE_USER":
                setURL = Endpoint.UPDATE_USER;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
                break;
            case "GET_LIST_TAGS":
                setURL = Endpoint.GET_LIST_TAGS;
                break;
            default:
                System.out.println("Input the right url");
        }
    }

    public void hitApiGetUserById() {
        res = Models.getUserById(setURL, global_id);
    }

    public void hitApiGetListOfTags() {
        res = Models.getListOfTags(setURL);
    }

    public void hitApiPostCreateNewUser() {
        res = Models.postCreateNewUser(setURL);
    }

    public void hitApiPostCreateNewUserWithInvalidEmail() {
        res = Models.postCreateNewUserWithInvalidEmail(setURL);
    }

    public void hitApiDeleteUser() {
        res = Models.deleteUser(setURL, global_id);
    }

    public void hitApiDeleteUserWithInvalidId() {
        res = Models.deleteUser(setURL, "invalid_id");
    }

    public void hitApiUpdateUserData() {
        res = Models.updateUser(setURL, global_id);
    }

    public void hitApiUpdateUserDataWithInvalidId() {
        res = Models.updateUser(setURL, "invalid_id");
    }

    public void validationStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetUserDataById() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();
    }

    public void validationResponseBodyGetListOfTags() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        List<String> data = jsonPathEvaluator.getList("data");

        assertThat(data).isNotNull();
    }

    public void validationResponseBodyPostCreateNewUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();

        global_id = id;
    }

    public void validationResponseBodyPostCreateNewUserWithInvalidEmail() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String error = jsonPathEvaluator.get("error");
        String email = jsonPathEvaluator.get("data.email");

        assertThat(error).isEqualTo("BODY_NOT_VALID");
        assertThat(email).isEqualTo("Path `email` is invalid (test).");
    }

    public void validationResponseBodyWithInvalidId() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String error = jsonPathEvaluator.get("error");

        assertThat(error).isEqualTo("PARAMS_NOT_VALID");
    }

    public void validationResponseBodyDeleteUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");

        assertThat(id).isEqualTo(global_id);
    }

    public void validationResponseBodyUpdateUserData() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();
    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = Utility.getJsonSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
