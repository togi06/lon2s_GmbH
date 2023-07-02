package lon2s.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /*
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select=new Select(dropdownElement);
        List<WebElement>actualOptionsAsWebElement =select.getOptions();

        List<String>actualOptionAsString=new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionAsString.add(each.getText());
        }

        return actualOptionAsString;
    }

    public static void clickRadioButton(List<WebElement>radioButtons,String attributeValue){

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }


    }

    //open a new tab using JSexecutor
    public static void openNewTab() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open();");
    }

    //wait till a new window gets opened
    public static void waitForNewWindow() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //switch to another window by passing index number
    public static void switchToWindow(int index) {
        try {
            waitForNewWindow();
            Set<String> windowHandles = Driver.getDriver().getWindowHandles();
            ArrayList<String> allTabs = new ArrayList<>(windowHandles);
            Driver.getDriver().switchTo().window(allTabs.get(index));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForInvisibilityOf(WebElement webElement){
        // Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
