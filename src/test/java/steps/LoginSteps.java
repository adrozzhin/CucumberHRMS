package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    public String essUser[] = {"johnny1234560000", "Syntax1253!!!!", "Johnny"};

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        click(loginPage.loginBtn);
    }
    @Then("admin user is succesfully logged in")
    public void admin_user_is_succesfully_logged_in() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
        Assert.assertTrue(dashBoardPage.welcomeMessage.getText().contains("Admin"));
        tearDown();
    }
    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, essUser[0]);
        sendText(loginPage.passwordBox, essUser[1]);
    }
    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
        Assert.assertTrue(dashBoardPage.welcomeMessage.getText().contains(essUser[2]));
        boolean flag;
        try {
            boolean pimIsDisplayed = dashBoardPage.pimOption.isDisplayed();
            flag=false;
        } catch (NoSuchElementException e) {
            flag=true;
        }
        Assert.assertTrue(flag);
        tearDown();
    }
    @When("user enters valid ess username and invalid password")
    public void user_enters_valid_ess_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, "Admin");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }
    @When("user enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, "Admin484455");
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }
    @When("user enters empty username and valid password")
    public void user_enters_empty_username_and_valid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }
    @When("user enters valid username and empty password")
    public void user_enters_valid_username_and_empty_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
    }
    @Then("user see invalid credentials message on login page")
    public void user_see_invalid_credentials_message_on_login_page() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Invalid credentials"));
        tearDown();
    }
    @Then("user see empty username message on login page")
    public void user_see_empty_username_message_on_login_page() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Username cannot be empty"));
        tearDown();
    }
    @Then("user see empty password message on login page")
    public void user_see_empty_password_on_login_page() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Password cannot be empty"));
        tearDown();
    }

    @When("user enters invalid credentials and clicks on login verify the error")
    public void user_enters_invalid_credentials_and_clicks_on_login_verify_the_error(DataTable errorValidation) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<Map<String, String>> errorData = errorValidation.asMaps();

        for (Map<String, String> validation: errorData
             ) {
            String userNameValue = validation.get("username");
            String passwordValue = validation.get("password");
            String errorMessageValue = validation.get("errorMessage");

            LoginPage loginPage = new LoginPage();
            sendText(loginPage.userNameBox, userNameValue);
            sendText(loginPage.passwordBox, passwordValue);
            click(loginPage.loginBtn);

            String errorMessageActual = loginPage.errorMessage.getText();
            Assert.assertEquals("Values do not match", errorMessageActual, errorMessageValue);
        }
    }

    @When("user enters invalid {string} and {string} and clicks on login and verify the {string}")
    public void user_enters_invalid_and_and_clicks_on_login_and_verify_the(String username, String password, String errorMessage) {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, username);
        sendText(loginPage.passwordBox, password);
        click(loginPage.loginBtn);

        String errorMessageActual = loginPage.errorMessage.getText();
        Assert.assertEquals("Values do not match", errorMessageActual, errorMessage);
    }
}
