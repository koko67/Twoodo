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
public class ManageMembersPage extends BasePageObject{

    @FindBy(xpath = "//li[@class='active']/a[contains(text(), 'Members')]")
    WebElement membersTab;

    @FindBy(xpath = "//div[@id='team-members']/form//input[@placeholder='Enter an email' or @placeholder='Enter username or email']")
    WebElement inputNewMemberUser;

    @FindBy(xpath = "//span/button[@type='submit']/span[contains(text(), 'Invite')]")
    WebElement inviteButton;

    @FindBy(xpath = "//div[@id='postFocus']/div[@class='extruder-toggler']/i[contains(text(),'')]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@id='team-general']//a[contains(text(), 'Delete team')]")
    WebElement linkDeletingTeam;

    @FindBy(xpath = "//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]")
    WebElement buttonConfirmDeleting;

    @FindBy(xpath = "//div[@id='account-members']/table")
    WebElement tableMembers;

    public ManageMembersPage clickOnMembers(){
        membersTab.click();
        return this;
    }

    public ManageMembersPage setNewMember(String member){
        inputNewMemberUser.sendKeys(member);
        return this;
    }

    public ManageMembersPage clickInviteMember(){
        inviteButton.click();
        return this;
    }

    public ContainerPage closeManageMembersDialog(){
        closeButton.click();
        return new ContainerPage();
    }

    public void addNewMemberShip(String member){
//        clickOnMembers();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        setNewMember(member);
        clickInviteMember();
        closeManageMembersDialog();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputNewMemberUser));
    }

    public ManageMembersPage clickLinkDeleteTeam(){
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

    public ManageMembersPage clickRemoveMemberByName(String membername) {
        tableMembers.findElement(By.xpath("//div[@id='account-members']/table//span[contains(text(), '" + membername +"')]/../../../td//button/i")).click();
        return this;
    }

    public ManageMembersPage confirmRemoveMember() throws InterruptedException {
        Thread.sleep(1000);
        buttonConfirmDeleting = driver.findElement(By.xpath("//div[@class='sa-button-container']//button[contains(text(), 'Yes, do it')]"));
        buttonConfirmDeleting.click();
        return this;
    }

    public boolean
}
