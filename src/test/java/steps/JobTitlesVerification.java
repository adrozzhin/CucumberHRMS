package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.JobTitlesPage;
import utils.CommonMethods;

public class JobTitlesVerification extends CommonMethods {
    @Given("admin user navigates to job titles table")
    public void admin_user_navigates_to_job_titles_table() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        JobTitlesPage jobTitlesPage = new JobTitlesPage();
        moveCursor(dashBoardPage.AdminTabBtn);
        moveCursor(dashBoardPage.JobTabBtn);
        click(dashBoardPage.JobTitlesTabBtn);
        Assert.assertTrue("Job Titles Page has not been opened", jobTitlesPage.jobTitlesHeader.isDisplayed());
    }

    @When("admin user verifies that all job titles are displayed in Ascending order same as in job titles data base")
    public void admin_user_verifies_that_all_job_titles_are_displayed_in_ascending_order_same_as_in_job_titles_data_base() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage();

    }
}
