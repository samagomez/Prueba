package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class onboardingPage {

	public static WebElement greetingsLbl() {
		return $(By.xpath("//app-input-control-simple[@id='app-input-control-simple-2']/div/div/span[2]/span"));
	}
	public static WebElement firstText() {
		return $(By.xpath("//app-input-control-simple[@id='app-input-control-simple-4']/div/div/div/span"));
	}
	public static WebElement secondText() {
		return $(By.xpath("//app-input-control-simple[@id='app-input-control-simple-6']/div/div/span"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnFlat1651700018040"));
	}
	
}
