package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftMembersPanel extends LeftPanelPage {

    public final static String ADD_TEAMMATE = "Add a teammate";

    @FindBy(xpath = "//div[@class='section']/a[@class='title' and contains(text(),'Direct messages')]/..")
    WebElement membersPanel;

    private static String memberXpath = "//menu-left[@id='menu-left-content']//a[contains(text(), 'Teams')]/following-sibling::a[.//span[contains(text(),'#member#')]]";

    WebElement member;


    public AccountMembersPage clickCreateNewMemberInTheCompany() throws InterruptedException {
        Thread.sleep(2000);
        clickElementForCreationByText(ADD_TEAMMATE);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new AccountMembersPage();
    }

    public ContainerPage clickSelectAMember(String teamName){
        clickElementForSelectionByText(teamName);
        return new ContainerPage();
    }

    public ContainerPage clickSelectATeam(String teamName){
        member = getMemberWebElementByName(teamName);
        member.click();
        return new ContainerPage();
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
}
