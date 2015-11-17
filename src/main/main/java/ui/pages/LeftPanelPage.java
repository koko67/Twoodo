package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/13/2015.
 */
public class LeftPanelPage extends BasePageObject {

    protected WebElement leftPanelComponent;

    private CompanyPanel companyPanel;
    private WebElement notification;

    public void clickElementForCreationByText(String text){
        leftPanelComponent = driver.findElement(By.xpath("//div[@class='section']/a/span[contains(text(), " + text));
        leftPanelComponent.click();
    }

    public void clickElementForSelectionByText(String text){
        leftPanelComponent = driver.findElement(By.xpath("//div[@class='section']/a[contains(text(), " + text));
        leftPanelComponent.click();
    }

    public WebElement findNotificationIcon(){
        return notification = driver.findElement(By.xpath("//span[@class='counter' and contains(@style, 'display: inline-block;')]"));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(leftPanelComponent));
    }

    public CompanyPanel getCompanyPanel() {
        return companyPanel;
    }
}
