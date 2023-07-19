package exp.layer.automation.pages;

import er.automation.engine.helpers.AutomationUtils;
import er.automation.engine.setup.Step;
import io.github.ashwith.flutter.FlutterElement;
import org.openqa.selenium.By;

import java.util.List;

public class LocalityPage extends Step {

    public static String LOCALITY = "//*[contains(@content-desc,'%s')]";
    public static FlutterElement LOCALITY1 = getFlutterActions().getFlutterFinder().byValueKey("beat_plan_locatities_list0");

    public static void resetLocalityAndStore(String locality) throws Exception {
        clickOnLocalityAndCustomer(locality, "l");
        getUiActions().waitForSeconds(3);
        getFlutterActions().clickIfAvailable(getFlutterActions().getFlutterFinder().byValueKey("work_with_capture_photo_back_button"));
        getMobileActions().clickIfAvailable(By.xpath("(//*[contains(@content-desc,'Take a Remote')]/preceding-sibling::*)[1]/*"));
        getUiActions().waitForSeconds(3);
        getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("beat_plan_search_back"));
        getUiActions().waitForSeconds(3);
    }

    public static void clickOnLocalityAndCustomer(String locality, String store) throws Exception {
        clickOnLocality(locality);
        StorePage.searchStore(store);
        StorePage.clickOnStore();
        StorePage.informCUSTOMER();
    }
    public static void clickOnLocality(String locality){
        locality = AutomationUtils.getTestData(locality);
        getMobileActions().click(By.xpath(String.format(LOCALITY, locality)));
    }

    public static void markVisitStore(String locality, List<List<String>> mark_visit_details) throws Exception {
        clickOnLocality(locality);
        for (List<String> mark_visit_store_reason : mark_visit_details) {
            StorePage.searchStore(mark_visit_store_reason.get(0));
            StorePage.clickOnStore();
            StorePage.captureStoreImage();
            StorePage.markVisitCustomer(mark_visit_store_reason.get(1));
        }
    }
}
