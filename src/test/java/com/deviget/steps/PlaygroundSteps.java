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

	@And("I edit row {int} in preview pane")
	public void iEditRowInPreviewPane(int rowNumber, DataTable dataTable) {
		Utils.fetchParameters(aliExpressSite, dataTable);
		aliExpressSite.setParameter("rowNumber", rowNumber + "");
		aliExpressSite.playground().editRow(aliExpressSite.getParameters());
	}

	@Then("Row will be populated with data above")
	public void rowWillBePopulatedWithDataAbove() {
		assertEquals(aliExpressSite.getParameter(Constants.LABEL_COL),
				aliExpressSite.playground().getValue(aliExpressSite.getParameters(), Constants.LABEL_COL));
		assertEquals(aliExpressSite.getParameter(Constants.WEBSITE_COL),
				aliExpressSite.playground().getValue(aliExpressSite.getParameters(), Constants.WEBSITE_COL));
		assertEquals(aliExpressSite.getParameter(Constants.PHONE_COL),
				aliExpressSite.playground().getValue(aliExpressSite.getParameters(), Constants.PHONE_COL));
		assertEquals("$"+ aliExpressSite.getParameter(Constants.BALANCE_COL),
				aliExpressSite.playground().getValue(aliExpressSite.getParameters(), Constants.BALANCE_COL));
		assertEquals(aliExpressSite.getParameter(Constants.CLOSE_AT_COL),
				aliExpressSite.playground().getValue(aliExpressSite.getParameters(), Constants.CLOSE_AT_COL));
//		assertTrue(salesforceSite.playground().validateRows(salesforceSite.getParameters()));
	}

	@And("I select details from last row menu")
	public void iSelectDetailsFromLastRowMenu() {
		aliExpressSite.playground().showDetailsLastRow();
	}

	@Then("details will be displayed")
	public void detailsWillBeDisplayed() {
		assertTrue(aliExpressSite.playground().validateLastRowDetails());
	}
}
