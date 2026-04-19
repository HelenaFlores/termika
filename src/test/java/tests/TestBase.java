package tests;

import api.example.ApiClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected static final ApiClient api = new ApiClient();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://market.petsfera.ru/";
        Configuration.baseUrl = "https://market.petsfera.ru/";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = System.getProperty("remoteUrl");
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}

/*@BeforeAll
static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.timeout = 10000;
    Configuration.pageLoadStrategy = "eager";
}*/