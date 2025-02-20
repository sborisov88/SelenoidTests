import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

public class Main {
    
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "132.0");
        chromeOptions.setCapability("platformName", "Linux");
        chromeOptions.setCapability("se:name", "My simple test");
        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
        chromeOptions.setCapability("se:recordVideo", true);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        // Thread.sleep(2000);
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        // Using Actions class to simulate the Enter key press
        new Actions(driver).sendKeys("test").sendKeys(Keys.ENTER).perform();
        // Thread.sleep(2000);
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        System.out.println("Session ID: " + sessionId);
        driver.quit();
        // Download video from Selenoid
        // String videoUrl = "http://localhost:4444/video/" + sessionId + ".mp4";
        // try (InputStream in = new URL(videoUrl).openStream()) {
        //     Files.copy(in, Paths.get("video_" + sessionId + ".mp4"), StandardCopyOption.REPLACE_EXISTING);
        // }

    }

}

