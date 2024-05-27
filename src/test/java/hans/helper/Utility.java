package hans.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class Utility {
    public static WebDriver driver;

    public static File getJsonSchemaFile(String JSONFile) {
        return new File ("src/test/java/hans/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomName() {
        String name = "";
        String temp = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        name = temp.substring(0, 1).toUpperCase() + temp.substring(1);
        return name;
    }

    public static String generateRandomEmail() {
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

    public static Integer generatePhonesItemIndex() {
        Random rand = new Random();
        Integer idx;
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};

        idx = array[rand.nextInt(array.length)];
        return idx;
    }

    public static Integer generateLaptopsItemIndex() {
        Random rand = new Random();
        Integer idx;
        Integer[] array = {8, 9, 11, 12, 13, 15};

        idx = array[rand.nextInt(array.length)];
        return idx;
    }

    public static Integer generateMonitorsItemIndex() {
        Random rand = new Random();
        Integer idx;
        Integer[] array = {10, 14};

        idx = array[rand.nextInt(array.length)];
        return idx;
    }

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void closeDriver() {
        driver.quit();
    }
}
