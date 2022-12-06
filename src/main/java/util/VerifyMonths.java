package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VerifyMonths {
	
	WebDriver driver;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement monthList;

	public VerifyMonths(WebDriver driver) {

		this.driver = driver;
	}

	public void validateMonths() {

		String[] expected = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		Select sel = new Select(monthList);
		List<WebElement> options = sel.getOptions();
		for (WebElement actual : options) {
			// Assert.assertEquals(actual.getText(), expected);
			boolean match = false;
			for (int i = 0; i < expected.length; i++) {
				if (actual.getText().equals(expected[i])) {
					match = true;

				}

			}

			Assert.assertTrue(match);

		}
	}
}
