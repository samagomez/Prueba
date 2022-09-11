package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class contactlessPage {
	public static WebElement contactlessTitle() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-40\"]/div/div/div"));
	}
	public static WebElement contactlessDescription() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-42\"]/div/div/span[2]"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnStroked1655392483727"));
	}
}
