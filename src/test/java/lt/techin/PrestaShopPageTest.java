package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrestaShopPageTest extends BasePageTest {

    @Test
    void verifySearchProductFunctionality() {
        String searchProduct = "Hummingbird printed t-shirt";
        HomePage homePage = new HomePage(driver);
        homePage.enterSearch(searchProduct);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String actualText = searchResultPage.getSearchResultsText();
        String expectedText = "SEARCH RESULTS";
        assertEquals(expectedText, actualText);

        String actualNameText = searchResultPage.getSearchProductName();
        String expectedNameText = "Hummingbird Printed T-Shirt";
        assertEquals(expectedNameText, actualNameText);

        searchResultPage.clickOpenProductButton();

        OpenedSearchResultPage openedSearchResultPage = new OpenedSearchResultPage(driver);
        String actualOpenedSearchText = openedSearchResultPage.getOpenedSearchProductText();
        String expectedOpenedSearchText = "Regular fit, round neckline, short sleeves. Made of extra long staple pima cotton.";
        assertEquals(expectedOpenedSearchText, actualOpenedSearchText);
    }

    @Test
    void clickHearSymbolSelectSizeAndAddToCart() {
        String searchProduct = "Hummingbird printed t-shirt";
        HomePage homePage = new HomePage(driver);
        homePage.enterSearch(searchProduct);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOpenProductButton();

        searchResultPage.clickAddToWishlistButton();

        String actualProductText = searchResultPage.getSignInMessageText();
        String expectedProductText = "You need to be logged in to save products in your wishlist.";
        assertEquals(expectedProductText, actualProductText);

        searchResultPage.clickCancelMessageButton();

        OpenedSearchResultPage openedSearchResultPage = new OpenedSearchResultPage(driver);
        openedSearchResultPage.selectSizeButton();
        palaukti();
        String actualSizeText = openedSearchResultPage.getSelectedSizeButtonText();
        String expectedSizeText = "Size: XL";
        assertEquals(expectedSizeText, actualSizeText);

        openedSearchResultPage.clickAddToCartButton();
        palaukti();

        AddedToCartLabelPage addedToCartPage = new AddedToCartLabelPage(driver);
        String actualAddedProductLabelText = addedToCartPage.getSuccessAddedProductMessageText();
        String expectedAddedProductLabelText = "\uE876Product successfully added to your shopping cart";
        assertEquals(expectedAddedProductLabelText, actualAddedProductLabelText);

        addedToCartPage.clickProceedToCheckoutButton();
    }

    @Test
    void checkSuccessfullyAddedItemInCart() {

        String searchProduct = "Hummingbird printed t-shirt";
        HomePage homePage = new HomePage(driver);
        homePage.enterSearch(searchProduct);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOpenProductButton();

        searchResultPage.clickAddToWishlistButton();

        searchResultPage.clickCancelMessageButton();

        OpenedSearchResultPage openedSearchResultPage = new OpenedSearchResultPage(driver);
        openedSearchResultPage.selectSizeButton();
        palaukti();
        openedSearchResultPage.clickAddToCartButton();
        palaukti();
        AddedToCartLabelPage addedToCartLabelPage = new AddedToCartLabelPage(driver);
       addedToCartLabelPage.clickProceedToCheckoutButton();

        AddedToCartProductPage addedToCartProductPage = new AddedToCartProductPage(driver);
        String actualAddedItemNameText = addedToCartProductPage.getAddedItemText();
        String expectedAddedPItemText = "Hummingbird printed t-shirt";
        assertEquals(expectedAddedPItemText, actualAddedItemNameText);

        String actualAddedItemSizeText = addedToCartProductPage.getAddedItemSizeText();
        String expectedAddedPSizeText = "XL";
        assertEquals(expectedAddedPSizeText, actualAddedItemSizeText);

        String actualAddedItemDiscountext = addedToCartProductPage.getDiscountText();
        String expectedAddedItemDiscountText = "-20%";
        assertEquals(expectedAddedItemDiscountText, actualAddedItemDiscountext);
    }

    @ParameterizedTest
    @Timeout(10)
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void shouldUpdateItemParams(String product, double price, int discount, String size) {

        homePage.enterSearch(product);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOpenProductButton();
        searchResultPage.clickAddToWishlistButton();
        searchResultPage.clickCancelMessageButton();
        OpenedSearchResultPage openedSearchResultPage = new OpenedSearchResultPage(driver);
        openedSearchResultPage.selectSizeButton();
        openedSearchResultPage.clickAddToCartButton();
        AddedToCartLabelPage addedToCartPage = new AddedToCartLabelPage(driver);
        AddedToCartProductPage addedToCartProductPage = new AddedToCartProductPage(driver);
        addedToCartPage.clickProceedToCheckoutButton();
        double expectedProductPriceWithDiscount =  Math.round(price-(price*discount/100.0) * 100.0)/100.0;
        double actualProductPriceWithDiscount = addedToCartProductPage.getPriceWithDiscountText();
        assertEquals(expectedProductPriceWithDiscount, actualProductPriceWithDiscount, "");
    }
}





