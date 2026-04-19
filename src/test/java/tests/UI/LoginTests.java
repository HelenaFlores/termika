/*package tests.UI;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;


public class LoginTests extends TestBase {
    private LoginPage loginPage;


    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        loginPage.openPage();
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    @CsvFileSource(resources = "/test_data/authorizationWithAllFilledFieldsTest.csv")
    @ParameterizedTest(name = "Авторизация с верно заполненнным логином {0} и паролем {1}")
    @Tag("SMOUK")
    void authorizationWithAllFilledFieldsTest(String login, String password) {

        loginPage
                .setUserName(login)
                .setPasswordUser(password)
                .loginButtonClick()
                .getLoginUserPage().shouldHave(text(login));

        loginPage.getLogoutButton().isEnabled();
     //   loginPage.logoutButtonClick();
    }

    @CsvSource(value = {
            //    "@QaZLf2SMExVKJr",  баг
            //  "@qaZLf2SMExVKJR",  баг
            "@QaZLf2SMExVKJR0",
            "@QaZLf2SMExVKJR1",
            "@QaZLf2SMExVKJR2"
    })
    @ParameterizedTest(name = "Авторизация с неверно заполненнным паролем {0}")
    @Tag("NEGATIVE")
    void authorizedWithIncorrectPasswordTest(String password) {

        loginPage
                .setUserName("s.test")
                .setPasswordUser(password)
                .loginButtonClick()
                .getAuthorizedError().shouldHave(text("Invalid username or password!"));
    }

    @ValueSource(strings = {
            //     "S.test", баг
            //     "s.Test", баг
            "s.test3",
            "s.test4",
            "s.test5"
    })
    @ParameterizedTest(name = "Авторизация с неверно заполненнным логином {0}")
    @Tag("NEGATIVE")
    void authorizedWithIncorrectLoginTest(String login) {

        loginPage
                .setUserName(login)
                .setPasswordUser("@QaZLf2SMExVKJR")
                .loginButtonClick()
                .getAuthorizedError().shouldHave(text("Invalid username or password!"));
    }
}
*/