package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartLabelPage extends BasePage{
    public AddedToCartLabelPage(WebDriver driver) {
        super(driver);
    }

   @FindBy(xpath = "/html//h4[@id='myModalLabel']")
    WebElement addedProductSuccessMessage;

    @FindBy(css = ".modal-body .btn.btn-primary")
    WebElement clickProceedToCheckoutButton;

    public String getSuccessAddedProductMessageText() {
        return addedProductSuccessMessage.getText();
    }

    public void clickProceedToCheckoutButton() {
        waitForElement(clickProceedToCheckoutButton);
        clickProceedToCheckoutButton.click();
    }
}
