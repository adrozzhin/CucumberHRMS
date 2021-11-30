package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AddEmployeePage;
import pages.PersonalDetailsPage;
import utils.CommonMethods;

public class ModifyEmployeeData extends CommonMethods {

    @When("user enters {string}, {string} and {string} for test employee")
    public void user_enters_and_for_test_employee(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @Then("user clicks on Edit button")
    public void user_clicks_on_edit_button() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        click(personalDetailsPage.editButton);
    }

    @Then("fields are interactive")
    public void fields_are_interactive() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.driverLicense.isEnabled());
        Assert.assertTrue(personalDetailsPage.dLExpirationDate.isEnabled());
        Assert.assertTrue(personalDetailsPage.maritalStatus.isEnabled());
        Assert.assertTrue(personalDetailsPage.nationality.isEnabled());
        Assert.assertTrue(personalDetailsPage.dOB.isEnabled());
        Assert.assertTrue(personalDetailsPage.smoker.isEnabled());
        Assert.assertTrue(personalDetailsPage.militaryStatus.isEnabled());
    }

    @Then("user enters DL Number {string}")
    public void user_enters_dl_number(String dlNumber) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        sendText(personalDetailsPage.driverLicense, dlNumber);

    }

    @Then("user enters marital status {string}")
    public void user_enters_marital_status(String marital) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Select select = new Select(personalDetailsPage.maritalStatus);
        select.selectByVisibleText(marital);

    }

    @Then("user enters DL Expiration date {string} {string} {string}")
    public void user_enters_dl_expiration_date(String dlExpirationYear, String dlExpirationMonth, String dlExpirationDay) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        click(personalDetailsPage.dLExpirationDate);
        Select select = new Select(personalDetailsPage.dLExpMonth);
        select.selectByVisibleText(dlExpirationMonth);
        Select select1 = new Select(personalDetailsPage.dLExpYear);
        select1.selectByVisibleText(dlExpirationYear);
        for (WebElement day : personalDetailsPage.dLDay
        ) {
            if (day.getText().contains(dlExpirationDay)) {
                click(day);
                break;
            }
        }
    }

    @Then("user enters date of birth {string} {string} {string}")
    public void user_enters_date_of_birth(String dOBYear, String dOBMonth, String dOBDay) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        click(personalDetailsPage.dOB);
        Select select = new Select(personalDetailsPage.dOBExpMonth);
        select.selectByVisibleText(dOBMonth);
        Select select1 = new Select(personalDetailsPage.dOBExpYear);
        select1.selectByVisibleText(dOBYear);
        for (WebElement day : personalDetailsPage.dOBDay
        ) {
            if (day.getText().contains(dOBDay)) {
                click(day);
                break;
            }
        }
    }
    @Then("user enters military Status {string}")
    public void user_enters_military_status(String militaryStatus) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        sendText(personalDetailsPage.militaryStatus, militaryStatus);
    }

    @Then("user enters nationality {string}")
    public void user_enters_nationality(String nationality) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Select select = new Select(personalDetailsPage.nationality);
        select.selectByVisibleText(nationality);
    }

    @Then("user enters smoker status")
    public void user_enters_smoker_status() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        click(personalDetailsPage.smoker);
    }

    @Then("military status added successfully {string}")
    public void military_status_added_successfully(String militaryStatus) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertEquals("Military status was not apdated", personalDetailsPage.militaryStatus.getAttribute("value"), militaryStatus);
    }

    @Then("smoker status chosen successfully")
    public void smoker_status_chosen_successfully() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.smoker.isSelected());
    }

    @Then("date of birth added successfully {string} {string} {string}")
    public void date_of_birth_added_successfully(String dOBYear, String dOBMonth, String dOBDay) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        String dOBMonthInteger;
        switch (dOBMonth) {
            case "Jan":
                dOBMonthInteger = "01";
                break;
            case "Feb":
                dOBMonthInteger = "02";
                break;
            case "Mar":
                dOBMonthInteger = "03";
                break;
            case "Apr":
                dOBMonthInteger = "04";
                break;
            case "May":
                dOBMonthInteger = "05";
                break;
            case "Jun":
                dOBMonthInteger = "06";
                break;
            case "Jul":
                dOBMonthInteger = "07";
                break;
            case "Aug":
                dOBMonthInteger = "08";
                break;
            case "Sep":
                dOBMonthInteger = "09";
                break;
            case "Oct":
                dOBMonthInteger = "10";
                break;
            case "Nov":
                dOBMonthInteger = "11";
                break;
            case "Dec":
                dOBMonthInteger = "12";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dOBMonth);
        }
        String expectedDOB = dOBYear+"-"+dOBMonthInteger+"-"+dOBDay;
        Assert.assertEquals("Date of birth was not added correctly", personalDetailsPage.dOB.getAttribute("value"), expectedDOB);
    }

    @Then("nationality added successfully {string}")
    public void nationality_added_successfully(String nationality) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertEquals("Nationality was not added correctly", personalDetailsPage.selectedNationality.getText(), nationality);
    }

    @Then("marital status added successfully {string}")
    public void marital_status_added_successfully(String marital) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertEquals("marital status is not as was entered", personalDetailsPage.maritalStatus.getAttribute("value"), marital);
    }

    @Then("DL Expiration date added successfully {string} {string} {string}")
    public void dl_expiration_date_added_successfully(String dlExpirationYear, String dlExpirationMonth, String dlExpirationDay) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        String dLDateMonthInteger;
        switch (dlExpirationMonth) {
            case "Jan":
                dLDateMonthInteger = "01";
                break;
            case "Feb":
                dLDateMonthInteger = "02";
                break;
            case "Mar":
                dLDateMonthInteger = "03";
                break;
            case "Apr":
                dLDateMonthInteger = "04";
                break;
            case "May":
                dLDateMonthInteger = "05";
                break;
            case "Jun":
                dLDateMonthInteger = "06";
                break;
            case "Jul":
                dLDateMonthInteger = "07";
                break;
            case "Aug":
                dLDateMonthInteger = "08";
                break;
            case "Sep":
                dLDateMonthInteger = "09";
                break;
            case "Oct":
                dLDateMonthInteger = "10";
                break;
            case "Nov":
                dLDateMonthInteger = "11";
                break;
            case "Dec":
                dLDateMonthInteger = "12";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dlExpirationMonth);
        }
        String expectedDOB = dlExpirationYear+"-"+dLDateMonthInteger+"-"+dlExpirationDay;
        Assert.assertEquals("DL expiration date was not added correctly", personalDetailsPage.dLExpirationDate.getAttribute("value"), expectedDOB);
    }

    @Then("Driver's License Number added successfully {string}")
    public void driver_s_license_number_added_successfully(String dlNumber) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertEquals("DL number is not as was entered", personalDetailsPage.driverLicense.getAttribute("value"), dlNumber);
    }

}
