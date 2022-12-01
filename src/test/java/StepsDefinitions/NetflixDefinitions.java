package StepsDefinitions;


import Steps.NetflixSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class NetflixDefinitions {

    @Steps
    NetflixSteps netflixSteps;

    @Given("^that a user enters Netflix$")
    public void navigateToNetflix(){
        netflixSteps.openBrowser();
    }

    @When("^the user validates the page title$")
    public void validateTittle(){
        netflixSteps.getTitle();
    }

    @Then("^the system must be on netflix$")
    public void validateCurrentURL(){
        netflixSteps.getCurrentUrl();
        netflixSteps.verifyUrlCurrent();
    }

}
