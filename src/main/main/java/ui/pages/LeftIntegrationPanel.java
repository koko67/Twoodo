package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Jorge on 11/28/2015.
 */
public class LeftIntegrationPanel {
    @FindBy(xpath = "//menu-left[@id='menu-left-content']//div[@class='section']/a[contains(text(), 'Tasks')]")
    WebElement buttonTasks;

    public ContainerPage clickOnButtonTasks(){
        buttonTasks.click();
        return new ContainerPage();
    }
}
