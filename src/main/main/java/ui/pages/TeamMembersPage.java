package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

import java.util.concurrent.TimeUnit;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class TeamMembersPage extends BasePageObject{

    @FindBy(xpath = "//div[@id='team-members']/form//input[@placeholder='Enter username or email']")
    WebElement inputNewMemberUser;

    @FindBy(xpath = "//div[@id='team-members']/form//button[contains(text(), 'Invite')]")
    WebElement inviteButton;

    @FindBy(xpath = "//div[@id='team-members']/form//button/contains(text(), 'Invite')]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class='sa-button-container']/*[contains(text(), 'Yes, do it')]")
    WebElement buttonConfirmDeleting;

    @FindBy(xpath = "//div[@id='team-members']/table")
    WebElement tableMembers;

    public TeamMembersPage setNewMember(String member){
        inputNewMemberUser.clear();
        inputNewMemberUser.sendKeys(member);
        return this;
    }

    public TeamMembersPage clickInviteMember(){
        inviteButton.click();
        return this;
    }

    public ContainerPage closeTeamMembersDialog(){
        closeButton.click();
        return new ContainerPage();
    }

    public void addNewMemberShip(String member){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        setNewMember(member);
        clickInviteMember();
    }

    public TeamMembersPage clickRemoveMemberByName(String membername) {
        tableMembers.findElement(By.xpath("//span[contains(text(), '" + membername + "')]/../../../td//button/i")).click();
        return this;
    }

    public TeamMembersPage confirmRemoveMember() throws InterruptedException {
        Thread.sleep(1000);
        buttonConfirmDeleting = driver.findElement(By.xpath("//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]"));
        buttonConfirmDeleting.click();
        return this;
    }

    public boolean existMemberInTable(String membername) throws InterruptedException {
        Thread.sleep(3000);
        return tableMembers.findElement(By.xpath("//span[contains(text(), '" + membername +"')]/../../../td//button/i")) == null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputNewMemberUser));
    }
}
