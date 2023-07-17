package exp.layer.automation.pages;

import er.automation.engine.helpers.AutomationUtils;
import er.automation.engine.setup.Step;
import exp.layer.automation.steps.ExpLayerCommonSteps;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;

import java.util.List;

public class ItemListPage extends Step {

    public static final By VIEWS_ANDROID = AppiumBy.accessibilityId("Views");
    public static final By VIEWS_IOS = By.xpath("//*[@name='Views']");

    public static void increaseGivenItemQuantity(String item_name, String item_type, String increase_amount) throws Exception {
        item_name = item_name.concat(" @");
        CategoriesPage.searchItemDetails(item_name);
        int i = Integer.parseInt(increase_amount);
        if (item_type.equalsIgnoreCase("Bag")) {
            for (int j = 0; j < i; j++) {
                getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("product_0_increment_button_1"));
            }
        } else if (item_type.equalsIgnoreCase("Case")) {
            for (int j = 0; j < i; j++) {
                getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("product_0_increment_button_2"));
            }
        } else {
            for (int j = 0; j < i; j++) {
                getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("product_0_increment_button_0"));
            }
        }
    }

    public static void increaseGivenItemQuantity(String item_name, String item_type) throws Exception {
        increaseGivenItemQuantity(item_name, item_type, "1");
    }

    public static void increaseGivenItemQuantity(String item_name) throws Exception {
        increaseGivenItemQuantity(item_name, "Bag");
    }

    public static void increaseItemQuantity(List<List<String>> item_list) throws Exception {
        if (item_list.get(0).size() == 1) {
            for (List<String> item_detail : item_list) {
                increaseGivenItemQuantity(item_detail.get(0));
            }
        } else if (item_list.get(0).size() == 2) {
            for (List<String> item_detail : item_list) {
                increaseGivenItemQuantity(item_detail.get(0), item_detail.get(1));
            }
        } else {
            for (List<String> item_detail : item_list) {
                increaseGivenItemQuantity(item_detail.get(0), item_detail.get(1), item_detail.get(2));
            }
        }
    }

    public static void decreaseItemQuantity(List<List<String>> item_list) throws Exception {
        if (item_list.get(0).size() == 1) {
            for (List<String> item_detail : item_list) {
                decreaseGivenItemQuantity(item_detail.get(0));
            }
        } else {
            for (List<String> item_detail : item_list) {
                decreaseGivenItemQuantity(item_detail.get(0), item_detail.get(1));
            }
        }
    }

    public static void decreaseGivenItemQuantity(String item_name) throws Exception {
        decreaseGivenItemQuantity(item_name, "Bag");
    }

    public static void decreaseGivenItemQuantity(String item_name, String item_type) throws Exception {
        decreaseGivenItemQuantity(item_name, item_type, "1");
    }

    public static void decreaseGivenItemQuantity(String item_name, String item_type, String decrease_amount) throws Exception {
        item_name = item_name.concat(" @");
        CategoriesPage.searchItemDetails(item_name);
        int i = Integer.parseInt(decrease_amount);
        if (item_type.equalsIgnoreCase("Bag")) {
            for (int j = 0; j < i; j++) {
                getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("product_0_decrement_button_1"));
            }
        } else if (item_type.equalsIgnoreCase("Case")) {
            for (int j = 0; j < i; j++) {
                getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("product_0_decrement_button_2"));
            }
        } else {
            for (int j = 0; j < i; j++) {
                getFlutterActions().click(getFlutterActions().getFlutterFinder().byValueKey("product_0_decrement_button_0"));
            }
        }
    }


}
