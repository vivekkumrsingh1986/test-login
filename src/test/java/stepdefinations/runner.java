package stepdefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/features"
,glue = {"stepdefinations"}, 
monochrome = true,
plugin = {"pretty", "json:target/jsonreports/newreport.json", "html:target/htmlreports/newreport.html"}
		)

public class runner {
	

}
