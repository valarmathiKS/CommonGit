package Acadamy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver = new ChromeDriver();

    public WebDriver initialiseBrowser() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/valar/IdeaProjects/E2EProject1/src/main/data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();

        } else if (browserName.equals("fireFox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
            driver = new FirefoxDriver();

        } else if (browserName.equals("IE")) {
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}


