import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {

    @Given("I navigate to Ali Express page")
    public void iNavigateToAliExpressPage() {
    }


    @When("I search for iphone")
    public void iSearchForIphone() {

    }

    @And("I select the first article from the second page")
    public void iSelectTheFirstArticleFromTheSecondPage() {

    }

    @Then("The first item will have at least {int} available product")
    public void theFirstItemWillHaveAtLeastAvailableProduct(int minimumProducts) {

    }

    @And("There should be at least {int} related product ads")
    public void thereShouldBeAtLeastTwoRelatedProductAds(int  minimumAds) {
    }

    @And("The product from the second ad should have at least {int} available product")
    public void theProductFromTheSecondAdShouldHaveAtLeastAvailableProduct(int minimumProducts) {
    }
}
