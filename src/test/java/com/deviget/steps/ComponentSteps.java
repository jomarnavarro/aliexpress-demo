package com.deviget.steps;

import com.deviget.hooks.Hooks;
import com.deviget.sites.AliExpressSite;
import com.deviget.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

public class ComponentSteps {
	AliExpressSite aliExpressSite;

	public ComponentSteps(Hooks hooksClass) {
		this.aliExpressSite = hooksClass.getAliExpressSite();
	}

	@When("I select component from the left nav")
	public void iSelectComponentFromTheLeftNav(DataTable table) {
		Utils.fetchParameters(aliExpressSite, table);
		String component = aliExpressSite.getParameter("component");
		String path = aliExpressSite.getParameter("path");
		aliExpressSite.nav().clickComponentRefLink();
		aliExpressSite.componentLeftNav().searchComponent(component);
		assertTrue(aliExpressSite.componentLeftNav().isComponentListed(path));
		aliExpressSite.componentLeftNav().selectComponent(path);
		assertTrue(aliExpressSite.component().isAt());
	}

	@And("I open example {string} in Playground")
	public void iOpenInPlayground(String componentExample) throws InterruptedException {
		aliExpressSite.component().selectExampleOption(componentExample);
		assertTrue(aliExpressSite.playground().isAt());
		Thread.sleep(2000);
	}
}
