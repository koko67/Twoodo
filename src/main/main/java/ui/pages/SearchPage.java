package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/17/2015.
 */
public class SearchPage extends BasePageObject{

    @FindBy(xpath = "//form[@id='main-search']/input[@id='inputMainSearch']")
    protected WebElement inputSearch;

    @FindBy(xpath = "//form[@id='main-search']/button[@type='submit']/i")
    protected WebElement buttonSearch;

    public SearchPage setTextToSearch(String textSearch){
        inputSearch.sendKeys(textSearch);
        return this;
    }

    public ContainerPage clickSearch(){
        buttonSearch.click();
        return new ContainerPage();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputSearch));
    }
}
