package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

import java.util.concurrent.TimeUnit;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class AccountMembersPage extends BasePageObject{

    @FindBy(xpath = "//div[@id='account-members']/form//input[@placeholder='Enter an email']")
    WebElement inputNewMemberUser;

    @FindBy(xpath = "//div[@id='account-members']/form//button/span[contains(text(), 'Invite')]")
    WebElement inviteButton;

    @FindBy(xpath = "//div[@id='postFocus']/div[@class='extruder-toggler']/i[contains(text(),'')]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class='sa-button-container']/*[contains(text(), 'Yes, do it')]")
    WebElement buttonConfirmDeleting;

    @FindBy(xpath = "//div[@id='account-members']/table")
    WebElement tableMembers;

    public AccountMembersPage setNewMember(String member){
        inputNewMemberUser.clear();
        inputNewMemberUser.sendKeys(member);
        return this;
    }

    public AccountMembersPage clickInviteMember(){
        inviteButton.click();
        return this;
    }

    public ContainerPage closeAccountMembersDialog(){
        closeButton.click();
        return new ContainerPage();
    }

    public void addNewMemberShip(String member){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        setNewMember(member);
        clickInviteMember();
    }

    public AccountMembersPage clickRemoveMemberByName(String membername) {
        tableMembers.findElement(By.xpath("//div[@id='account-members']/table//span[contains(text(), '" + membername +"')]/../../../td//button/i")).click();
        return this;
    }

    public AccountMembersPage confirmRemoveMember() throws InterruptedException {
        Thread.sleep(1000);
        buttonConfirmDeleting = driver.findElement(By.xpath("//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]"));
        buttonConfirmDeleting.click();
        return this;
    }

    public boolean existMemberInTable(String membername) throws InterruptedException {
        Thread.sleep(3000);
        return tableMembers.findElement(By.xpath("//div[@id='account-members']/table//span[contains(text(), '" + membername +"')]/../../../td//button/i")) == null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputNewMemberUser));
    }
}
