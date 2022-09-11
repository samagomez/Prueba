package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class addressPage {

	public static WebElement addressTitle() {
		return $(By.xpath("//app-input-control-simple[@id='app-input-control-simple-114']/div/div/div"));
	}
	public static WebElement imageCard() {
		return $(By.xpath("//img[contains(@src,'https://pfctieausdevsql01.blob.core.windows.net/gt-onboarding/5900.webp')]"));
	}
	public static WebElement firstTitleOption() {
		return $(By.xpath("//mat-radio-group[@id='dataSquareDirecciones']/div/div/div[3]/div[2]/div/span"));
	}
	public static WebElement firstRadioOption() {
		return $(By.xpath("//*[@id=\"mat-radio-7\"]/label/span[1]"));
	}
	public static WebElement secondTitleOption() {
		return $(By.xpath("//mat-radio-group[@id='dataSquareDirecciones']/div[2]/div/div[3]/div[2]/div/span"));
	}
	public static WebElement secondRadioOption() {
		return $(By.xpath("//*[@id=\"mat-radio-8\"]/label/span[1]/span[1]"));
	}
	public static WebElement thirdTitleOption() {
		return $(By.xpath("//mat-radio-group[@id='dataSquareDirecciones']/div[3]/div/div[3]/div[2]/div/span"));
	}
	public static WebElement thirdRadioOption() {
		return $(By.xpath("//*[@id=\"mat-radio-9\"]/label/span[1]/span[1]"));
	}
	public static WebElement fourthTitleOption() {
		return $(By.xpath("//mat-radio-group[@id='dataSquareDirecciones']/div[4]/div/div[3]/div[2]/div/span"));
	}
	public static WebElement fourthRadioOption() {
		return $(By.xpath("//*[@id=\"mat-radio-10\"]/label/span[1]/span[1]"));
	}
	public static WebElement continueBtn() {
		return $(By.id("btnFlat1652817250723"));
	}
}
