package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebPage 
{
	public static WebElement homeBtn() {
		return $(By.xpath("//input[@name='q']"));
	}
	
	public static WebElement userTxt() {
		return $(By.id("step01"));
	}
	
	public static WebElement passTxt() {
		return $(By.id("step02"));
	}
	
	public static WebElement nextBtn() {
		return $(By.linkText("Siguiente"));
	}
	public static WebElement lastPaymentlbl() {
		return $(By.xpath("xpath=//div[@id='mainNoScroll']/icb-home/div/div/div/icb-dashboard-grid/div/div[2]/div/div/div[2]/icb-dashboard-transactions-history/icb-dashboard-item/div/div/div/span"));
	}
	public static WebElement paymentBtn() {
		return $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Transferir'])[2]/following::span[1]"));
	}
	public static WebElement creditCardPaymentBtn() {
		return $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Servicios'])[2]/following::span[2]"));
	}
	public static WebElement process2Btn() {
		return $(By.xpath("//icb-product-selector[@id='creditProductId']/div/icb-contextual-panel/div/div/div/div[4]/div/icb-list/div/div/div[2]/icb-listrow/div/div/div/icb-product-selector-row/div/div[2]/div[2]/icb-value-parser/div/icb-field-formatter/span"));
	}
	
	public static WebElement process3Btn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div/span/icb-toggle/div/div/label/div"));
	}

	public static WebElement anotherSesionBtn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-login/icb-modalpopup/div/div[7]/div/icb-button/a/span"));
	}
	public static WebElement calendar1Btn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div[2]/div/span[2]/a/i"));
	}
	public static WebElement dayBtn() {
		return $(By.linkText("18"));
	}
	public static WebElement monthBtn() {
		return $(By.linkText("Marzo"));
	}
	public static WebElement yearBtn() {
		return $(By.linkText("2022"));
	}

	public static WebElement frecuencyBtn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div[2]/div[2]/div/a"));
	}
	public static WebElement frecuencyOptionBtn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div[2]/div[2]/div/icb-contextual-panel/div/div/div/div[4]/icb-menuoptions/div/div[2]/div/a/h4/span[2]"));
	}
	public static WebElement FinalizaBtn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div[2]/div[4]/div/a/i"));
	}
	public static WebElement FinalizaOptionBtn() {
		return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div[2]/div[4]/div/icb-contextual-panel/div/div/div/div[4]/icb-menuoptions/div/div[2]/div/a"));
	}
	public static WebElement maxExecutionCount() {
		return $(By.name("maxExecutionCount"));
	}
	public static WebElement maxAmountTxt() {
		return $(By.xpath("//input[@name='']"));

		//return $(By.xpath("//div[@id='mainNoScroll']/icb-payment/div[2]/div[2]/icb-wizard/div/div/icb-wizard-step-one-by-one/div/div[2]/wizard-step-content/icb-payment-setup-step/icb-payment-setup/div/div/icb-wizard/div/wizard-multiple-content/div[2]/div/div[7]/icb-schedule-selector/div/div[2]/div[5]/span[2]/icb-textbox/div/div[2]/input"));
	}
	
	
	
	
}
