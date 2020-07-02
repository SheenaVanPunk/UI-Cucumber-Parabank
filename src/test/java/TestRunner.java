import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(glue={"steps"},
                features = "src/test/resources",
                plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {


}
