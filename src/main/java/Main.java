import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Main {
    
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "132.0");
        chromeOptions.setCapability("platformName", "Linux");
// Showing a test name instead of the session id in the Grid UI
        chromeOptions.setCapability("se:name", "My simple test");
// Other type of metadata can be seen in the Grid UI by clicking on the
        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        // Using Actions class to simulate the Enter key press
        new Actions(driver).sendKeys("test").sendKeys(Keys.ENTER).perform();
        Thread.sleep(500);
        driver.quit();

    }

}

