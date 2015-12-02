package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;


/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftMembersPanel extends BasePageObject {

    @FindBy(xpath = "//div[@class='section']/a[@class='title' and contains(text(),'Direct messages')]/..")
    WebElement membersPanel;

    @FindBy(xpath = "//menu-left[@id='menu-left-content']//div/a[contains(text(), 'Add a teammate')]")
    WebElement buttonAddTeamMate;

    private static String memberXpath = "//menu-left[@id='menu-left-content']//a[contains(text(), 'Teams')]/following-sibling::a[.//span[contains(text(),'#member#')]]";

    WebElement member;

    public ContainerPage clickSelectAMember(String teamName){
        member = getMemberWebElementByName(teamName);
        member.click();
        return new ContainerPage();
    }

    public AccountMembersPage clickCreateNewMemberInTheCompany(){
        buttonAddTeamMate.click();
        return new AccountMembersPage();
    }

    public boolean existsNotificationFromAMember(String teamName){
        member = getMemberWebElementByName(teamName);
        return member.getText() != "" || member.getText() != null;
    }

    private String constructXpath(String name){
        String teamXpathText = memberXpath.replace("#member#", name);
        return teamXpathText;
    }

    private WebElement getMemberWebElementByName(String teamName){
        try {
            return membersPanel.findElement(By.xpath(constructXpath(teamName)));
        } catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
