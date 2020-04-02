package com.deviget.steps;

import com.deviget.hooks.Hooks;
import com.deviget.sites.AliExpressSite;
import com.deviget.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.deviget.utils.Constants;

public class PlaygroundSteps {

	AliExpressSite aliExpressSite;

	public PlaygroundSteps(Hooks hooksClass) {
		this.aliExpressSite = hooksClass.getAliExpressSite();
	}
}
