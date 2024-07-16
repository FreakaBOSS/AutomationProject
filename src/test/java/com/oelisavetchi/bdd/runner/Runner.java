package com.oelisavetchi.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/oelisavetchi/bdd/feature",
        glue = "stepDefinition",
        tags = "@Run")
public class Runner {

    @Value("${page.url}")
    private String pageUrl;

    public String getPageUrl() {
        return pageUrl;
    }
}
