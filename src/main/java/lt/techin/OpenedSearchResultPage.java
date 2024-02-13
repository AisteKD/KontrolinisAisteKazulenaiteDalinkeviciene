package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class OpenedSearchResultPage extends BasePage{
    public OpenedSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='product-description-short-1']/p[1]")
    WebElement openSearchProductText;

    @FindBy(xpath = "//*[@id='group_1']")
    WebElement selectSizeChooseButton;

    @FindBy(css = "div:nth-of-type(1) > .control-label")
    WebElement sizeSelectedText;

    @FindBy(css = ".add-to-cart.btn.btn-primary")
    WebElement clickAddToCartButton;

    public String getOpenedSearchProductText() {
        return openSearchProductText.getText();
    }

    public String getSelectedSizeButtonText() {
        waitForElement(sizeSelectedText);
        waitForElement(sizeSelectedText);
        return sizeSelectedText.getText();
    }

    public void selectSizeButton() {
        waitForElement(selectSizeChooseButton);
        waitForElement(selectSizeChooseButton);
        waitForElement(selectSizeChooseButton);
        Select select = new Select(selectSizeChooseButton);
        select.selectByVisibleText("XL");
    }

    public void clickAddToCartButton() {
        waitForElement(clickAddToCartButton);
        waitForElement(clickAddToCartButton);
        waitForElement(clickAddToCartButton);
        clickAddToCartButton.click();
    }


}
