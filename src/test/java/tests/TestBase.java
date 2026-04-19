package tests;

import api.example.ApiClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    protected static final ApiClient api = new ApiClient();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://market.petsfera.ru/";
        Configuration.baseUrl = "https://market.petsfera.ru/";
        Configuration.timeout = 30000;  // увеличил для удалённого запуска
        Configuration.pageLoadStrategy = "eager";

        // Диагностика
        String remoteUrl = System.getProperty("remoteUrl");
        System.out.println("=== DIAGNOSTIC: remoteUrl = '" + remoteUrl + "' ===");
        System.out.println("=== DIAGNOSTIC: Configuration.baseUrl = '" + Configuration.baseUrl + "' ===");

        if (remoteUrl != null && !remoteUrl.isEmpty() && !remoteUrl.equals("null")) {
            Configuration.remote = remoteUrl;
            Configuration.browser = "chrome";
            Configuration.browserVersion = "128.0";
            System.out.println("=== Remote mode ENABLED: " + Configuration.remote + " ===");
        } else {
            System.out.println("=== Remote mode DISABLED, running locally ===");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setUp2() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
   /* @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
    @BeforeEach
    void setUp2() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }*/

    @AfterEach
    void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
            Selenide.closeWebDriver();
        }
    }