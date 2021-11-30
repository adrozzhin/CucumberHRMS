package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.PersonalDetailsPage;
import utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariables;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Noor");
        sendText(addEmployeePage.lastName, "BreakManager");
        sendText(addEmployeePage.middleName, "007");
    }
    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.createLoginCheckBox);
    }
    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeId.clear();

    }
    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.createUsername, "NoorBM007123");
        sendText(addEmployeePage.createPassword, "DFDFdfdfdf114%^%");
        sendText(addEmployeePage.rePassword, "DFDFdfdfdf114%^%");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.personalDetailsHeader.isDisplayed());
//        Assert.assertTrue(personalDetailsPage.createdName.);
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters(String firstName, String middleName, String lastName) {
        //initializing global variables using local variables (values coming from ff)
        GlobalVariables.firstName = firstName;
        GlobalVariables.middleName = middleName;
        GlobalVariables.lastName = lastName;

        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("user enters {string} {string} and {string} for an employee")
    public void user_enters_and_for_an_employee(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("I add multiple employees and verify them that user has been added successfully")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();

        for (Map<String, String> employeeName: employeeNames
             ) {
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);

            click(addEmployeePage.saveBtn);

            String createdNameText = personalDetailsPage.createdName.getText();
            System.out.println(createdNameText);
            String expectedTextOfCreatedName = valueFirstName+ " "+valueMiddleName+" "+valueLastName;
            System.out.println(expectedTextOfCreatedName);

            Assert.assertTrue(personalDetailsPage.personalDetailsHeader.isDisplayed());
            Assert.assertEquals("Employee was not created", expectedTextOfCreatedName,createdNameText);

            //Assertion in HW
            //verify the employee has been added

            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(2000);
        }
    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        DashBoardPage dashBoardPage = new DashBoardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();

        Iterator<Map<String, String>> it = newEmployees.iterator();
        while (it.hasNext()) {
            Map<String, String> mapNewEmp = it.next();
            sendText(addEmployeePage.firstName, mapNewEmp.get("FirstName"));
            sendText(addEmployeePage.middleName, mapNewEmp.get("MiddleName"));
            sendText(addEmployeePage.lastName, mapNewEmp.get("LastName"));
            click(addEmployeePage.saveBtn);

            String createdNameText = personalDetailsPage.createdName.getText();
            System.out.println(createdNameText);
            String expectedTextOfCreatedName = mapNewEmp.get("FirstName")+ " "+mapNewEmp.get("MiddleName")+" "+mapNewEmp.get("LastName");
            System.out.println(expectedTextOfCreatedName);

            Assert.assertTrue(personalDetailsPage.personalDetailsHeader.isDisplayed());
            Assert.assertEquals("Employee was not created", expectedTextOfCreatedName,createdNameText);

            click(dashBoardPage.addEmployeeButton);
        }
    }

    @When("captures employee id")
    public void captures_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        GlobalVariables.empId = addEmployeePage.employeeId.getAttribute("value");

        System.out.println("------------------"+ GlobalVariables.empId+"------------------");
    }
    @Then("verify employee data is matched in ui and db")
    public void verify_employee_data_is_matched_in_ui_and_db() {
        System.out.println(GlobalVariables.mapDataFromDb.get("emp_firstname") + GlobalVariables.mapDataFromDb.get("emp_middle_name") + GlobalVariables.mapDataFromDb.get("emp_lastname"));
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_firstname"), GlobalVariables.firstName);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_middle_name"), GlobalVariables.middleName);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_lastname"), GlobalVariables.lastName);
    }
}
