package com.deviget.steps;

import static org.junit.Assert.*;

import com.deviget.hooks.Hooks;
import com.deviget.sites.AliExpressSite;
import cucumber.api.java.en.Given;

import com.deviget.utils.Constants;

public class DevGuideSteps {
	AliExpressSite aliExpressSite;

	public DevGuideSteps(Hooks hooksClass) {
		this.aliExpressSite = hooksClass.getAliExpressSite();
	}

}
