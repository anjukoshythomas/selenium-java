package com.anjukt.page;

import com.anjukt.driver.DriverManager;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.anjukt.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

/**+
 * @author Anju Koshy
 */

public class AbstractPageObject {

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
    }
}
