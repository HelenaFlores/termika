package tests.UI.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginUITests extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @CsvFileSource(resources = "/test_data/authorizationWithAllFilledFieldsTest.csv")
    @ParameterizedTest(name = "Авторизация с верно заполненнным логином {0} и паролем {1}")
    public void successfulLoginTest(String email, String password) {
        homePage
                .openPage()
                .goToProfile();
        loginPage
                .setEmail(email)
                .continueButtonClick()
                .setPassword(password)
                .continueButtonClick();

        String actualEmail = loginPage.getEmailUserPage(email);
        assertThat(actualEmail).isEqualTo(email);
        loginPage.getHeaderProfile().isEnabled();
    }
}
