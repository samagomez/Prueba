
import org.testng.annotations.Test;
import static driver.DriverManager.DRIVER;

import com.codeborne.selenide.WebDriverRunner;

import pages.addressPage;
import pages.agreementPage;
import pages.congratsPage;
import pages.contactlessPage;
import pages.nameCardPage;
import pages.onboardingPage;
import pages.productsPage;
import util.ScreenUtilsWeb;

public class WebLocal extends BaseClass {
	
	Boolean result;
	@Test(priority = 1) 	
	public void GuatemalaPreApproved() throws InterruptedException {
		ComplementUrl = ScreenUtilsWeb.getTokenGT(BaseUriUrl, CodAgencia, Channel, Username, View, Application, UsernameBa, PasswordBa, GetToken, SuscriptionID);
		WebDriverRunner.setWebDriver(DRIVER.getURL(WebUrl+ComplementUrl));
	}
	
	@Test(priority = 2)
	public void onboardingTest() throws InterruptedException {
		validateElementsOnboardingPage();
		onboardingPage.continueBtn().click();
	}
	
	@Test(priority = 3)
	public void productsTest() throws InterruptedException {
		validateElementsProductsPage();
		productsPage.contactlessBtn().click();
		validateElementsContactlessPage();
		contactlessPage.continueBtn().click();
		productsPage.continueBtn().click();
	}
	@Test(priority = 4)
	public void nameCardTest() throws InterruptedException {
		validateElementsNameCardPage();
		nameCardPage.secondOptionName().click();
		nameCardPage.continueBtn().click();
	}
	@Test(priority = 5)
	public void agreementTest() throws InterruptedException {
		validateElementsAgreementPage();
		agreementPage.continueBtn().click();
	}
	@Test(priority = 6)
	public void addressTest() throws InterruptedException {
		validateElementsAddressPage();
		addressPage.firstRadioOption().click();
		addressPage.continueBtn().click();
	}
	@Test(priority = 7)
	public void CongratsTest() throws InterruptedException {
		validateElementsCongratsPage();
		congratsPage.continueBtn().click();
	}
	
	public void validateElementsOnboardingPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(onboardingPage.greetingsLbl());
		ScreenUtilsWeb.waitForVisibility(onboardingPage.firstText());
		ScreenUtilsWeb.waitForVisibility(onboardingPage.secondText());
		ScreenUtilsWeb.waitForVisibility(onboardingPage.continueBtn());
	}
	public void validateElementsProductsPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(productsPage.pageTitle());
		ScreenUtilsWeb.waitForVisibility(productsPage.productDescription());
		ScreenUtilsWeb.waitForVisibility(productsPage.cardImg());
		ScreenUtilsWeb.waitForVisibility(productsPage.benefitsDescription());
		ScreenUtilsWeb.waitForVisibility(productsPage.continueBtn());
	}
	public void validateElementsContactlessPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(pages.contactlessPage.contactlessTitle());
		ScreenUtilsWeb.waitForVisibility(pages.contactlessPage.contactlessDescription());
		ScreenUtilsWeb.waitForVisibility(pages.contactlessPage.continueBtn());
	}
	public void validateElementsAgreementPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(agreementPage.agreementTitle());
		ScreenUtilsWeb.waitForVisibility(agreementPage.imageCard());
		ScreenUtilsWeb.waitForVisibility(agreementPage.nameCard());
		ScreenUtilsWeb.waitForVisibility(agreementPage.limitApproved());
		ScreenUtilsWeb.waitForVisibility(agreementPage.benefits());
		ScreenUtilsWeb.waitForVisibility(agreementPage.rate());
		ScreenUtilsWeb.waitForVisibility(agreementPage.continueBtn());
	}
	
	public void validateElementsNameCardPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(nameCardPage.nameCardTitle());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.cardImg());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.firstNameTitle());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.firstOptionName());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.secondNameTitle());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.secondOptionName());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.thirdNameTitle());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.thirdOptionName());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.fourthNameTitle());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.fourthOptionName());
		ScreenUtilsWeb.waitForVisibility(nameCardPage.continueBtn());
		
	}
	public void validateElementsAddressPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(addressPage.addressTitle());
		ScreenUtilsWeb.waitForVisibility(addressPage.imageCard());
		ScreenUtilsWeb.waitForVisibility(addressPage.firstTitleOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.firstRadioOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.secondTitleOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.secondRadioOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.thirdTitleOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.thirdRadioOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.fourthTitleOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.fourthRadioOption());
		ScreenUtilsWeb.waitForVisibility(addressPage.continueBtn());
	}
	
	public void validateElementsCongratsPage() throws InterruptedException {
		ScreenUtilsWeb.waitForVisibility(congratsPage.congratsImg());
		ScreenUtilsWeb.waitForVisibility(congratsPage.firstText());
		ScreenUtilsWeb.waitForVisibility(congratsPage.email());
		ScreenUtilsWeb.waitForVisibility(congratsPage.cellphone());
		ScreenUtilsWeb.waitForVisibility(congratsPage.updateDataLink());
		ScreenUtilsWeb.waitForVisibility(congratsPage.continueBtn());	
	}
}
