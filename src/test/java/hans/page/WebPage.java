package hans.page;


import hans.helper.Endpoint;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static hans.helper.Utility.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String globalUsername, globalMenu, globalItemName;
    Integer globalIdx;

    By menu (String menu) {
        globalMenu = menu;
        return By.xpath("//a[contains(text(), '" + menu + "')]");
    }
    By modal (String modal) {
        if(modal.equals("Contact")){
            modal = "New message";
        }
        return By.xpath("//h5[contains(text(), '" + modal + "')]");
    }
    By inputUsernameLogin = By.id("loginusername");
    By inputPasswordLogin = By.id("loginpassword");
    By inputUsernameSignup = By.id("sign-username");
    By inputPasswordSignup = By.id("sign-password");
    By inputEmailContact = By.id("recipient-email");
    By inputNameContact = By.id("recipient-name");
    By inputMessageContact = By.id("message-text");
    By button (String button) {
        if(button.equals("Contact")){
            button = "Send message";
        }
        return By.xpath("//button[contains(text(), '" + button + "')]");
    }
    By username = By.id("nameofuser");
    By video = By.id("example-video_html5_api");
    By category (String category){
        switch (category) {
            case "Phones":
                globalIdx = generatePhonesItemIndex();
                break;
            case "Laptops":
                globalIdx = generateLaptopsItemIndex();
                break;
            case "Monitors":
                globalIdx = generateMonitorsItemIndex();
                break;
            default:
                System.out.println("Wrong category");
        }
        return By.xpath("//a[contains(text(),'" + category + "')]");
    }
    By item(Integer idx) {
        return By.xpath("//a[@href='prod.html?idp_=" + idx + "']");
    }

    By addToCartButton = By.xpath("//a[contains(text(), 'Add to cart')]");
    By itemName = By.xpath("//h2[@class='name']");
    By itemCartList = By.xpath("(//td)[2]");

    public void openBrowser() {
        driver.get("https://www.demoblaze.com/");
    }

    public void userClickMenu(String menu) {
        driver.findElement(menu(menu)).click();
    }

    public void userClickCategory(String category) {
        driver.findElement(category(category)).click();
    }

    public void userClickItem() {
        wait.until(ExpectedConditions.urlToBe("https://www.demoblaze.com/#"));
        wait.until(ExpectedConditions.elementToBeClickable(item(globalIdx)));
        driver.findElement(item(globalIdx)).click();
    }

    public void userSeeModal(String modal) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal(modal)));
        assertTrue(driver.findElement(modal(modal)).isDisplayed());
    }

    public void inputUsername(String username) {
        if(globalMenu.equals("Log in")){
            wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsernameLogin));
            driver.findElement(inputUsernameLogin).sendKeys(username);
            globalUsername = username;
        } else if (globalMenu.equals("Sign up")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsernameSignup));
            driver.findElement(inputUsernameSignup).sendKeys(username);
            globalUsername = username;
        }
    }

    public void inputNewUsername() {
        String username = generateRandomName();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsernameSignup));
        driver.findElement(inputUsernameSignup).sendKeys(username);
        globalUsername = username;
    }

    public void inputPassword(String password) {
        if(globalMenu.equals("Log in")){
            driver.findElement(inputPasswordLogin).sendKeys(password);
        } else if (globalMenu.equals("Sign up")) {
            driver.findElement(inputPasswordSignup).sendKeys(password);
        }
    }

    public void inputContactEmailWith(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmailContact));
        driver.findElement(inputEmailContact).sendKeys(email);
    }

    public void inputContactNameWith(String name) {
        driver.findElement(inputNameContact).sendKeys(name);
    }

    public void inputContactMessageWith(String message) {
        driver.findElement(inputMessageContact).sendKeys(message);
    }

    public void clickButton(String button) {
        driver.findElement(button(button)).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void playVideo() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].play();",  driver.findElement(video));
        Thread.sleep(5000);
        Boolean isPlaying = (Boolean) js.executeScript(
                "return arguments[0].currentTime > 0 && !arguments[0].paused && !arguments[0].ended && arguments[0].readyState > 2;",
                driver.findElement(video));
        assertTrue(isPlaying);
    }

    public void validationUserIsLoggedIn() {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOfElementLocated(menu("Log in")),
                ExpectedConditions.visibilityOfElementLocated(menu("Log out")),
                ExpectedConditions.visibilityOfElementLocated(username)
        ));
        assertFalse(driver.findElement(menu("Log in")).isDisplayed());
        assertTrue(driver.findElement(menu("Log out")).isDisplayed());
        assertThat(driver.findElement(username).getText()).isEqualTo("Welcome " + globalUsername);
    }

    public void validationUserIsSignedUp() {
        wait.until(ExpectedConditions.alertIsPresent());
        assertThat(driver.switchTo().alert().getText()).isEqualTo("Sign up successful.");
        driver.switchTo().alert().accept();
    }

    public void validationUserIsOnProductContentPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        globalItemName = driver.findElement(itemName).getText();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.demoblaze.com/prod.html?idp_=" + globalIdx);
    }

    public void validationItemIsOnTheCartList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemCartList));
        assertThat(driver.findElement(itemCartList).getText()).isEqualTo(globalItemName);
    }

    public void validationUserIsLoggedOut() {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOfElementLocated(menu("Log out")),
                ExpectedConditions.visibilityOfElementLocated(menu("Log in")),
                ExpectedConditions.visibilityOfElementLocated(menu("Sign up"))
        ));
        assertFalse(driver.findElement(menu("Log out")).isDisplayed());
        assertTrue(driver.findElement(menu("Log in")).isDisplayed());
        assertTrue(driver.findElement(menu("Sign up")).isDisplayed());
    }

    public void validationUserGetAlert(String alert) {
        wait.until(ExpectedConditions.alertIsPresent());
        assertThat(driver.switchTo().alert().getText()).isEqualTo(alert);
        driver.switchTo().alert().accept();
    }

    public void validationUserIsOnPage(String url) {
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.demoblaze.com/" + url + ".html");
    }

}
