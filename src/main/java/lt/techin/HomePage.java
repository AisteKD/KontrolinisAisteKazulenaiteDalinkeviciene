package lt.techin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='s']")
    WebElement inputSearch;

    public void enterSearch(String searchText){
        inputSearch.sendKeys(searchText + Keys.ENTER);
    }

}
