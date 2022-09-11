package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class nameCardPage {
	public static WebElement nameCardTitle() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-48\"]/div/div/div"));
	}
	public static WebElement cardImg() {
		return $(By.xpath("//*[@id=\"undefined\"]/div[2]/div/app-detalle-tarjeta/div/div/div/img"));
	}
	public static WebElement nameIndication() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-50\"]/div/div/mat-label"));
	}
	public static WebElement firstNameTitle() {
		return $(By.xpath("//*[@id=\"mat-radio-2\"]/label/span[2]"));
	}
	public static WebElement firstOptionName() {
		return $(By.xpath("//*[@id=\"mat-radio-2\"]/label/span[1]"));
	}
	public static WebElement secondNameTitle() {
		return $(By.xpath("//*[@id=\"mat-radio-3\"]/label/span[2]"));
	}
	public static WebElement secondOptionName() {
		return $(By.xpath("//*[@id=\"mat-radio-3\"]/label/span[1]"));
	}
	public static WebElement thirdNameTitle() {
		return $(By.xpath("//*[@id=\"mat-radio-4\"]/label/span[2]"));
	}
	public static WebElement thirdOptionName() {
		return $(By.xpath("//*[@id=\"mat-radio-4\"]/label/span[1]"));
	}
	public static WebElement fourthNameTitle() {
		return $(By.xpath("//mat-radio-button[@id='mat-radio-5']/label/span[2]"));
	}
	public static WebElement fourthOptionName() {
		return $(By.xpath("//mat-radio-button[@id='mat-radio-5']/label/span/span"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnFlat1654796644073"));
	}
}
