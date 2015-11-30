package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

/**
 * Created by Jorge on 11/28/2015.
 */
public class LeftIntegrationPanel extends BasePageObject{
    @FindBy(xpath = "//menu-left[@id='menu-left-content']//div[@class='section']/a[contains(text(), 'Tasks')]")
    WebElement buttonTasks;

    @FindBy(xpath = "//menu-left[@id='menu-left-content']//div[@class='section']/a[contains(text(), 'Files')]")
    WebElement buttonFiles;

    public ContainerPage clickOnButtonTasks(){
        buttonTasks.click();
        return new ContainerPage();
    }

    public ContainerPage clickOnButtonFiles(){
        buttonFiles.click();
        return new ContainerPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
