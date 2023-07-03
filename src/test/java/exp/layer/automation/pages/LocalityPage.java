package exp.layer.automation.pages;

import er.automation.engine.helpers.AutomationUtils;
import er.automation.engine.setup.Step;
import org.openqa.selenium.By;

public class LocalityPage extends Step {

    public static String LOCALITY = "//*[contains(@content-desc,'%s')]";

    public static void clickOnLocalityAndCustomer(String locality, String store) throws Exception {
        locality = AutomationUtils.getTestData(locality);
        store = AutomationUtils.getTestData(store);

        System.out.println(">>>>>>>> locality"+locality);
        getMobileActions().click(By.xpath(String.format(LOCALITY, locality)));
        Stores.clickOnStore(store);
    }
}