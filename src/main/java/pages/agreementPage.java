package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class agreementPage {

	public static WebElement agreementTitle() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-60\"]/div/div/div"));
	}
	public static WebElement imageCard() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-64\"]/div/img"));
	}
	public static WebElement nameCard() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-68\"]/div/div/span[2]"));
	}
	public static WebElement limitApproved() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-74\"]/div/div/span"));
	}
	public static WebElement rate() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-80\"]/div/div/span[2]"));
	}
	public static WebElement benefits() {
		return $(By.xpath("//*[@id=\"app-input-control-simple-86\"]/div/div/div/ul/li"));
	}
	public static WebElement checkBoxAcceptAgreement() {
		return $(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnAcceptDocuments"));
	}
	
}
