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

import java.util.List;
import java.util.Map;

public class TestBase {

    protected static final ApiClient api = new ApiClient();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://market.petsfera.ru/";
        Configuration.baseUrl = "https://market.petsfera.ru/";
        Configuration.timeout = 30000;  // увеличил для удалённого запуска
        Configuration.pageLoadStrategy = "eager";

        String remoteUrl = System.getProperty("remoteUrl");
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            // Игнорируем SSL ошибки
            capabilities.setCapability("acceptInsecureCerts", true);

            // Дополнительные аргументы Chrome
            capabilities.setCapability("goog:chromeOptions", Map.of(
                    "args", List.of(
                            "--ignore-certificate-errors",
                            "--ignore-ssl-errors",
                            "--allow-insecure-localhost"
                    )
            ));

            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                    .screenshots(true)
                    .savePageSource(true));
        }
    }

    /* @BeforeEach
    void setUp2() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
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