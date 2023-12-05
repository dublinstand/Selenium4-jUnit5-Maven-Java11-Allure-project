import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTest extends BaseTest{

    @Test
    @Description("Check Filters form fields, checkboxes, minimum and maximum values, Amenities boxes" +
            "Clear all is functional, check buttons without clicking Apply")
    public void shouldVerifyCorrectFilteringResults() {
        mainPage.navigate()
                .clickSearchField()
                .onSearchPage()
                .enterBookingDates("1", "20")
                .onFilterPage();

        filterForm.fillAllFieldsUseRoomsAndBedsCheckAllBoxes("888", "8888")
                .clickClearAll();
    }

    @Test
    @Description("Check that the listings on the page are exact number as the All label")
    public void shouldAllListingTableHaveExactAmountAsListingsOnScreen() {
        //Arrange (navigate)
        //Act (scrollDownToBottom)
        allListingsPage.navigate()
                .scrollDownToBottom();
        //Assert
        assertTrue(allListingsPage.verifyListingsOnScreenComparedToAllFieldValue(),
                "Verifying all listings on the page have same count as the All Label value");
    }
}
