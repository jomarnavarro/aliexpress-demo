package com.deviget.steps;

import com.deviget.hooks.Hooks;
import com.deviget.sites.AliExpressSite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class HomeSteps {

    AliExpressSite aliExpressSite;

    public HomeSteps(Hooks hooks) {
        this.aliExpressSite = hooks.getAliExpressSite();
    }

    @Given("I navigate to Ali Express page")
    public void iNavigateToAliExpressPage() {
        aliExpressSite.search().goTo(aliExpressSite.getParameter("url"));
        aliExpressSite.popUp().dismissPopUpHome();
        assertTrue(aliExpressSite.search().isAt());
    }


    @When("I search for {word}")
    public void iSearchForIphone(String article) {
        aliExpressSite.search().searchArticle(article);
        aliExpressSite.popUp().dismissNextPopUp();
    }

    @And("I select the first article from the second page")
    public void iSelectTheFirstArticleFromTheSecondPage() {
        aliExpressSite.searchResults().clickNextPage();
        aliExpressSite.searchResults().selectFirstArticle();
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
