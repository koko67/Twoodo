package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/13/2015.
 */
public class LeftPanelPage extends BasePageObject {

    @FindBy(xpath = "//div[@id='company-logo']/div[@class='dropdown' or @class='dropdown open']/button/img")
    WebElement dropDownCompany;

    @FindBy(xpath = "//div[@id='company-logo']//a[contains(text(), 'Company settings')]")
    WebElement buttonCompanySettings;

    @FindBy(xpath = "//div[@id='company-logo']//a[contains(text(), 'Manage teams')]")
    WebElement buttonManageCompanyTeams;

    @FindBy(xpath = "//div[@id='company-logo']//a[contains(text(), 'Manage members')]")
    WebElement buttonManageCompanyMembers;

    @FindBy(xpath = "//form[@id='main-search']/input[@id='inputMainSearch']")
    protected WebElement inputSearch;

    @FindBy(xpath = "//form[@id='main-search']/button[@type='submit']/i")
    protected WebElement buttonSearch;

    private LeftIntegrationPanel leftIntegrationPanel;
    private LeftTeamsPanel leftTeamsPanel;
    private LeftMembersPanel leftMembersPanel;

    public LeftPanelPage(){
        leftIntegrationPanel = new LeftIntegrationPanel();
        leftTeamsPanel = new LeftTeamsPanel();
        leftMembersPanel = new LeftMembersPanel();
    }

    public LeftPanelPage clickOnDropdownCompany(){
        dropDownCompany.click();
        return this;
    }

    public AccountMembersPage clickOnButtonCompanyMembers(){
        buttonManageCompanyMembers.click();
        return new AccountMembersPage();
    }

    public AccountsTeamsPage clickOnButtonCompanyTeams(){
        buttonManageCompanyTeams.click();
        return new AccountsTeamsPage();
    }

    public LeftPanelPage setTextToSearch(String textSearch){
        inputSearch.sendKeys(textSearch);
        return this;
    }

    public ContainerPage clickSearch(){
        buttonSearch.click();
        return new ContainerPage();
    }

    public ContainerPage selectACompanyByName(String companyName){
        try {
            dropDownCompany.findElement(By.xpath("../following-sibling::ul//span[contains(text(), '" + companyName + "')]")).click();
            return new ContainerPage();
        } catch (NoSuchElementException e) {
            System.out.println("element was not found...." + e.getMessage());
            return null;
        }
    }

    public LeftIntegrationPanel getLeftIntegrationPanel() {
        return leftIntegrationPanel;
    }

    public LeftTeamsPanel getLeftTeamsPanel() {
        return leftTeamsPanel;
    }

    public LeftMembersPanel getLeftMembersPanel() {
        return leftMembersPanel;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
