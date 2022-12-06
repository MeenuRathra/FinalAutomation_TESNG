package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ADDCategoryANDDuplicate extends Base {
	WebDriver driver;
	String insertedname;
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement InsertnameCategory;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement Addcategory;
	@FindBy(how = How.LINK_TEXT, using = "Nevermind")
	WebElement nevermind;

	public ADDCategoryANDDuplicate(WebDriver driver) {
		this.driver = driver;

	}

	public void validateUserableToaddCategory(String insertCategoryName) {
		insertedname = insertCategoryName + generateRandomNum(589);
		InsertnameCategory.sendKeys(insertedname);
		Addcategory.click();
		if (driver.getPageSource().contains(insertedname)) {
			System.out.println("inserted name is present");
		} else {
			System.out.println("inserted name not present ");
		}
	}

	public void validateUserNOTableToaddDuplicateCategory() {

		InsertnameCategory.sendKeys(insertedname);
		Addcategory.click();
		if (driver.getPageSource().contains(insertedname)) {
			System.out.println("The category you want to add already exists:" + insertedname);
		}
		driver.findElement(By.linkText("Nevermind")).click();
	}

}