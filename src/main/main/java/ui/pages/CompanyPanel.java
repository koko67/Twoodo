package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class CompanyPanel extends BasePageObject{

    @FindBy(xpath = "//div[@id='company-logo']/div[@class='dropdown']/button/img")
    private WebElement buttonCompany;

    @FindBy(xpath = "//ul[@class='dropdown-menu' and @role='menu']/li/a[contains(text(), 'Manage members')]")
    private WebElement buttonManageMembers;

    public CompanyPanel clickCompanyButton(){
        buttonCompany.click();
        return this;
    }

    public AccountMembersPage clickManageMembers(){
        buttonManageMembers.click();
        return new AccountMembersPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(buttonCompany));
    }
}
