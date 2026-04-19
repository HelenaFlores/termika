package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.baseURI;

public class HomePage {

    private final SelenideElement profileButton = $("a[href='/account/profile']");

    public HomePage openPage() {
        open(baseUrl);

        return this;
    }

    public HomePage goToProfile() {
        profileButton.click();

        return this;
    }
}
