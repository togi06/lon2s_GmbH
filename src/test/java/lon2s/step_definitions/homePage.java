package lon2s.step_definitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lon2s.pages.BasePage;
import lon2s.utilities.BrowserUtils;
import lon2s.utilities.ConfigurationReader;
import lon2s.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class homePage {

    BasePage basePage = new BasePage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Given("User go to home page")
    public void user_go_to_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));

    }


    @When("User checks the  page")
    public void userChecksThePage() {
       for (int i = 0; i < 10; i++) {
           BrowserUtils.sleep(1);
           js.executeScript("window.scrollBy(0,2000)");
        }

    }


    @And("User scrolls up")
    public void userScrollsUp() {
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-2000)");
        }

    }

    @And("User clicks Kontakt")
    public void userClicksKontakt() {
        basePage.kontakt.click();
    }

    @And("User chooses Thema")
    public void userChoosesThema() {
        BrowserUtils.sleep(1);

       //Select dropdown = new Select(basePage.select);
        //dropdown.selectByIndex(3);
        basePage.topic.click();
        BrowserUtils.sleep(1);
        basePage.bewerbung.click();
        //BrowserUtils.sleep(1);

    }

    @And("User writes Name")
    public void userWritesName() {
        BrowserUtils.sleep(1);
        basePage.name.click();
        basePage.name.sendKeys(ConfigurationReader.getProperty("name"));
    }

    @And("User writes Email")
    public void userWritesEmail() {
        BrowserUtils.sleep(1);
        basePage.email.click();
        basePage.email.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @And("User clicks Email")
    public void userClicksEmail() {
        BrowserUtils.sleep(1);
        basePage.tick.click();
    }

    @And("User writes Message")
    public void userWritesMessage() {
        BrowserUtils.sleep(1);
        basePage.message.click();
        basePage.message.sendKeys(ConfigurationReader.getProperty("nachricht"));
    }

    @And("User clicks Kontakt Aufnehmen")
    public void userClicksKontaktAufnehmen() {
        BrowserUtils.sleep(2);
        basePage.aufnehmen.click();

    }

    @And("User clicks  one more Kontakt Aufnehmen")
    public void userClicksOneMoreKontaktAufnehmen() {
        BrowserUtils.sleep(2);
        basePage.aufnehmen.click();
    }

    @Then("verify the warning")
    public void verifyTheWarning() {
        BrowserUtils.sleep(1);
        //System.out.println("basePage.vielenDank.getText() = " + basePage.vielenDank.getText());
        System.out.println("basePage.formular.getText() = " + basePage.formular.getText());
        Assert.assertTrue(basePage.formular.isDisplayed());
        //String expected= basePage.vielenDank.getText();
        //String actual= basePage.formular.getText();
        //Assert.assertEquals(expected,actual);

    }

    @And("User clicks Telefon")
    public void userClicksTelefon() {
        BrowserUtils.sleep(1);
        basePage.telefon.click();
    }

    @And("User writes Telefonnummer")
    public void userWritesTelefonnummer() {
        BrowserUtils.sleep(1);
        basePage.nummer.sendKeys(ConfigurationReader.getProperty("telefon"));
    }

    @And("User clicks Nachmittag")
    public void userClicksNachmittag() {
        BrowserUtils.sleep(1);
        basePage.nachmittag.click();
    }

    @When("User scrolls down")
    public void userScrollsDown() {
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,1150)");
        }
    }

    @And("User selects title")
    public void userSelectsTitle() {
        //document.querySelector('#topic').querySelector('option')
        //WebElement button=(WebElement)js.executeScript("return document.querySelector( > div.sc-cCjUiG.gHlwwJ > div > div.sc-lllmON.fjvxqY > div > button:nth-child(3)')");
        //WebElement button=(WebElement)js.executeScript("return document.querySelector('#topic').querySelector('option').querySelector('#topic > option:nth-child(2)')");
        //button.click();
        Select dropdown = new Select(basePage.thema);
        dropdown.selectByIndex(3);
        //basePage.bewerbung.click();


    }



    @And("User clicks Kontaktaufnehmen")
    public void userClicksKontaktaufnehmen() {
        basePage.submit.click();
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-50)");
        }

    }

    @Then("verify the danger")
    public void verifyTheDanger() {
        BrowserUtils.sleep(1);
        System.out.println("basePage.danger.getText() = " + basePage.danger.getText());
        basePage.danger.isDisplayed();
    }
}
