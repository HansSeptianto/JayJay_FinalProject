package hans.stepdef;

import hans.page.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApiStep {
    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare valid url for {string}")
    public void prepareValidUrlFor(String url) {
        apiPage.prepareURL(url);
    }

    @And("hit api get user by id")
    public void hitApiGetUserById() {
        apiPage.hitApiGetUserById();
    }

    @Then("validation status code is equal to {int}")
    public void validationStatusCodeIsEqualTo(int status) {
        apiPage.validationStatusCode(status);
    }

    @Then("validation response body get user data by id")
    public void validationResponseBodyGetUserDataById() {
        apiPage.validationResponseBodyGetUserDataById();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyPostCreateNewUser();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @And("hit api update user data")
    public void hitApiUpdateUserData() {
        apiPage.hitApiUpdateUserData();
    }

    @Then("validation response body update user data")
    public void validationResponseBodyUpdateUserData() {
        apiPage.validationResponseBodyUpdateUserData();
    }

    @And("hit api post create new user with invalid email")
    public void hitApiPostCreateNewUserWithInvalidEmail() {
        apiPage.hitApiPostCreateNewUserWithInvalidEmail();
    }

    @Then("validation response body post create new user with invalid email")
    public void validationResponseBodyPostCreateNewUserWithInvalidEmail() {
        apiPage.validationResponseBodyPostCreateNewUserWithInvalidEmail();
    }

    @And("hit api delete user with invalid id")
    public void hitApiDeleteUserWithInvalidId() {
        apiPage.hitApiDeleteUserWithInvalidId();
    }

    @Then("validation response body delete user with invalid id")
    public void validationResponseBodyDeleteUserWithInvalidId() {
        apiPage.validationResponseBodyWithInvalidId();
    }

    @And("hit api update user data with invalid id")
    public void hitApiUpdateUserDataWithInvalidId() {
        apiPage.hitApiUpdateUserDataWithInvalidId();
    }

    @Then("validation response body update user data with invalid id")
    public void validationResponseBodyUpdateUserDataWithInvalidId() {
        apiPage.validationResponseBodyWithInvalidId();
    }

    @And("hit api get list of tags")
    public void hitApiGetListOfTags() {
        apiPage.hitApiGetListOfTags();
    }

    @Then("validation response body get list of tags")
    public void validationResponseBodyGetListOfTags() {
        apiPage.validationResponseBodyGetListOfTags();
    }

    @Then("validation response body delete user")
    public void validationResponseBodyDeleteUser() {
        apiPage.validationResponseBodyDeleteUser();
    }
}
