package steps;

import io.cucumber.java.en.Then;
import utils.DbUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DBSteps {
    @Then("query HRMS database and get data")
    public void query_HRMS_database_and_get_data() {
        GlobalVariables.mapDataFromDb = DbUtils.mapFromDb("select emp_firstname, emp_middle_name, emp_lastname from hs_hr_employees where employee_id = "+ GlobalVariables.empId);
    }
}
