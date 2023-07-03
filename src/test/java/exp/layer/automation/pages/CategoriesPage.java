package exp.layer.automation.pages;

import er.automation.engine.helpers.AutomationUtils;
import er.automation.engine.setup.Step;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends Step {

    static Logger log = LogManager.getLogger(CategoriesPage.class);

    public static final String SEARCHED_ITEM_RESULT = "//*[contains(@content-desc,'%s')]";
    public static final By CATEGORY_SEARCH = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView");
    public static final By CATEGORY_SEARCH_TEXT_BOX = By.xpath("//*[@text='Search for products, brands & categories']");

    public static final By CATEGORY_SEARCH_RESULT = By.xpath("(//android.widget.ImageView)[2]");
    public static final By ADD_BUTTON_PIECE = By.xpath("(//android.widget.Button[@content-desc='Add'])[1]");
    public static final By ADD_BUTTON_BAG = By.xpath("(//android.widget.Button[@content-desc='Add'])[2]");
    public static final By ADD_BUTTON_CASE = By.xpath("(//android.widget.Button[@content-desc='Add'])[3]");

    public static final By BOTTOM_CART_ICON = By.xpath("//android.widget.ImageView[@content-desc='1']");


    public static void clickOneRandomCategory() throws Exception {
        int categoryNumber = AutomationUtils.generateRandomNoByRange(1, 4);
        getMobileActions().click(By.xpath("//android.view.View[@content-desc='Automation-Category-" + categoryNumber + "']/android.widget.ImageView"));
    }

    public static void searchItemDetails(String itemDetails) throws Exception {
        getMobileActions().click(CATEGORY_SEARCH);
        getMobileActions().type(itemDetails, CATEGORY_SEARCH_TEXT_BOX);
        getMobileActions().click(By.xpath(String.format(SEARCHED_ITEM_RESULT,itemDetails)));
    }

    public static void addRandomOneItemToCart() throws Exception {
        clickOneRandomCategory();
        int itemNo = AutomationUtils.generateRandomNoByRange(1, 38);
        String itemDetails = "Automation-Test-Item-Name-" + itemNo + "";
        searchItemDetails(itemDetails);
        getMobileActions().click(ADD_BUTTON_PIECE);
        getMobileActions().click(BOTTOM_CART_ICON);
    }


    public int categoryNumber = AutomationUtils.generateRandomNoByRange(1, 4);

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"+91 | Enter Mobile Number\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Login\"]/android.widget.EditText")
    public static WebElement MOBILE_NUMBER_INPUT_BOX;


    //@AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Add\"])[7]")
    //public static WebElement login_Button1;
    //@iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/XCUIElementTypeButton")
    //private List<WebElement> allButtons;

    /*public CategoriesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getMobileActions().appiumDriver, Duration.ofSeconds(10)), this);
    }*/

    public CategoriesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getMobileActions().appiumDriver), this);
    }


    public static void addItemToCart() throws Exception {
        //getMobileActions().waitForSeconds(10);

        // login_Button1.click();


        //PageActionsHelper.scrollForMobile(By.xpath("(//android.widget.Button[@content-desc=\"Add\"])[7]"));

        //getMobileActions().appiumDriver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
        //Edition107_Base.scroll(Edition107_Base.ScrollDirection.UP);


        //getMobileActions().waitForSeconds(10);
//        getMobileActions().click(By.xpath("//android.view.View[@content-desc=\"Automation-Category-1\"]/android.widget.ImageView"));
        //getMobileActions().scrollToElementView(By.xpath("(//android.widget.Button[@content-desc=\"Add\"])[7]"));
//        AutomationUtils.generateRandomNoByRange(0,3);
        //getMobileActions().scrollToElementByText();
//        getMobileActions().click(By.xpath("(//android.widget.Button[@content-desc=\"Add\"])["+AutomationUtils.generateRandomNoByRange(1,2)+"]"));
    }

}
