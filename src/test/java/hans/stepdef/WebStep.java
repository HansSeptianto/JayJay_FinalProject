package hans.stepdef;

import hans.page.WebPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebStep {
    WebPage webPage;

    public WebStep() {
        this.webPage = new WebPage();
    }

    @Given("user is on home page")
    public void userIsOnHomePage() {
        webPage.openBrowser();
    }

    @When("user click {string} menu")
    public void userClickMenu(String menu) {
        webPage.userClickMenu(menu);
    }

    @Then("user see {string} modal")
    public void userSeeModal(String modal) {
        webPage.userSeeModal(modal);
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        webPage.inputUsername(username);
    }

    @And("user input username with new username")
    public void userInputUsernameWithNewUsername() {
        webPage.inputNewUsername();
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        webPage.inputPassword(password);
    }

    @When("user click {string} button")
    public void userClickButton(String button) {
        webPage.clickButton(button);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        webPage.validationUserIsLoggedIn();
    }

    @Then("user is signed up")
    public void userIsSignedUp() {
        webPage.validationUserIsSignedUp();
    }

    @Then("user get alert {string}")
    public void userGetAlert(String alert) {
        webPage.validationUserGetAlert(alert);
    }


    @Then("user is on {string} page")
    public void userIsOnPage(String url) {
        webPage.validationUserIsOnPage(url);
    }

    @And("user input contact email with {string}")
    public void userInputContactEmailWith(String email) {
        webPage.inputContactEmailWith(email);
    }

    @And("user input contact name with {string}")
    public void userInputContactNameWith(String name) {
        webPage.inputContactNameWith(name);
    }

    @And("user input contact message with {string}")
    public void userInputContactMessageWith(String message) {
        webPage.inputContactMessageWith(message);
    }

    @And("user play the video")
    public void userPlayTheVideo() throws InterruptedException {
        webPage.playVideo();
    }

    @Then("user is logged out")
    public void userIsLoggedOut() {
        webPage.validationUserIsLoggedOut();
    }

    @When("user click {string} category")
    public void userClickCategory(String category) {
        webPage.userClickCategory(category);
    }

    @And("user click item")
    public void userClickItem() {
        webPage.userClickItem();
    }

    @Then("user is on product content page")
    public void userIsOnProductContentPage() {
        webPage.validationUserIsOnProductContentPage();
    }

    @When("user click Add to cart button")
    public void userClickAddToCartButton() {
        webPage.clickAddToCartButton();
    }

    @And("validation item is on the cart list")
    public void validationItemIsOnTheCartList() {
        webPage.validationItemIsOnTheCartList();
    }

}


