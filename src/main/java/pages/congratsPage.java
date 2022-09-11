package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class congratsPage {
	public static WebElement congratsImg() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-122\"]/div/img"));
	}
	public static WebElement firstText() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-126\"]/div/div/div"));
	}
	public static WebElement email() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-132\"]/div/div/span[2]"));
	}
	public static WebElement cellphone() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-136\"]/div/div/span[2]"));
	}
	public static WebElement updateDataLink() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-140\"]/div/div/div/a"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnFlat1658423448655"));
	}
	
}
