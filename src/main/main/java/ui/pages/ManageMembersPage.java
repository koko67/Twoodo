package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class ManageMembersPage extends BasePageObject{

    @FindBy(xpath = "//li[@class='active']/a[@href='#team-members' and contains(text(), 'Members')]")
    protected WebElement membersTab;

    @FindBy(xpath = "//div/input[@placeholder='Enter username or email']")
    protected WebElement inputNewMemberUser;

    @FindBy(xpath = "//span/button[@type='submit']/span[contains(text(), 'Invite')]")
    protected WebElement inviteButton;

    @FindBy(xpath = "//div[@id='postFocus']/div[@class='extruder-toggler']/i[contains(text(),'')]")
    protected WebElement closeButton;

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

    public ContainerPage closeMembersCreationDialog(){
        closeButton.click();
        return new ContainerPage();
    }

    public void addNewMemberShip(String member){
        clickOnMembers();
        setNewMember(member);
        clickInviteMember();
        closeMembersCreationDialog();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputNewMemberUser));
    }
}
