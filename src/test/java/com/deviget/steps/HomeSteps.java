package com.deviget.steps;

import com.deviget.hooks.Hooks;
import com.deviget.sites.AliExpressSite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {

    AliExpressSite aliExpressSite;

    public HomeSteps(Hooks hooks) {
        this.aliExpressSite = hooks.getAliExpressSite();
    }

    @Given("I navigate to Ali Express page")
    public void iNavigateToAliExpressPage() {
    }


    @When("I search for iphone")
    public void iSearchForIphone() {

    }

    @And("I select the first article from the second page")
    public void iSelectTheFirstArticleFromTheSecondPage() {

    }

    @Then("The first product will have at least {int} available item")
    public void theFirstItemWillHaveAtLeastAvailableProduct(int minimumProducts) {

    }

    @And("There should be at least {int} related product ads")
    public void thereShouldBeAtLeastTwoRelatedProductAds(int  minimumAds) {
    }

    @And("The product from the second ad should have at least {int} available item")
    public void theProductFromTheSecondAdShouldHaveAtLeastAvailableProduct(int minimumProducts) {
    }
}
