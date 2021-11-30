package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/", //need to give a path for our feature files

        //glue is there we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps", // we need to glue our step definitions - implementation

        //if we set dry run to true, then no actual execution happens
        //it will quickly scan all gherkin steps whether they have implementation or not
        dryRun = false, //when set as true, will run over the feature steps and identify the missing implementation

        // it keeps the console output for the cucumber test easily readable
              //it will remove all the unreadable character
        monochrome = true, // when set as true, will format the console outcome
        tags = "@db1",

        plugin = {"pretty"}  // will print the steps inside the console
                //"html:target/cucumber.html", // generates default html report
               //"rerun:target/FailedTests.txt", // generates a txt file only with failed tests
                //"json:target/cucumber.json"}
        //plugin = we use it to generate the report for the execution
        //"pretty" - it takes care of printing the steps in console
        //strict=true, it check all the steps definition ,  when set as true, will fail the execution when undefined step is found
)
public class Smoke {

}