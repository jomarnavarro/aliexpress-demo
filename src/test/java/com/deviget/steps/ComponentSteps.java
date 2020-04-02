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
}
