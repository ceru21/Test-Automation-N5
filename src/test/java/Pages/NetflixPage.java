package Pages;


import net.serenitybdd.core.pages.PageObject;

import static java.time.temporal.ChronoUnit.SECONDS;


public class NetflixPage  extends PageObject {

    public String setLblTittle() {
        waitFor(5000);
       return getDriver().getTitle();
    }

    /**
     * Extract the current url
     */
    public String obtainTheCurrentUrl() {
        setImplicitTimeout(5, SECONDS);
        return  getDriver().getCurrentUrl();
    }
}
