package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartProductPage extends BasePage {
    public AddedToCartProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-id_customization]")
    WebElement checkIfItemIsAddedText;

    @FindBy(css = ".size .value")
    WebElement checkIfItemSizeIsCorrect;

    @FindBy(css = ".discount-percentage")
    WebElement checkIfDisccountIsCorrectly;

    @FindBy(css = ".current-price .price")
    WebElement priceWithDiscunt;

    public String getAddedItemText() {
        return checkIfItemIsAddedText.getText();
    }

    public String getAddedItemSizeText() {
        return checkIfItemSizeIsCorrect.getText();
    }

    public String getDiscountText() {
        return checkIfDisccountIsCorrectly.getText();
    }

    public double getPriceWithDiscountText() {
        String string =priceWithDiscunt.getText();
        return Double.parseDouble(string.replaceAll("[$]", ""));
    }
}
