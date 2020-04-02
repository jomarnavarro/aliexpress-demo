package com.deviget.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
			"src/test/resources/features/availableItems.feature"
		},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/login.json",
        "html:target/login-html"},
        glue = {"com.deviget.sites",
				"com.deviget.pages",
                "com.deviget.steps",
                "com.deviget.utils",
                "com.deviget.hooks"})


public class AliExpressRunner {}
