package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    String desiredId = "20119000";
    String desiredName = "Andrei";

    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
        openBrowser();
    }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.pimOption);
        click(dashBoardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() throws InterruptedException {
        EmployeeListPage emp = new EmployeeListPage();
        Thread.sleep(2000);
        sendText(emp.idEmployee, desiredId);
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emp = new EmployeeListPage();
        click(emp.searchButton);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() throws InterruptedException {
        EmployeeListPage emp = new EmployeeListPage();
        Thread.sleep(2000);
        sendText(emp.employeeNameField, desiredName);
        click(emp.idEmployee); //click on any WebElement to close Name Dropdown in order to
        // WebElement Search Button not to be closed by this DropDown
    }

    @Then("user see employee with desired name is displayed")
    public void user_see_employee_with_desired_name_is_displayed() throws InterruptedException {
        EmployeeListPage emp = new EmployeeListPage();

        for (int i = 0; i < emp.searchResultTable.size(); i++) {

            String rowText = emp.searchResultTable.get(i).getText();
            System.out.println(rowText);
            Assert.assertTrue(rowText.contains(desiredName));
            Thread.sleep(2000);
        }
    }

    @Then("user see employee with desired id is displayed")
    public void user_see_employee_with_desired_id_is_displayed() throws InterruptedException {
        EmployeeListPage emp = new EmployeeListPage();
        for (int i = 0; i < emp.searchResultTable.size(); i++) {

            String rowText = emp.searchResultTable.get(i).getText();
            System.out.println(rowText);
            Assert.assertTrue(rowText.contains(desiredId));
            Thread.sleep(2000);
        }
    }

    @Then("user quit the browser")
    public void user_quit_the_browser() {
        tearDown();
    }
}
