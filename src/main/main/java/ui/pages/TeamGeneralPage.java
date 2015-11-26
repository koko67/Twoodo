package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class TeamGeneralPage extends BasePageObject{

    @FindBy(xpath = "//div[@id='team-general']//a[contains(text(), 'Delete team')]")
    WebElement linkDeletingTeam;

    @FindBy(xpath = "//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]")
    WebElement buttonConfirmDeleting;

    public TeamGeneralPage clickLinkDeleteTeam(){
//        linkDeletingTeam = driver.findElement(By.xpath("//div[@id='team-general']//a[contains(text(), 'Delete team')]"));
        wait.until(ExpectedConditions.visibilityOf(linkDeletingTeam));
        linkDeletingTeam.click();
        return this;
    }

    public ContainerPage confirmDeletingTeam() throws InterruptedException {
        Thread.sleep(1000);
        buttonConfirmDeleting = driver.findElement(By.xpath("//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]"));
        buttonConfirmDeleting.click();
        return new ContainerPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
