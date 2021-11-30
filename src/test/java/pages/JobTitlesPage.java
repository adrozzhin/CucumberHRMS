package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class JobTitlesPage extends CommonMethods {
    public JobTitlesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text() = 'Job Titles']")
    public WebElement jobTitlesHeader;

    @FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr")
    public List<WebElement> jobTitlesTable;
}
