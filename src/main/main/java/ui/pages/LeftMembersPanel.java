package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftMembersPanel extends LeftPanelPage {

    @FindBy(xpath = "//div[@class='section']/a[@class='title' and contains(text(),'Direct messages')]/..")
    WebElement membersPanel;

    public final static String ADD_TEAMMATE = "Add a teammate";

    public ManageMembersPage clickCreateNewMemberInTheCompany() throws InterruptedException {
        Thread.sleep(2000);
        clickElementForCreationByText(ADD_TEAMMATE);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new ManageMembersPage();
    }

    public ContainerPage clickSelectAMember(String teamName){
        clickElementForSelectionByText(teamName);
        return new ContainerPage();
    }

    public boolean existsNotification() {
        return membersPanel.findElement(By.xpath("//a/span[contains(text(), '1')]")) != null;
    }
}
