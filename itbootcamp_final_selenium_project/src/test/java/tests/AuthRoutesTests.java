package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
            "Current site path do not contains /login in URL");
}

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {

        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");

    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }
}
