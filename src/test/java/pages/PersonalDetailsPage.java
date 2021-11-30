package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

/*
User should be able to modify employee details
Fields to modify -
DL
License exp date
DOB
Marital status
Smoker
Nationality
Military services
 */

public class PersonalDetailsPage extends CommonMethods {

    @FindBy(xpath = "//div[@id ='profile-pic']/h1")
    public WebElement createdName;

    @FindBy(xpath = "//h1[text() ='Personal Details']")
    public WebElement personalDetailsHeader;

    @FindBy(xpath = "//*[@id= 'personal_txtLicenNo']")
    public WebElement driverLicense;

    @FindBy(css = "input#personal_txtLicExpDate")
    public WebElement dLExpirationDate;

    @FindBy(css = "input#personal_DOB")
    public WebElement dOB;

    @FindBy(css = "select#personal_cmbMarital")
    public WebElement maritalStatus;

    @FindBy(css = "input#personal_chkSmokeFlag")
    public WebElement smoker;

    @FindBy(css = "select#personal_cmbNation")
    public WebElement nationality;

    @FindBy(xpath = "//select[@id='personal_cmbNation']/option[@selected='selected']")
    public WebElement selectedNationality;

    @FindBy(css = "input#personal_txtMilitarySer")
    public WebElement militaryStatus;

    @FindBy(xpath = "//input[@value = 'Edit']")
    public WebElement editButton;

    @FindBy(css = "select.ui-datepicker-month")
    public WebElement dLExpMonth;

    @FindBy(css = "select.ui-datepicker-year")
    public WebElement dLExpYear;

    @FindBy(xpath = "//table[@class = 'ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> dLDay;

    @FindBy(css = "select.ui-datepicker-month")
    public WebElement dOBExpMonth;

    @FindBy(css = "select.ui-datepicker-year")
    public WebElement dOBExpYear;

    @FindBy(xpath = "//table[@class = 'ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> dOBDay;

    public PersonalDetailsPage() {

        PageFactory.initElements(driver, this);
    }

}
