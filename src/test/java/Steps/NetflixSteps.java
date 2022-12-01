package Steps;

import Pages.NetflixPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class NetflixSteps {

    @Steps
    NetflixPage netflixPage;

    @Step
    public void openBrowser(){
        netflixPage.open();
    }

    @Step
    public void getCurrentUrl(){
        netflixPage.obtainTheCurrentUrl();
    }

    @Step
    public void getTitle(){
        netflixPage.setLblTittle();
        Assert.assertEquals("Validate title text", netflixPage.setLblTittle(), "Netflix Colombia: Ve series online, ve películas online");
    }

    @Step
    public void verifyUrlCurrent() {
        Assert.assertEquals("Validate the current Url", netflixPage.obtainTheCurrentUrl(), "https://www.netflix.com/co/");
    }
}
