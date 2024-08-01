package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/features/VerifyLogin.feature"},
        glue = {"project.com.hooks",
                "stepdefinition",
        },
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
@Test
public class RunVerifyLoginStepDefs extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
