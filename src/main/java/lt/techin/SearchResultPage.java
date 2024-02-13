package lt.techin;

import lt.techin.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='js-product-list-header']")
    WebElement mySearchResultsText;

    @FindBy(xpath = "//*[@id='js-product-list']//h2/a")
    WebElement searchProductName;

    @FindBy(css = ".wishlist-button-add > .material-icons")
    WebElement clickAddToWishlistButton;

    @FindBy(css = ".show .modal-text")
    WebElement signInMessageText;

    @FindBy(css = ".show .btn-secondary")
    WebElement clickCancelButton;


    @FindBy(xpath = "//*[@id='js-product-list']//a/picture/img")
    WebElement clickOpenProductButton;


    public String getSearchResultsText() {
        return mySearchResultsText.getText();
    }

    public String getSearchProductName() {
        return searchProductName.getText();
    }

    public void clickAddToWishlistButton() {
        clickAddToWishlistButton.click();
    }

    public String getSignInMessageText() {
        return signInMessageText.getText();
    }

    public void clickCancelMessageButton() {
        waitForElement(clickCancelButton);
        clickCancelButton.click();
    }

    public void clickOpenProductButton() {
        clickOpenProductButton.click();
    }

}
