package librarye2e.restassured.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "librarye2e.restassured.steps",  
    dryRun = false,
    tags = "@integration",    
    snippets = SnippetType.CAMELCASE,
    plugin = {"pretty", "html:target/cucumber-reports.html"}, 
    monochrome = true                      
    
    )

public class Executa {
	
}
