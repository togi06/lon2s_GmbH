package lon2s.pages;

import lon2s.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public  BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="cookiescript_accept")
    public WebElement cookies;

    @FindBy(xpath = "(//span[@class=\"navigation__arrowBtn\"])[1]")
    public WebElement agentur;

    @FindBy(xpath = "(//span[@class=\"navigation__arrowBtn\"])[2]")
    public  WebElement leistung;

    @FindBy (xpath = "(//span[@class=\"navigation__arrowBtn\"])[3]")
    public WebElement jobs;

    @FindBy(xpath = "(//a[@title=\"Kontaktieren Sie uns!\"])[2]")
    public WebElement kontakt;

    @FindBy(xpath = "//select[@id=\"topic\"]")
    public WebElement topic;

    @FindBy(id="name")
    public WebElement name;

    @FindBy(xpath = "//option[@value=\"3\"]")
    public WebElement bewerbung;

    @FindBy (xpath = "//select[@class=\"fontSize15\"]")
    public WebElement select;

    @FindBy(id="email")
    public  WebElement email;

    @FindBy (xpath = "(//label[@class=\"checkbox\"])[2]")
    public  WebElement tick;

    @FindBy (xpath = "//textarea[@id=\"message\"]")
    public WebElement message;

    @FindBy (xpath = "//a[@class=\"button is-primary is-rounded is-large\"]")
    public WebElement aufnehmen;

    @FindBy(xpath = "//div[@class=\"notification help is-danger is-light mt-5\"]")
    public WebElement formular;

}
