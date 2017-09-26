package com.bjss.traffic.stepdefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bjss.traffic.config.WebDriverConfig;
import com.bjss.traffic.pageobjects.TrafficPO;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;
import io.selendroid.SelendroidLauncher;
import io.selendroid.common.SelendroidCapabilities;

public class TrafficStepDef {

	private static WebDriver drivers;
	private static boolean initializeda = false;

	@Before
	public TrafficPO setUpPageObject() throws Exception {
		if (!initializeda) {
			initializeda = true;
			drivers = new WebDriverConfig().setUpSelendroid();
			drivers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try {
				if (drivers != null)
					initializeda = true;
			} catch (Exception e) {
				throw new Exception(e);
			}
			
			try {
				setUpPageObject().createLogFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		TrafficPO userAuthPO2 = PageFactory.initElements(drivers, TrafficPO.class);
		return userAuthPO2;

	}

	@Given("^User is not already logged in$")
	public void user_is_not_already_logged_in() throws Throwable {
		setUpPageObject().initUsername();
		setUpPageObject().initUserPin();
	}

	@When("^The user keeps username blank$")
	public void the_user_keeps_username_blank() throws Throwable {
		setUpPageObject().initUsername();
	}

	@When("^The user keeps pin blank$")
	public void the_user_keeps_pin_blank() throws Throwable {
		setUpPageObject().initUserPin();
	}

	@Then("^Login button should be disabled$")
	public void login_button_should_be_disabled() throws Throwable {
		setUpPageObject().checkLoginButtonDisabled();
	}

	@Then("^Login button should be enabled$")
	public void login_button_should_be_enabled() throws Throwable {
		setUpPageObject().checkLoginButtonEnabled();
	}

	@When("^User enters their unique \"([^\"]*)\"$")
	public void user_enters_their_unique(String userId) throws Throwable {
		setUpPageObject().enterUserId(userId);
		/*
		 * driver = selendroid.setUpSelendroid();
		 * 
		 * WebElement userName = (new WebDriverWait(driver, 30))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.id(
		 * "login_edit_username")));
		 * 
		 * userName = driver.findElement(By.id("login_edit_username"));
		 * Assert.assertEquals("true", userName.getAttribute("enabled"));
		 * userName.clear(); //userName.sendKeys("Maurizio");
		 * userName.sendKeys("UseR");
		 */
	}

	@When("^User enters their \"([^\"]*)\"$")
	public void user_enters_their(String pin) throws Throwable {
		/*
		 * WebElement password =
		 * driver.findElement(By.id("login_edit_password"));
		 * Assert.assertEquals("true", password.getAttribute("enabled"));
		 * password.clear(); //password.sendKeys("password");
		 * password.sendKeys("PreCom4!");
		 */
		/*
		 * UserAuthenticationPO userAuthPO = PageFactory.initElements(driver,
		 * UserAuthenticationPO.class);
		 */
		setUpPageObject().enterUserPin(pin);

	}

	@When("^User proceeds to login$")
	public void user_proceeds_to_login() throws Throwable {
		/*
		 * // dismiss the keyboard new
		 * Actions(driver).sendKeys(SelendroidKeys.ENTER).perform();
		 * 
		 * WebElement button = driver.findElement(By.id("login_btn_login"));
		 * 
		 * button.click();
		 */
		/*
		 * UserAuthenticationPO userAuthPO = PageFactory.initElements(driver,
		 * UserAuthenticationPO.class);
		 */
		setUpPageObject().clickLoginButton();
	}

	@Then("^User should be logged in successfully$")
	public void user_should_be_logged_in_successfully() throws Throwable {
		setUpPageObject().verifyLoginSuccess();
		setUpPageObject().loginLogout();
	}

	@Then("^User should not be logged on$")
	public void user_should_not_be_logged_on() throws Throwable {
		setUpPageObject().checkLoginButtonDisabled();
	}

	@Given("^The user logs out$")
	public void the_user_logs_out() throws Throwable {
		setUpPageObject().loginLogout();
	}

	@Then("^User should return to the login screen$")
	public void user_should_return_to_the_login_screen() throws Throwable {
		setUpPageObject().checkLoginButtonDisabled();
	}

	@When("^The user enters atleast one character username$")
	public void user_enters_atleast_one_character_username() throws Exception {
		setUpPageObject().enterUserId("a");
	}

	@When("^The user enters atleast one digit pin$")
	public void user_enters_atleast_one_digit_pin() throws Exception {
		setUpPageObject().enterUserPin("1");
	}

	@Given("^The user has logged on with their username \"([^\"]*)\" and pin \"([^\"]*)\"$")
	public void the_user_has_logged_on_with_their_username_and(String userId, String pin) throws Throwable {
		setUpPageObject().enterUserId(userId);
		setUpPageObject().enterUserPin(pin);
		setUpPageObject().clickLoginButton();
	}

	@When("^The user is on the shift details page$")
	public void the_user_is_on_the_shift_details_page() throws Throwable {
		setUpPageObject().verifyLoginSuccess();
	}

	@When("^Mail format has been completed for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void mail_format_has_been_completed_for_and(String workArea, String mailFormat) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		// setUpPageObject().selectMailFormat(mailFormat);
	}

	@Then("^User should be able to view a list of mail item classes for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_to_view_a_list_of_mail_item_classes(String workAreaId, String mailFormat)
			throws Throwable {
		// setUpPageObject().checkMailClassText();
		setUpPageObject().validateMailClasss(workAreaId, mailFormat);
		setUpPageObject().loginLogout();
	}

	@Then("^They should be able to view \"([^\"]*)\" payment types and select$")
	public void they_should_be_able_to_view_payment_types_and_select(String paymentType) throws Throwable {
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().loginLogout();
	}

	@When("^Mail Item Class is more than one$")
	public void mail_Item_Class_is_more_than_one() throws Throwable {
		setUpPageObject().countMailClass();
	}

	@Then("^They should be able to view a list of site location names$")
	public void they_should_be_able_to_view_a_list_of_site_location_names() throws Throwable {
		setUpPageObject().validateLocationList();
	}

	@Then("^Select the site location name they are working from$")
	public void select_the_site_location_name_they_are_working_from() throws Throwable {
		setUpPageObject().selectLocation();
		setUpPageObject().loginLogout();
	}

	@Then("^They should be able to view a list of work area names$")
	public void they_should_be_able_to_view_a_list_of_work_area_names() throws Throwable {
		setUpPageObject().selectRandomLocation();
		setUpPageObject().validateWorkAreaList();
	}

	@Then("^select the appropriate work area based on reference data$")
	public void select_the_appropriate_work_area_based_on_reference_data() throws Throwable {
		setUpPageObject().selectWorkArea();
		setUpPageObject().loginLogout();
	}

	@When("^The user selects full shift details$")
	public void the_user_selects_full_shift_details() throws Throwable {
		setUpPageObject().validateLocationList();
		setUpPageObject().selectLocation();
		setUpPageObject().validateWorkAreaList();
		setUpPageObject().selectWorkArea();
	}

	@Then("^The confirm button should be enabled$")
	public void the_confirm_button_should_be_enabled() throws Throwable {
		setUpPageObject().checkShiftButtonEnabled();
		setUpPageObject().loginLogout();
	}

	@When("^The user partially selects shift details$")
	public void the_user_partially_selects_shift_details() throws Throwable {
		setUpPageObject().validateLocationList();
		setUpPageObject().selectLocation();
	}

	@Then("^The confirm button should be disabled$")
	public void the_confirm_button_should_be_disabled() throws Throwable {
		setUpPageObject().checkShiftButtonDisabled();
		setUpPageObject().loginLogout();
	}

	@When("^The user has selected a location \"([^\"]*)\"$")
	public void the_user_has_selected_a_location(String siteLocation) throws Throwable {
		setUpPageObject().selectSpecificLocation(siteLocation);
	}

	@Given("^The user has selected a \"([^\"]*)\"$")
	public void the_user_has_selected_a(String workArea) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
	}

	@Given("^The user has selected a location \"([^\"]*)\" and workarea \"([^\"]*)\"$")
	public void the_user_has_selected_a_location_and_workarea(String siteLocation, String workArea) throws Throwable {
		setUpPageObject().selectSpecificLocation(siteLocation);
		setUpPageObject().selectSpecificWorkArea(workArea);
	}

	@When("^The user is in the capture attributes page$")
	public void the_user_is_in_the_capture_attributes_page() throws Throwable {

	}

	@Then("^The mail format options should be derived by the \"([^\"]*)\"$")
	public void the_mail_format_options_should_be_derived_by_the_work_area(String workArea) throws Throwable {
		setUpPageObject().validateMailFormats(workArea);
		setUpPageObject().loginLogout();
	}

	@When("^The mail format only has one option$")
	public void the_mail_format_only_has_one_option() throws Throwable {

	}

	@Then("^It should be selected by default$")
	public void it_should_be_selected_by_default() throws Throwable {
		setUpPageObject().validateMailClassAutoSelect();
		setUpPageObject().loginLogout();
	}

	@When("^Mail format has been completed for only \"([^\"]*)\"$")
	public void mail_format_has_been_completed_for_only(String workArea) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
	}

	@Then("^The mail item class should be automatically populated with \"([^\"]*)\"$")
	public void the_mail_item_class_should_be_automatically_populated_with(String mailClass) throws Throwable {
		setUpPageObject().checkMailClassField(mailClass);
		setUpPageObject().loginLogout();
	}

	@Given("^The user has logged on with their \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_has_logged_on_with_their_and(String userId, String pin) throws Throwable {
		setUpPageObject().enterUsername(userId);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
	}

	@When("^The user populates the required fields \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_populates_the_required_fields(String workArea, String paymentType) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
	}

	@When("^The user populates the required fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_populates_the_required_fields(String workArea, String paymentType, String mailClass)
			throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectMailClass(mailClass);
		setUpPageObject().selectPaymentType(paymentType);

	}

	@When("^The user populates the required stream prerequisites \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_populates_the_required_stream_prerequisites(String workArea, String paymentType,
			String subMailType) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);

	}

	@When("^The user populates the required destination location prerequisites \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_populates_the_required_destination_location_prerequisites(String workArea, String mailFormat, String mailClass, String paymentType, String subMailType) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectMailFormat(mailFormat);
		setUpPageObject().selectMailClass(mailClass);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);

	}

	@When("^The user populates the required delivery out prerequisites \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_populates_the_required_delivery_out_prerequisites(String workArea, String mailFormat,
			String subMailType) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectMailFormat(mailFormat);
		setUpPageObject().selectSubMailType(subMailType);

	}

	@Then("^The destination location dropdown should be present on page capture attributes page$")
	public void the_destination_location_dropdown_should_be_present_on_page_capture_attributes_page() throws Throwable {
		setUpPageObject().checkDestionLocation();
		setUpPageObject().loginLogout();
	}

	@When("^Submail Type should be automatically populated with \"([^\"]*)\"$")
	public void submail_type_should_be_automatically_populated_with(String subMailType) throws Throwable {
		setUpPageObject().checkSubMailTypeField(subMailType);
		setUpPageObject().loginLogout();
	}

	@When("^Stream name should be automatically populated \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void stream_name_should_be_automatically_populated(String workAreaId, String paymentType, String subMailType)
			throws Throwable {
		setUpPageObject().checkStreamIdField(workAreaId, paymentType, subMailType);
		setUpPageObject().loginLogout();
	}

	@Then("^The user can view the selectable list of SubMail Types \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_can_view_the_selectable_list_of_SubMail_Types(String workArea, String mFormat,
			String mailClass, String paymentType) throws Throwable {
		setUpPageObject().validateSubMailType(workArea, mFormat, mailClass, paymentType);
		setUpPageObject().loginLogout();
	}

	@Then("^Submail Type should be automatically populated \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void submail_type_should_be_automatically_populated(String workArea, String mFormat, String mailClass,
			String paymentType, String subMailType) throws Throwable {
		setUpPageObject().selectNonValidatedLocation();
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().loginLogout();
	}

	@Then("^The user id should be available in the menu$")
	public void the_user_id_should_be_available_in_the_menu() throws Throwable {
		setUpPageObject().validateUserId();
		setUpPageObject().loginLogout();
	}

	@When("^The traffic recorder makes a selection$")
	public void the_traffic_recorder_makes_a_selection() throws Throwable {
		setUpPageObject().selectDestinationLocation();
	}

	@Then("^the selection should populate the destination field$")
	public void the_selection_should_populate_the_destination_field() throws Throwable {
		setUpPageObject().checkDestLocationMatchSelection();
		setUpPageObject().loginLogout();
	}

	@When("^The traffic recorder selects \"([^\"]*)\"$")
	public void the_traffic_recorder_selects(String subWorkArea) throws Throwable {
		 //setUpPageObject().selectInterceptDirect();
	}

	/*
	 * @Then("^A Delivery office dropdown should be present on page capture attributes page$"
	 * ) public void
	 * a_Delivery_office_dropdown_should_be_present_on_page_capture_attributes_page
	 * () throws Throwable { setUpPageObject().checkDeliveryOfficeField();
	 * setUpPageObject().loginLogout(); }
	 */

	@Then("^The a Delivery office dropdown selection should be derived by site location \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_a_Delivery_office_dropdown_selection_should_be_derived_by_site_location(String mailFormat,
			String subMailType) throws Throwable {
		//setUpPageObject().selectMailFormat(mailFormat);
		//setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().checkSiteDO();
		setUpPageObject().loginLogout();
	}

	@When("^The traffic recorder selects a delivery office \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_traffic_recorder_selects_a_delivery_office(String mailFormat, String subMailType) throws Throwable {
		//setUpPageObject().selectMailFormat(mailFormat);
		//setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().selectDeliveryOffice();
	}

	@When("^The traffic recorder selects an intercept delivery office \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_traffic_recorder_selects_an_intercept_delivery_office(String mailFormat, String subMailType) throws Throwable {
		setUpPageObject().selectMailFormat(mailFormat);
        setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().selectDeliveryOffice();
	}
	
	@Then("^The selection should populate the field$")
	public void the_selection_should_populate_the_field() throws Throwable {
		setUpPageObject().checkDeliOfficeField();
		setUpPageObject().loginLogout();
	}

	@Then("^The Traffic recorder should be able to select Scan Containers or Abnormal Posting button$")
	public void the_Traffic_recorder_should_be_able_to_select_Scan_Containers_or_Abnormal_Posting_button()
			throws Throwable {
		setUpPageObject().abnormalButtonEnabled();
		setUpPageObject().scanButtonEnabled();
		setUpPageObject().loginLogout();
	}

	@When("^The user selects the back button on the physical device$")
	public void the_user_selects_the_back_button_on_the_physical_device() throws Throwable {
		setUpPageObject().goBack();

	}

	@Then("^The app should skip the \"([^\"]*)\" default field and clear the field before$")
	public void the_app_should_skip_the_default_field_and_clear_the_field_before(String workArea) throws Throwable {
		setUpPageObject().clearScreen(workArea);
		setUpPageObject().loginLogout();
	}

	@Then("^All \"([^\"]*)\" attributes on the page should clear except the default attributes when the page first loads$")
	public void all_attributes_on_the_page_should_clear_except_the_default_attributes_when_the_page_first_loads(
			String workArea) throws Throwable {
		setUpPageObject().clearScreen(workArea);
		setUpPageObject().loginLogout();
	}

	@Then("^One \"([^\"]*)\" field should clear$")
	public void one_field_should_clear(String workArea) throws Throwable {
		setUpPageObject().clearScreen(workArea);
		setUpPageObject().loginLogout();
	}

	@Given("^I want to validate reference data for \"([^\"]*)\"$")
	public void i_want_to_validate_reference_data_for(String locations) throws Throwable {

		setUpPageObject().enterUserId("sit01.testuser");
		setUpPageObject().enterUserPin("1234");
		setUpPageObject().clickLoginButton();
		setUpPageObject().populateAll(locations);
		// counter++;
		setUpPageObject().loginLogoutNoDismiss();
	}

	@Then("^Reference Data should be valid$")
	public void reference_Data_should_be_valid() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^The user has completed entering mail format, class, payment type, submail type and stream ID$")
	public void the_user_has_completed_entering_mail_format_class_payment_type_submail_type_and_stream_ID()
			throws Throwable {
		setUpPageObject().enterUserId("sit01.testuser");
		setUpPageObject().enterUserPin("1234");
		setUpPageObject().clickLoginButton();
		setUpPageObject().populateAll("");
	}

	@When("^The Traffic recorder selects scan containers$")
	public void the_Traffic_recorder_selects_scan_containers() throws Throwable {
		setUpPageObject().selectScanButton();
	}

	@Given("^The Traffic recorder selects select faulty barcode$")
	public void the_Traffic_recorder_selects_select_faulty_barcode() throws Throwable {
		setUpPageObject().selectFaultyBarcodeButton();
	}

	@Then("^The user should presented with valid container types based on selected attributes$")
	public void the_user_should_presented_with_valid_container_types_based_on_selected_attributes() throws Throwable {
		setUpPageObject().validateContainerPopUp();
		setUpPageObject().cancelScan();
		// setUpPageObject().dismissPopUp();
		setUpPageObject().loginLogout();
	}

	@Given("^The user has completed entering stream data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_has_completed_entering_stream_data(String userName, String pin, String location,
			String workArea, String mailClass, String paymentType, String subMailType) throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectMailClass(mailClass);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);
	}

	@Then("^More than one valid container type for that stream is displayed$")
	public void more_than_one_valid_container_type_for_that_stream_is_displayed() throws Throwable {
		setUpPageObject().validateMultipleContainer();
		setUpPageObject().cancelScan();
		setUpPageObject().loginLogout();
	}

	@Given("^The user has completed entering stream data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_has_completed_entering_stream_data(String userName, String pin, String location,
			String workArea, String paymentType, String subMailType) throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);
	}

	@Then("^Only one valid container type for that stream is displayed$")
	public void only_one_valid_container_type_for_that_stream_is_displayed() throws Throwable {
		setUpPageObject().validateSingleContainer();
		setUpPageObject().cancelScan();
		setUpPageObject().loginLogout();
	}

	@Then("^The user should select done button to complete action$")
	public void the_user_should_select_done_button_to_complete_action() throws Throwable {
		setUpPageObject().selectDoneButton();
		setUpPageObject().loginLogoutDismiss();
	}

	@Then("^the row should display Faulty/Missing \\(in place of barcode number\\), container type , time of entry and ACF columns should be displayed$")
	public void the_row_should_display_Faulty_Missing_in_place_of_barcode_number_container_type_time_of_entry_and_ACF_columns_should_be_displayed()
			throws Throwable {
		setUpPageObject().selectDoneButton();
		setUpPageObject().validateScanSuccesfull();
		setUpPageObject().loginLogoutDismiss();
	}

	@When("^The user selects cancel$")
	public void the_user_selects_cancel() throws Throwable {
		setUpPageObject().cancelScan();
	}

	@When("^The user select the back button on device$")
	public void the_user_select_the_back_button_on_device() throws Throwable {
		setUpPageObject().goBack();
	}

	@Then("^the PDA should close the pop up list and return to the scan list$")
	public void the_PDA_should_close_the_pop_up_list_and_return_to_the_scan_list() throws Throwable {
		setUpPageObject().checkScanPageIsInFocus();
		setUpPageObject().loginLogout();
	}

	@Given("^the user has captured traffic transaction \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_has_captured_traffic_transaction(String userName, String pin, String location, String workArea,
			String paymentType, String subMailType) throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().setCaptureAttSession();
		setUpPageObject().selectScanButton();
		setUpPageObject().selectFaultyBarcodeButton();
		setUpPageObject().selectDoneButton();
	}

	@When("^the user selects the submit button$")
	public void the_user_selects_the_submit_button() throws Throwable {
		setUpPageObject().submitScan();
	}

	@Then("^the data transactions should be submitted to the PDA server$")
	public void the_data_transactions_should_be_submitted_to_the_PDA_server() throws Throwable {
		// System.out.print("pending");
		setUpPageObject().loginLogout();
	}

	@Then("^the app should take the user to the capture attributes page$")
	public void the_app_should_take_the_user_to_the_capture_attributes_page() throws Throwable {
		setUpPageObject().checkCaptureAttPageIsInFocus();
		setUpPageObject().loginLogout();
	}

	@When("^the user arrives on the capture attributes page$")
	public void the_user_arrives_on_the_capture_attributes_page() throws Throwable {
		setUpPageObject().checkCaptureAttPageIsInFocus();
	}

	@Then("^The page should be populated with the last derived stream details$")
	public void the_page_should_be_populated_with_the_last_derived_stream_details() throws Throwable {
		setUpPageObject().assertCaptureAttSession();
		setUpPageObject().loginLogout();
	}

	@Given("^the user is on the scan containers page \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_is_on_the_scan_containers_page(String userName, String pin, String location, String workArea,
			String paymentType, String subMailType) throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().setCaptureAttSession();
		setUpPageObject().selectScanButton();
	}

	@Given("^The user completes record via faulty/missing button \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_completes_record_via_faulty_missing_button(String userName, String pin, String location,
			String workArea, String paymentType, String subMailType) throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().setCaptureAttSession();
		setUpPageObject().selectScanButton();

	}

	@Given("^The user completes record via abnormal posting, faulty/missing button \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_completes_record_via_abnormal_posting_faulty_missing_button(String userName, String pin,
			String location, String workArea, String paymentType, String subMailType) throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().selectPaymentType(paymentType);
		setUpPageObject().selectSubMailType(subMailType);
		setUpPageObject().setCaptureAttSession();
		setUpPageObject().selectAbnormalPosting();
		setUpPageObject().populateAbnormalValues("123", "michael");
		setUpPageObject().selectScanAbnormalButton();
	}

	@When("^The user has reached twenty nine entries$")
	public void the_user_has_reached_twenty_nine_entries() throws Throwable {

		for (int x = 0; x < 30; x++) {
			setUpPageObject().selectFaultyBarcodeButton();
			setUpPageObject().selectDoneButton();
		}
	}

	@Then("^A warning msg should appear asking user to submit transactions$")
	public void a_warning_msg_should_appear_asking_user_to_submit_transactions() throws Throwable {
		setUpPageObject().scanLimitWarn();
		setUpPageObject().loginLogoutDismiss();
	}

	@Then("^The work area list should be filtered based on location \"([^\"]*)\"$")
	public void the_work_area_list_should_be_filtered_based_on_location(String location) throws Throwable {
		setUpPageObject().validateWorkAreaList(location);
		setUpPageObject().loginLogout();
	}

	@When("^The user selects the Abnormal Posting$")
	public void the_user_selects_the_Abnormal_Posting() throws Throwable {
		setUpPageObject().selectAbnormalPosting();
	}

	@Then("^The title of the page is read as stream name determined at Capture Attribute Page$")
	public void the_title_of_the_page_is_read_as_stream_name_determined_at_Capture_Attribute_Page() throws Throwable {
		setUpPageObject().verifyPageTitle("AbnormalPosting");
		setUpPageObject().loginLogout();
	}

	@Then("^The abnormal posting fields/buttons should be available$")
	public void the_abnormal_posting_fields_buttons_should_be_available() throws Throwable {
		setUpPageObject().abnormalAcfFieldDisplayed();
		setUpPageObject().customerNameFieldDisplayed();
		setUpPageObject().scanButtonDisplayed();
		setUpPageObject().loginLogout();
	}

	@When("^The user enters abnormal posting values \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_enters_abnormal_posting_values(String aAcf, String customer) throws Throwable {
		setUpPageObject().populateAbnormalValues(aAcf, customer);
	}

	@Then("^the user is navigated to the Scan Page$")
	public void the_user_is_navigated_to_the_Scan_Page() throws Throwable {
		setUpPageObject().scanPageInFocus();
		setUpPageObject().loginLogout();
	}

	@When("^The Traffic recorder selects scan abnormal containers$")
	public void the_Traffic_recorder_selects_scan_abnormal_containers() throws Throwable {
		setUpPageObject().selectScanAbnormalButton();
	}

	@Then("^The page should include Submit and Faulty/Missing buttons$")
	public void the_page_should_include_Submit_and_Faulty_Missing_buttons() throws Throwable {
		setUpPageObject().checkScanPageIsInFocus();
		setUpPageObject().loginLogout();
	}

	@When("^The user has captured an abnormal traffic data transaction$")
	public void the_user_has_captured_an_abnormal_traffic_data_transaction() throws Throwable {
		setUpPageObject().selectAbnormalPosting();
		setUpPageObject().populateAbnormalValues("123", "michael");
		setUpPageObject().selectScanAbnormalButton();
		setUpPageObject().selectFaultyBarcodeButton();
		setUpPageObject().selectDoneButton();
	}

	@When("^The user has captured an abnormal posting transaction$")
	public void the_user_has_captured_an_abnormal_posting_transaction() throws Throwable {
		setUpPageObject().selectAbnormalPosting();
		setUpPageObject().populateAbnormalValues("123", "michael");
		setUpPageObject().selectScanAbnormalButton();
		setUpPageObject().selectFaultyBarcodeButton();
	}

	@When("^The user long presses a record on the screen$")
	public void the_user_long_presses_a_record_on_the_screen() throws Throwable {
		setUpPageObject().longPressDelete();
	}

	@Then("^The screen should be in delete mode$")
	public void the_screen_should_be_in_delete_mode() throws Throwable {
		setUpPageObject().deleteCheckboxDislayed();
		setUpPageObject().cancelDelete();
		setUpPageObject().loginLogout();
	}

	@Then("^The screen should include check boxes, a cancel button and a delete button$")
	public void the_screen_should_include_check_boxes_a_cancel_button_and_a_delete_button() throws Throwable {
		setUpPageObject().validateDeleteMode();
		setUpPageObject().cancelDelete();
		setUpPageObject().submitScan();
		setUpPageObject().loginLogout();
	}

	@Then("^The history screen should include check boxes, a cancel button and a delete button$")
	public void the_history_screen_should_include_check_boxes_a_cancel_button_and_a_delete_button() throws Throwable {
		setUpPageObject().validateDeleteMode();
		setUpPageObject().cancelDelete();
		// setUpPageObject().goBack();
		setUpPageObject().loginLogout();
	}

	@When("^The user has selects delete button$")
	public void the_user_has_selects_delete_button() throws Throwable {
		setUpPageObject().selectAndDelete();
	}

	@When("^The user has selects history delete button$")
	public void the_user_has_selects_history_delete_button() throws Throwable {
		setUpPageObject().selectAndDeleteHistory();
	}

	@Then("^The record should be deleted from the PDA$")
	public void the_record_should_be_deleted_from_the_PDA() throws Throwable {
		setUpPageObject().checkSubmitButtonDisabled();
		setUpPageObject().loginLogout();
	}

	@Then("^The record should be deleted from the PDA history$")
	public void the_record_should_be_deleted_from_the_PDA_history() throws Throwable {
		setUpPageObject().checkRecordIsDeleted();
		setUpPageObject().loginLogout();
	}

	@When("^The user selects the cancel button$")
	public void the_user_selects_the_cancel_button() throws Throwable {
		setUpPageObject().cancelDelete();
	}

	@Then("^The the screen should return to the traffic capture list$")
	public void the_the_screen_should_return_to_the_traffic_capture_list() throws Throwable {
		setUpPageObject().validateScanPageDislayed();
		setUpPageObject().loginLogout();
	}

	@When("^The user selects shift history$")
	public void The_user_selects_shift_history() throws Throwable {
		setUpPageObject().selectShiftHistory();
	}

	@Then("^The app should take the user to the shift history page$")
	public void The_app_should_take_the_user_to_the_shift_history_page() throws Throwable {
		setUpPageObject().confirmPageTitle("Shift History");
		setUpPageObject().loginLogout();
	}

	@Then("^page should display a list of traffic capture transactions$")
	public void page_should_display_a_list_of_traffic_capture_transactions() throws Throwable {
		setUpPageObject().confirmTransExist();
		setUpPageObject().loginLogout();
	}

	@When("^The page should only display a list of traffic capture transactions submitted in the last hour$")
	public void the_page_should_only_display_a_list_of_traffic_capture_transactions_submitted_in_the_last_hour()
			throws Throwable {
		setUpPageObject().confirmHisDuration();
	}

	@Then("^The most recent submissions should be at the top of the list$")
	public void the_most_recent_submissions_should_be_at_the_top_of_the_list() throws Throwable {
		setUpPageObject().confirmHistory();
		setUpPageObject().loginLogout();
	}

	@When("^All field are clear with exception of default field$")
	public void all_field_are_clear_with_exception_of_default_field() throws Throwable {
		setUpPageObject().goBack();
		// setUpPageObject().goBack();
	}

	@Then("^Nothing should happen and the user should remain on the capture attributes page$")
	public void nothing_should_happen_and_the_user_should_remain_on_the_capture_attributes_page() throws Throwable {
		setUpPageObject().checkCaptureAttPageIsInFocus();
		setUpPageObject().loginLogout();
	}

	@Then("^The message should be on MQ$")
	public void the_message_should_be_on_MQ() throws Throwable {
		setUpPageObject().selectShiftHistory();
		setUpPageObject().checkMQ();
	}

	@Then("^Data length should match ICD$")
	public void data_length_should_match_ICD() throws Throwable {
		setUpPageObject().checkAPInputDataLength();
	}

	@Given("^I want to select location \"([^\"]*)\"$")
	public void i_want_to_select_location(String location) throws Throwable {
		setUpPageObject().scrollAndSelectLocation(location);
	}

	@Then("^A Delivery office dropdown should be present on page$")
	public void a_delivery_office_dropdown_should_be_present_on_page() throws Throwable {
		setUpPageObject().checkDeliveryOut();
		setUpPageObject().loginLogout();
	}

	@Then("^The a Delivery office dropdown selection should be derived by site location$")
	public void the_a_Delivery_office_dropdown_selection_should_be_derived_by_site_location() throws Throwable {
		setUpPageObject().validateDeliveryOffice();
	}

	@When("^The traffic recorder selects Delivery Office$")
	public void the_traffic_recorder_selects_Delivery_Office() throws Throwable {
		setUpPageObject().checkDeliveryOut();
	}

	@When("^The user has completed shift details selection$")
	public void the_user_has_completed_shift_details_selection() throws Throwable {
		setUpPageObject().selectRandomLocation();
		setUpPageObject().selectRandomWorkArea();
		setUpPageObject().clickWorkAreaConfirmButton();
	}

	@When("^The user goes back to the shift details page$")
	public void the_user_goes_back_to_the_shift_details_page() throws Throwable {
		setUpPageObject().backToShiftDetails();
	}

	@Then("^Previous location selection is remembered$")
	public void previous_location_selection_is_remembered() throws Throwable {
		setUpPageObject().checkLocationIsCached();
		setUpPageObject().loginLogout();
	}

	@Given("^the user has captured traffic transaction \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_has_captured_traffic_transaction(String userName, String pin, String location, String workArea)
			throws Throwable {
		setUpPageObject().enterUserId(userName);
		setUpPageObject().enterPin(pin);
		setUpPageObject().clickLoginButton();
		setUpPageObject().selectSpecificLocation(location);
		setUpPageObject().selectSpecificWorkArea(workArea);
		setUpPageObject().populateFromCaptureAtt();
	}

	@Then("^The traffic record should include a location field displaying the selected Delivery Office$")
	public void the_traffic_record_should_include_a_location_field_displaying_the_selected_Delivery_Office()
			throws Throwable {
		setUpPageObject().checkShiftDestLocation();
		setUpPageObject().loginLogout();
	}

	@Given("^I want to perform ad hoc actvities on \"([^\"]*)\"$")
	public void i_want_to_perform_ad_hoc_actvities_on(String location) throws Throwable {
		setUpPageObject().adHocActivities(location);
	}

	@Then("^I should not see any failures$")
	public void i_should_not_see_any_failures() throws Throwable {
		
	}

	@After
	public void endtest(Scenario scenario) throws Throwable {
		// setUpPageObject().takeScreenShot(drivers);
		if (scenario.isFailed()) {
			// setUpPageObject().loginLogout();
			initializeda = false;

		}

	}

}
