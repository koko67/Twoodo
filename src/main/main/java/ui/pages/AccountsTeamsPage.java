package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class AccountsTeamsPage extends BasePageObject{

    @FindBy(xpath = "//div[@id='account-teams']/table")
    WebElement teamsTable;

    @FindBy(xpath = "//div[@class='sa-button-container']/*[contains(text(), 'Yes, do it')]")
    WebElement buttonConfirmDeleting;

    public AccountsTeamsPage clickOnRemoveTeamByName(String teamName){
        teamsTable.findElement(By.xpath("//h3[contains(text(), 'TheTeam')]/../following-sibling::td//button[@class='btn btn-danger']")).click();
        return this;
    }

    public AccountsTeamsPage confirmRemoveTeam() throws InterruptedException {
        Thread.sleep(1000);
        buttonConfirmDeleting = driver.findElement(By.xpath("//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]"));
        buttonConfirmDeleting.click();
        return this;
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
