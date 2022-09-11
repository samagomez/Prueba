package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class productsPage {

	public static WebElement pageTitle() {
		return $(By.xpath("//app-input-control-simple[@id='app-input-control-simple-28']/div/div/div"));
	}
	public static WebElement swipeProductContainer() {
		return $(By.xpath("//app-input-control-slidertarjeta[@id='app-form-control-custom-0']/div/swiper"));
	}
	public static WebElement cardSlider() {
		return $(By.xpath("//div[@id='cardSlider']/div/div"));
	}
	public static WebElement cardImg() {
		return $(By.xpath("//img[contains(@src,'https://pfctieausdevsql01.blob.core.windows.net/gt-onboarding/5900.webp')]"));
	}
	public static WebElement productTitle() {
		return $(By.xpath("//app-input-control-slidertarjeta[@id='app-form-control-custom-0']/div/section/div/h4"));
	}
	public static WebElement productDescription() {
		return $(By.xpath("//app-input-control-slidertarjeta[@id='app-form-control-custom-0']/div/section/div/div/div"));
	}
	public static WebElement contactlessBtn() {
		return $(By.xpath("//span[@id='contactless']/app-custom-tag/a/strong"));
	}
	public static WebElement benefitsDescription() {
		return $(By.xpath("//app-input-control-slidertarjeta[@id='app-form-control-custom-0']/div/section/div[2]/div/div/div"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnFlat1651857686813"));
	}
}
