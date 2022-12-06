package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bowserFactory.Init;
import util.ADDCategoryANDDuplicate;
import util.VerifyMonths;

public class addCustomerTest {
	 WebDriver driver;
	//String insertCategoryName= "Tom";

	@Test
	@Parameters({"insertCategoryName"})
	public void monthsAddDuplicateCategoryTest(String insertCategoryName) {

		driver = Init.init();
		ADDCategoryANDDuplicate addAndDuplicate = PageFactory.initElements(driver, ADDCategoryANDDuplicate.class);
		 
	addAndDuplicate.validateUserableToaddCategory(insertCategoryName);
		 addAndDuplicate.validateUserNOTableToaddDuplicateCategory();
		 VerifyMonths verifymonths = PageFactory.initElements(driver, VerifyMonths.class);
			verifymonths.validateMonths();
			 Init.tearDown();
		
	}
}
