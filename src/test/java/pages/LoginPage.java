package pages;

import tests.TestBase;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends TestBase {

        private final SelenideElement emailInput = $("#email");
        private final SelenideElement continueButton = $("button.custom-button[type='submit']");
        private final SelenideElement passwordInput = $("#current-password");
        private final SelenideElement headerProfile = $(".main-title.hidden");
        private final SelenideElement emailUserPage = $$(".data").findBy(partialText("@"));


        private final SelenideElement loginButton = $("#login");
        private final SelenideElement authorizedError = $("#userForm").$("#name");

        private final SelenideElement emptyErrorLogin = $(".p-formfield:has([name='login']) .p-message-text");
        private final SelenideElement emptyErrorPassword = $(".p-formfield:has([name='password']) .p-message-text");




        public LoginPage setEmail (String value){
            emailInput.setValue(value);

            return this;
        }

        public LoginPage continueButtonClick (){
            continueButton.click();

            return this;
        }

        public LoginPage setPassword (String value){
            passwordInput.setValue(value);

            return this;
        }

        public SelenideElement getHeaderProfile () {
            return headerProfile;
        }

        public String getEmailUserPage (String expectedEmail) {
            return emailUserPage.shouldHave(text(expectedEmail)).getText();
        }


        public LoginPage loginButtonClick () {
            loginButton.click();

            return this;
        }

   //     public SelenideElement getLogoutButton () {
         //   return logoutButton;
   //     }

        public void logoutButtonClick () {
          //  logoutButton.click();

        }

        public SelenideElement getAuthorizedError () {
            return authorizedError;
        }
}