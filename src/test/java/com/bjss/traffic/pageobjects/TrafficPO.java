package com.bjss.traffic.pageobjects;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bjss.traffic.config.WebDriverConfig;
import com.ibm.mq.MQException;
import com.bjss.traffic.api.TestHelper;
import com.bjss.traffic.api.MessageQueues;
import com.bjss.traffic.config.GetRawRefData;

import io.selendroid.SelendroidKeys;

public class TrafficPO {
	private WebDriver driver;
	TestHelper testHelper = new TestHelper();
	MessageQueues mQueue = new MessageQueues();

	private static String loggedInUser;
	private static String destinationLocation;
	private static String siteLocation;
	private static String siteLocationId;
	private static String workArea;
	private static String workAreaId;
	private static String randomMailFormat;
	private static String mailFormat;
	private static String mailClass;
	private static String paymentType;
	private static String subMailType;
	private static String stream;
	private static String deliveryOffice;
	private static String streamId;
	private static String abnormalAcf;
	private static String lastTransTime;
	private static String deletedTime;

	public TrafficPO(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "login_edit_username")
	private WebElement username;

	@FindBy(id = "login_edit_password")
	private WebElement pin;

	@FindBy(id = "login_btn_login")
	private WebElement loginbutton;

	@FindBy(linkText = "Work Area")
	private WebElement shiftdetailsheader;

	@FindBy(linkText = "You have reached record entry limit. Select SUBMIT to continue")
	private WebElement limitReachedText;

	@FindBy(name = "More options")
	private WebElement menubutton;

	@FindBy(linkText = "Logout")
	private WebElement logoutbutton;

	@FindBy(id = "site_location")
	private WebElement locationbutton;

	@FindBy(className = "android.widget.ListView")
	private WebElement dobutton;

	@FindBy(id = "work_area_spinner_text")
	private List<WebElement> locationdropdown;

	@FindBy(id = "work_area_spinner_text")
	private WebElement locationValue;

	@FindBy(id = "work_area_spinner_text")
	private List<WebElement> dodropdown;

	@FindBy(className = "android.widget.RelativeLayout")
	private List<WebElement> dodropdown2;
	
	@FindBy(id = "work_area")
	private WebElement workareabutton;

	@FindBy(id = "confirm")
	private WebElement shiftconfirmbutton;

	@FindBy(id = "work_area_spinner_text")
	private WebElement destinationbutton;

	@FindBy(id = "work_area_spinner_text")
	private WebElement deliveryofficebutton;

	@FindBy(name = "MailFormat")
	private List<WebElement> mailformats;

	@FindBy(name = "MailClass")
	private List<WebElement> mailclass;

	@FindBy(name = "PaymentType")
	private List<WebElement> paymenttype;

	@FindBy(name = "SubMailType")
	private List<WebElement> submailtype;

	@FindBy(name = "Stream")
	private List<WebElement> StreamData;

	@FindBy(name = "stream")
	private WebElement StreamData2;

	@FindBy(className = "android.widget.TextView")
	private List<WebElement> summary;

	@FindBy(xpath = "//android.support.v7.widget.appcompattextview']")
	private WebElement shiftHistoryTitle;

	@FindBy(id = "title")
	private WebElement title;

	@FindBy(id = "mailClass")
	private WebElement mailClassField;

	@FindBy(id = "subMailType")
	private WebElement subMailTypeField;

	@FindBy(id = "paymentType")
	private WebElement paymentTypeField;

	@FindBy(id = "mailFormat")
	private WebElement mailFormatField;

	@FindBy(id = "stream")
	private WebElement streamIdField;

	@FindBy(id = "deliveryOutDeliveryOfficeUnderline")
	private WebElement doUnderline;

	// @FindBy(id = "destination")
	// private WebElement destinationLocationField;

	@FindBy(id = "concOutDestination")
	private WebElement destinationLocationField;

	@FindBy(id = "location")
	private WebElement shiftDestinationLocation;

	@FindBy(id = "title")
	private List<WebElement> logouttext;

	@FindBy(id = "select_dialog_listview")
	private WebElement locationdropdownScroll;

	@FindBy(id = "android.widget.ListView")
	private WebElement dodropdownScroll;

	@FindBy(linkText = "Direct")
	private WebElement directButton;

	@FindBy(id = "button1")
	private WebElement subWAOkButton;

	@FindBy(id = "Please select")
	private WebElement pleaseSelect;

	@FindBy(id = "work_area_spinner_text")
	private List<WebElement> deliveryofficedropdown;

	@FindBy(id = "number")
	private List<WebElement> transactionNumber;

	@FindBy(id = "interceptDeliveryOffice")
	private WebElement deliveryofficefield;

	@FindBy(id = "abnormal")
	private WebElement abnormalbutton;

	@FindBy(id = "scan")
	private WebElement scanbutton;

	@FindBy(id = "abnormal_scan")
	private WebElement scanabnormalbutton;

	@FindBy(id = "faulty_barcode")
	private WebElement faultyBarcodebutton;

	@FindBy(id = "custom")
	private WebElement containerPopUp;

	@FindBy(id = "done")
	private WebElement donebutton;

	@FindBy(id = "barcode")
	private WebElement barcode;

	@FindBy(id = "time_stamp")
	private WebElement time_stamp;

	@FindBy(id = "acf")
	private WebElement acf;

	@FindBy(id = "acf_description")
	private WebElement acf_history;

	@FindBy(id = "container_type")
	private WebElement container_type;

	@FindBy(id = "timeStampStringForUiOnly")
	private WebElement scantime;

	@FindBy(id = "stream_name")
	private WebElement hist_stream_name;

	@FindBy(id = "cancel")
	private WebElement cancelscanbutton;

	@FindBy(id = "submit")
	private WebElement submitbutton;

	@FindBy(id = "faulty_barcode")
	private WebElement faultybarcode;

	@FindBy(id = "redBand")
	private WebElement entrylimit;

	@FindBy(id = "arrow")
	private WebElement bigArrow;

	@FindBy(id = "abnormal_acf")
	private WebElement abnormal_acf;

	@FindBy(id = "customer_name")
	private WebElement customer_name;

	@FindBy(id = "card")
	private WebElement card;

	@FindBy(id = "checkBox")
	private WebElement checkBox;

	@FindBy(id = "action_mode_close_button")
	private WebElement closeButton;

	@FindBy(id = "delete")
	private WebElement delete;

	@FindBy(id = "barcode_recyler")
	private WebElement scanPage;

	@FindBy(id = "containerTypeName")
	private List<WebElement> containerType;

	@FindBy(id = "time_stamp")
	private List<WebElement> all_time_stamp;

	@FindBy(id = "shitfdetails")
	private WebElement captureAttributeRegion;

	@FindBy(id = "ok")
	private WebElement leave;

	@FindBy(id = "cancel")
	private WebElement stay;

	
	public void initUsername() {
		WebElement userName = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(username));

		// check username field is enabled
		try {
			Assert.assertEquals("true", userName.getAttribute("enabled"));
		} catch (Exception e) {
			testHelper.writeErrorToLog("Username is not enabled"+e.toString());
		}
		userName.clear();

	}

	public void initUserPin() {
		WebElement userPin = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(pin));

		// check pin field is enabled
		try {
			Assert.assertEquals("true", userPin.getAttribute("enabled"));
		} catch (Exception e) {
			testHelper.writeErrorToLog("Pin field is not enabled"+e.toString());

		}
		userPin.clear();
	}

	public void enterUserId(String userId) {
		this.initUsername();
		loggedInUser = userId;
		username.sendKeys(userId);
		// userName.sendKeys("5052910722522");
	}

	public void enterUserPin(String userpin) {
		this.initUserPin();
		pin.sendKeys(userpin);
	}

	public void clickLoginButton() {
		// dismiss the keyboard
		new Actions(driver).sendKeys(SelendroidKeys.ENTER).perform();

		loginbutton.click();
	}

	public void verifyLoginSuccess() {
		WebElement userName = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(shiftdetailsheader));

		try {
			Assert.assertEquals("Work Area", userName.getText());
		} catch (Exception e) {
			testHelper.writeErrorToLog("User login failed "+e.toString());

		}
	}

	public void takeScreenShot(WebDriver picDriver) {
		String path;
		try {
			File source = ((TakesScreenshot) picDriver).getScreenshotAs(OutputType.FILE);
			path = "C:/Users/michael.umenyiora/workspace/FunctionalTest/target/screenshot/" + source.getName();
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			System.out.println("could not take pictures");
		}
	}

	public void loginLogout() {
		WebElement menu = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(menubutton));
		// click on the menu button
		menu.click();

		List<WebElement> menuList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(logouttext));
		Iterator<WebElement> iter = menuList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().equalsIgnoreCase("Logout " + loggedInUser))
				we.click();
		}

		// dismiss unsubmitted scan pop up
		/*
		 * try { leave(); } catch (Exception e) { e.printStackTrace(); }
		 */
	}

	public void loginLogoutNoDismiss() {
		WebElement menu = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(menubutton));
		// click on the menu button
		menu.click();

		List<WebElement> menuList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(logouttext));
		Iterator<WebElement> iter = menuList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().equalsIgnoreCase("Logout " + loggedInUser))
				we.click();
		}

	}

	public void loginLogoutDismiss() {
		WebElement menu = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(menubutton));
		// click on the menu button
		menu.click();

		List<WebElement> menuList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(logouttext));
		Iterator<WebElement> iter = menuList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().equalsIgnoreCase("Logout " + loggedInUser))
				we.click();
		}

		// dismiss unsubmitted scan pop up
		
		 try { leave(); } catch (Exception e) { e.printStackTrace(); }
		
	}
	
	public void backToShiftDetails() {
		WebElement menu = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(menubutton));
		// click on the menu button
		menu.click();

		List<WebElement> menuList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(logouttext));
		Iterator<WebElement> iter = menuList.iterator();

		// iterate menu values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			try {
				if (we.getText().equalsIgnoreCase("Work Area"))
					we.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateUserId() {
		WebElement menu = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(menubutton));
		boolean found = false;

		// click on the menu button
		menu.click();

		List<WebElement> menuList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(logouttext));
		Iterator<WebElement> iter = menuList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().equalsIgnoreCase("Logout " + loggedInUser)) {
				found = true;
				try {
					Assert.assertTrue(found);
				} catch (Exception e) {
					testHelper.writeErrorToLog("User id validation failed "+e.toString());

				}
				we.click();
			}
		}
	}

	public void checkLoginButtonDisabled() {
		WebElement login = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(loginbutton));

		try {
			Assert.assertEquals("false", login.getAttribute("enabled"));
		} catch (Exception e) {
			testHelper.writeErrorToLog(e.toString());

		}
	}

	public void checkLoginButtonEnabled() {
		WebElement login = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(loginbutton));

		try {
			Assert.assertEquals("true", login.getAttribute("enabled"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkSubmitButtonDisabled() {
		WebElement submit = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(submitbutton));

		try {
			Assert.assertEquals("false", submit.getAttribute("enabled"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks that the locations displayed on the ui are valid
	 * 
	 */
	public void validateLocationList() {
		ArrayList<String> locations = new ArrayList<String>();
		String tableName = "vTMA_Location_w_acf";
		String columnName = "UPPER(LOCATION_NAME_RLN)";
		String whereClause = "";
		String columnTypes = "columnTypes=int,string,int,string,int,string";
		ArrayList<String> locationsRef = new GetRawRefData().getRefData(tableName, columnName, "", columnTypes);
		/*
		 * WebElement locationSelect = (new WebDriverWait(driver, 60))
		 * .until(ExpectedConditions.visibilityOf(locationbutton));
		 * locationSelect.click();
		 * 
		 * List<WebElement> locationList = (new WebDriverWait(driver, 60))
		 * .until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		 * Iterator<WebElement> iter = locationList.iterator();
		 * 
		 * while (iter.hasNext()) { WebElement we = iter.next();
		 * locations.add(we.getText()); }
		 */

		// iterate the location values returned by the ui and add them to an
		// array

		// remove Please select from the ui location list
		locations = scroll(locationbutton, locationdropdown, locationdropdownScroll);
		System.out.println("locations are: " + locations);
		locations.remove("Please select");
		//testHelper.compareList("Location",locations, locationsRef);
	}

	public void selectLocation() {
		List<WebElement> locationList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		siteLocation = locationList.get(9).getText();
		locationList.get(9).click();
	}

	public void selectRandomLocation() {
		WebElement locationSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(locationbutton));
		locationSelect.click();

		List<WebElement> locationList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));

		int index = testHelper.getRandomNumber(9) + 1;
		siteLocation = locationList.get(index).getText();
		siteLocationId = getLocationId(locationList.get(index).getText());
		locationList.get(index).click();
	}

	public void selectSpecificLocation(String location) {
		WebElement locationSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(locationbutton));
		locationSelect.click();

		List<WebElement> locationList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));

		Iterator<WebElement> iter = locationList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			siteLocationId = getLocationId(location);
			if (we.getText().equals(location)) {
				siteLocation = we.getText();
				we.click();
				break;
			}
		}
	}

	public void selectNonValidatedLocation() {
		WebElement locationSelect = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOf(locationbutton));
		locationSelect.click();
		List<WebElement> locationList = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		siteLocation = locationList.get(1).getText();
		System.out.println("Location id :"+siteLocation);
		siteLocationId = getLocationId(siteLocation);
		locationList.get(1).click();
	}

	public ArrayList<String> getValidWorkArea(String locationId) {
		String tableName = "TMA_Location_WorkArea_Map";
		String columnName = "WorkAreaName";
		String columnTypes = "columnTypes=string,int";
		String whereClause = "where Location_Id = " + locationId;
		return new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);

	}

	public int getWorkAreaRefSize(String locationId) {
		String tableName = "TMA_Location_WorkArea_Map";
		String columnName = "WorkAreaName";
		String columnTypes = "columnTypes=string,int";
		String whereClause = "where Location_Id = " + locationId;
		return new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes).size();

	}
	
	/**
	 * Checks that the work areas displayed on the ui are valid
	 * 
	 */
	public void validateWorkAreaList() {
		ArrayList<String> workArea = new ArrayList<String>();
		String tableName = "TMA_Location_WorkArea_Map";
		String columnName = "WorkAreaName";
		String columnTypes = "columnTypes=string,int";
		String whereClause = "where Location_Id = " + siteLocationId;
		/*
		 * String whereClause =
		 * "where Work_Area_Type_Id in (1000068,1000091,1000069,1000070,1000073,"
		 * + "1000074,1000075,1000076,1000072,1000081," +
		 * "1000082,1000083,1000084,1000090)";
		 */
		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		WebElement workAreaSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(workareabutton));
		workAreaSelect.click();

		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		Iterator<WebElement> iter = workAreaList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			workArea.add(we.getText());
		}

		// remove Please select from the ui location list
		workArea.remove("Please select");
		testHelper.compareList("Work Area", workArea, workAreaRef);
	}

	/**
	 * Checks that the work areas displayed on the ui are valid for a location
	 * 
	 */
	public void validateWorkAreaList(String location) {
		ArrayList<String> workArea = new ArrayList<String>();
		String tableName = "TMA_Location_WorkArea_Map";
		String columnName = "distinct WorkAreaName";
		String columnTypes = "columnTypes=string,int";
		String whereClause = "where location_Id = " + getLocationId(location);

		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		WebElement workAreaSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(workareabutton));
		workAreaSelect.click();

		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		Iterator<WebElement> iter = workAreaList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (!we.getText().equalsIgnoreCase("Please select"))
				//workArea.add(getWorkAreaId(we.getText()).replace("[", "").replace("]", ""));
				workArea.add(we.getText().replace("[", "").replace("]", ""));
		}

		testHelper.compareList("Work Area", workArea, workAreaRef);

		workAreaList.get(1).click();
	}

	public void selectWorkArea() {
		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		workAreaList.get(1).click();
	}

	public void selectWorkAreaIndex(int count) {
		WebElement workAreaSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(workareabutton));
		workAreaSelect.click();
		
		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		workArea = workAreaList.get(count).getText();
		workAreaId = getWorkAreaId(workArea).toString().replace("[", "").replace("]", "");
		try {
			testHelper.fileWriter("******************************* " + workArea + " ****************************",
					"C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		workAreaList.get(count).click();
	}

	public int getWorkAreaSize(String location) {
		WebElement workAreaSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(workareabutton));
		workAreaSelect.click();

		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));

		return workAreaList.size();
	}

	public void selectRandomWorkArea() {
		WebElement workAreaSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(workareabutton));
		workAreaSelect.click();

		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));

		Iterator<WebElement> iter = workAreaList.iterator();
		ArrayList<String> workAreaData = new ArrayList<String>();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			workAreaData.add(we.getText());
		}

		int index = testHelper.getRandomNumber(workAreaList.size() + 1);
		int myindex = index;
		if (myindex == 0) {
			myindex = 1;
		}
		workArea = workAreaList.get(myindex).getText();
		workAreaId = getWorkAreaId(workArea).toString().replace("[", "").replace("]", "");
		workAreaData.remove("Please select");

		try {
			testHelper.fileWriter("Location selected: " + siteLocation, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Work Area displayed: " + workAreaData, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Work Area reference: " + getValidWorkArea(siteLocationId),
					"C:\\DataResult\\result.txt");
			testHelper.fileWriter("Work Area selected: " + workArea, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		workAreaList.get(myindex).click();
		/*
		 * }catch(Exception e){ new
		 * Actions(driver).sendKeys(SelendroidKeys.ENTER).perform(); new
		 * Actions(driver).sendKeys(SelendroidKeys.ENTER).perform();
		 * populateAll(); }
		 */
	}

	public String getWorkAreaId(String workAreaName) {
		String tableName = "TMA_Work_Area_Type";
		String columnName = "Work_Area_Type_Id";
		String columnTypes = "columnTypes=int,string";
		String whereClause = "where Work_Area_Type_Desc = '" + workAreaName + "'";

		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);

		return workAreaRef.toString();
	}

	public ArrayList<String> getWorkAreaName(String workAreaId) {
		String tableName = "TMA_Work_Area_Type";
		String columnName = "Work_Area_Type_Desc";
		String columnTypes = "columnTypes=int,string";
		String whereClause = "where Work_Area_Type_Id = " + workAreaId;

		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);

		return workAreaRef;
	}

	/**
	 * Compares the values of 2 lists. Returns not found if value1 is not
	 * missing in value2
	 * 
	 * @param uiList
	 * @param refList
	 */
	/*
	 * public void compareList(ArrayList<String> uiList, ArrayList<String>
	 * refList) {
	 * 
	 * boolean notFound = false;
	 * 
	 * for (int i = 0; i < uiList.size(); i++) { if
	 * (refList.contains(uiList.get(i))) {
	 * System.out.println("UI list displayed" + uiList.get(i)); } else {
	 * notFound = true; break; } }
	 * 
	 * Assert.assertFalse(notFound);
	 * 
	 * }
	 */

	public void checkShiftButtonEnabled() {
		WebElement confirmShift = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(shiftconfirmbutton));

		try {
			Assert.assertEquals("true", confirmShift.getAttribute("enabled"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkShiftButtonDisabled() {
		WebElement confirmShift = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(shiftconfirmbutton));

		try {
			Assert.assertEquals("false", confirmShift.getAttribute("enabled"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickWorkAreaConfirmButton() {
		WebElement confirmShift = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(shiftconfirmbutton));

		confirmShift.click();
	}

	public void selectSpecificWorkArea(String workAreaSelected) {
		WebElement workAreaSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(workareabutton));
		workAreaSelect.click();
		List<WebElement> workAreaList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		Iterator<WebElement> iter = workAreaList.iterator();
		int counter = 0;
		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			workAreaId = getWorkAreaId(workAreaSelected).toString().replace("[", "").replace("]", "");

			if (workAreaSelected.equalsIgnoreCase(we.getText())) {
				workAreaList.get(counter).click();
				break;
			}
			counter++;
		}

		clickWorkAreaConfirmButton();
	}

	public void validateMailFormats(String workAreaSelected) {
		List<WebElement> mailFormatList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(mailformats));
		Iterator<WebElement> iter = mailFormatList.iterator();
		ArrayList<String> mailFormat = new ArrayList<String>();
		String tableName = "UltimateReferenceData";
		String columnName = "distinct Postal_Piece_Type_Desc";
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where location_id = " + siteLocationId + " and Work_Area_Type_Id = " + workAreaSelected;
		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);

		// iterate mail format values returned by the ui and add them to an
		// array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			mailFormat.add(we.getText());
		}

		try {
			testHelper.fileWriter("Mail Format(s) displayed: " + mailFormat, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Mail Format(s) reference: " + workAreaRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		testHelper.compareList("Mail Format",mailFormat, workAreaRef);
	}

	public void validateMailClassAutoSelect() {
		WebElement mailclass = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(title));
		try {
			Assert.assertEquals("Select mail class", mailclass.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectMailFormat(String mailFormat) {
		try {
			List<WebElement> mailFormatList = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOfAllElements(mailformats));
			Iterator<WebElement> iter = mailFormatList.iterator();

			// iterate mail class values returned by the ui and select one
			while (iter.hasNext()) {
				WebElement we = iter.next();
				if (we.getText().equalsIgnoreCase(mailFormat)) {
					we.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRandomMailFormat(int index) {
		List<WebElement> mailFormatList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(mailformats));
		randomMailFormat = mailFormatList.get(index).getText();
		try {
			testHelper.fileWriter("Mail Format Selected: " + randomMailFormat, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		mailFormatList.get(index).click();
	}

	public void selectMailClass(String mailClass) {
		try {
			List<WebElement> mailClassList = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOfAllElements(mailclass));
			Iterator<WebElement> iter = mailClassList.iterator();

			// iterate mail class values returned by the ui and select one
			while (iter.hasNext()) {
				WebElement we = iter.next();
				if (we.getText().equalsIgnoreCase(mailClass)) {
					we.click();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectRandomMailClass(int index) {
		List<WebElement> mailClassList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(mailclass));
		mailClass = mailClassList.get(index).getText();

		try {
			testHelper.fileWriter("Mail Class Selected: " + mailClass, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		mailClassList.get(index).click();
	}

	public void countMailClass() {
		WebElement mailclass = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(title));
		try {
			Assert.assertEquals("Select mail class", mailclass.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkMailClassText() {
		List<WebElement> mailClassList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(mailclass));
		Iterator<WebElement> iter = mailClassList.iterator();
		ArrayList<String> mailClass = new ArrayList<String>();
		ArrayList<String> mailClassUi = new ArrayList<String>();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			mailClass.add(we.getText());
		}

		mailClassUi.add("1");
		mailClassUi.add("2");
		mailClassUi.add("N/A");

		testHelper.compareList("Mail Class",mailClassUi, mailClass);

	}

	public void checkMailClassField(String mailClassValue) {
		/*
		 * WebElement mailclass = (new WebDriverWait(driver, 60))
		 * .until(ExpectedConditions.visibilityOf(mailClassField));
		 * Iterator<WebElement> iter = mailclass.iterator(); ArrayList<String>
		 * mailClass = new ArrayList<String>(); ArrayList<String> mailClassUi =
		 * new ArrayList<String>();
		 * 
		 * while (iter.hasNext()) { WebElement we = iter.next();
		 * mailClass.add(we.getText()); }
		 * 
		 * mailClassUi.add(mailClassValue); this.compareList(mailClassUi,
		 * mailClass);
		 */

		// Assert.assertEquals(mailclass.getText(), mailClassValue);

		WebElement mailclass = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(mailClassField));

		try {
			Assert.assertEquals(mailClassValue.toUpperCase(), mailclass.getText().toUpperCase());
		} catch (Exception e) {
			testHelper.writeErrorToLog("Mail Class field has value is invalid. Expected"+mailClassValue+""
					+ "but got"+mailclass.getText());
		}

	}

	public void validatePaymentType(String workAreaSelected, String mFormat, String mClass) {
		List<WebElement> mailClassList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(paymenttype));
		Iterator<WebElement> iter = mailClassList.iterator();
		ArrayList<String> mailClass = new ArrayList<String>();
		String tableName = "UltimateReferenceData";
		String columnName = "distinct Traffic_Mail_Type_Desc";
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where location_id = " + siteLocationId + " and Work_Area_Type_Id = " + workAreaSelected
				+ " " + "and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mFormat + "') "
				+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mClass + "')";
		ArrayList<String> mailClassRef = new GetRawRefData().getRefData(tableName, columnName, whereClause,
				columnTypes);

		// iterate mail format values returned by the ui and add them to an
		// array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			mailClass.add(we.getText());
		}

		try {
			testHelper.fileWriter("PaymentType displayed: " + mailClass, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("PaymentType reference: " + mailClassRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		testHelper.compareList("Payment Type",mailClass, mailClassRef);
	}

	public void selectPaymentType(String paymentType) {
		List<WebElement> paymentTypeList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(paymenttype));
		Iterator<WebElement> iter = paymentTypeList.iterator();

		// iterate payment type values returned by the and select one
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().equalsIgnoreCase(paymentType)) {
				we.click();
				break;
			}
		}
	}

	public void selectRandomPT(int index) {
		List<WebElement> paymentTypeList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(paymenttype));
		paymentType = paymentTypeList.get(index).getText();

		try {
			testHelper.fileWriter("Payment Type Selected: " + paymentType, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		paymentTypeList.get(index).click();
	}

	public void selectSubMailType(String subMailTypeData) {
		try {
			List<WebElement> subMailTypeList = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOfAllElements(submailtype));
			Iterator<WebElement> iter = subMailTypeList.iterator();

			while (iter.hasNext()) {
				WebElement we = iter.next();
				if (we.getText().equalsIgnoreCase(subMailTypeData)) {
					System.out.println("Sub mail type :" + we.getText());
					subMailType = we.getText();
					we.click();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectRandomSubMailType(int index) {
		List<WebElement> subMailTypeList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(submailtype));
		subMailType = subMailTypeList.get(index).getText();

		try {
			testHelper.fileWriter("Sub Mail Type Selected: " + subMailType, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		subMailTypeList.get(index).click();
	}

	public void selectRandomStream(int index) {
		List<WebElement> streamList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(StreamData));
		streamId = getStreamId(streamList.get(index).getText());

		try {
			testHelper.fileWriter("Stream Selected: " + streamList.get(index).getText(), "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		streamList.get(index).click();
	}

	public void validateSubMailType(String workAreaSelected, String mFormat, String mailClass, String paymentType) {
		List<WebElement> subMailTypeList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(submailtype));
		Iterator<WebElement> iter = subMailTypeList.iterator();
		ArrayList<String> subMailType = new ArrayList<String>();
		String tableName = "UltimateReferenceData";
		String columnName = "distinct Traffic_Mail_Sub_Type_Desc";
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where location_id = " + siteLocationId + " and Work_Area_Type_Id = " + workAreaSelected
				+ " " + "and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mFormat + "') "
				+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClass + "') "
				+ "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" + paymentType + "')";

		ArrayList<String> mailClassRef = new GetRawRefData().getRefData(tableName, columnName, whereClause,
				columnTypes);

		// iterate mail format values returned by the ui and add them to an
		// array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			subMailType.add(we.getText());
		}

		try {
			testHelper.fileWriter("Sub Mail Type displayed: " + subMailType, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Sub Mail Type reference: " + mailClassRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		testHelper.compareList("Sub Mail Type",subMailType, mailClassRef);
	}

	public void checkSubMailTypeField(String subMailTypeValue) {
		WebElement subMailType = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(subMailTypeField));

		try {
			Assert.assertEquals(subMailTypeValue.toUpperCase(), subMailType.getText().toUpperCase());
		} catch (Exception e) {
			testHelper.writeErrorToLog("Submail Class value is invalid. Expected"+subMailTypeValue+""
					+ "but got"+subMailType.getText());
		}

	}

	public void checkStreamIdField(String workAreaId, String paymentType, String subMailType) {
		WebElement streamList = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(streamIdField));
		/*
		 * String tableName = "UltimateReferenceData"; String columnName =
		 * "distinct Stream_Name"; String columnTypes =
		 * "columnTypes=int,string,string,string,string,string,int,int"; String
		 * whereClause =
		 * "where location_id = "+siteLocationId+" and Work_Area_Type_Id = " +
		 * workAreaId + " " + "and UPPER(Postal_Piece_Type_Desc) = UPPER('" +
		 * mailFormatField.getText() + "') " +
		 * "and UPPER(Postal_Class_Type_Desc) = UPPER('" +
		 * mailClassField.getText() + "') " +
		 * "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" +
		 * paymentTypeField.getText() + "') " +
		 * "and UPPER(Traffic_Mail_Sub_Type_Desc) = UPPER('" +
		 * subMailTypeField.getText() + "')"; ArrayList<String> streamIdRef =
		 * new GetRawRefData().getRefData(tableName, columnName, whereClause,
		 * columnTypes);
		 */
		try {
			Assert.assertNotNull(streamList.getText());
		} catch (Exception e) {
			testHelper.writeErrorToLog("Stream is null");		}
	}

	public void validateStreamIdField(String workAreaId) {
		List<WebElement> streamList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(StreamData));
		String tableName = "UltimateReferenceData";
		String columnName = "distinct Stream_Name";
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where location_id = " + siteLocationId + " and Work_Area_Type_Id = " + workAreaId + " "
				+ "and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
				+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText() + "') "
				+ "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" + paymentTypeField.getText() + "') "
				+ "and UPPER(Traffic_Mail_Sub_Type_Desc) = UPPER('" + subMailTypeField.getText() + "')";
		ArrayList<String> streamIdRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		Iterator<WebElement> iter = streamList.iterator();
		ArrayList<String> streamName = new ArrayList<String>();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			streamName.add(we.getText());
		}

		try {
			testHelper.fileWriter("Stream displayed: " + streamName, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Stream reference: " + streamIdRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		testHelper.compareList("Stream",streamName, streamIdRef);
	}

	public String getStreamName(String streamId) {
		String tableName = "vTMA_Stream_Map";
		String columnName = "distinct Stream_Name";
		String columnTypes = "columnTypes=int,string";
		String whereClause = "where Stream_Id = " + streamId;
		ArrayList<String> streamIdRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		return streamIdRef.get(0);
	}

	public String getStreamId(String streamName) {
		String tableName = "UltimateReferenceData";
		String columnName = "distinct Stream_Id";
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where UPPER(Stream_Name) = UPPER('" + streamName + "') and location_id = "
				+ siteLocationId;
		ArrayList<String> streamIdRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		System.out.println("*****************************************************************");
		System.out.println("Stream name = " + streamName);

		return streamIdRef.get(0);
	}

	public String getLocationId(String locationName) {
		String tableName = "vTMA_Location_w_acf";
		String columnName = "LOCATION_ID";
		String whereClause = "where LOCATION_NAME_RLN = '" + locationName + "'";
		String columnTypes = "columnTypes=int,string,int,string,int,string";
		ArrayList<String> locationsRef = new GetRawRefData().getRefData(tableName, columnName, whereClause,
				columnTypes);
		return locationsRef.get(0);
	}

	public ArrayList<String> getContainerTypeId(String streamId, String locationId) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String formatted = formatDate.format(cal.getTime());

		System.out.println("Todays data and time = " + formatted);

		/*
		 * try { getACFValid(streamId, locationId); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 */

		String tableName = "TMA_Average_Container_Fill";
		String columnName = "distinct Container_Type_Id";
		String columnTypes = "columnTypes=int,int,int,int,timestamp,timestamp";
		String whereClause = "where Stream_Id = " + streamId + " and Location_Id = " + locationId;
		System.out.println("Stream_Id = " + streamId + " and Location_Id = " + locationId);
		ArrayList<String> streamIdRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		return streamIdRef;
	}

	public void getACFValid(String streamId, String locationId) throws ParseException {
		Date startDate;
		Date endDate;
		Date curDate = new java.util.Date();
		Boolean validACF = false;
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String tableName = "TMA_Average_Container_Fill";
		String columnName = "Valid_From";
		String columnName2 = "NULLIF(Valid_To,'" + curDate + "')";
		String columnTypes = "columnTypes=int,int,int,int,string,string";
		String whereClause = "where Stream_Id = " + streamId + " and Location_Id = " + locationId;
		ArrayList<String> validFrom = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		startDate = formatDate.parse(validFrom.toString().replace("[", "").replace("]", ""));

		ArrayList<String> validTo = new GetRawRefData().getRefData(tableName, columnName2, whereClause, columnTypes);
		// endDate = formatDate.parse(validTo.toString().replace("[",
		// "").replace("]", ""));

		System.out.println("Start date =" + startDate + " and current date =" + curDate);

		try {
			Assert.assertTrue(curDate.after(startDate));
		} catch (Exception e) {
			testHelper.writeErrorToLog("ACF is invalid");
		}
	}

	public void checkCapturedData(String stream) {
		List<WebElement> summaryList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(summary));
		Iterator<WebElement> iter = summaryList.iterator();
		ArrayList<String> summary = new ArrayList<String>();
		ArrayList<String> summaryUi = new ArrayList<String>();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			summary.add(we.getText());
		}

		summaryUi.add(stream);

		testHelper.compareList("",summaryUi, summary);
	}

	public void enterUsername(String userId) {
		WebElement userName = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(username));
		userName.clear();
		loggedInUser = userId;
		userName.sendKeys(userId);
		// userName.sendKeys("5052910722522");
	}

	public void enterPin(String userpin) {
		WebElement userPin = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(pin));
		userPin.clear();
		userPin.sendKeys(userpin);
	}

	public void validateMailClasss(String workAreaSelected, String mFormat) {
		List<WebElement> mailClassList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(mailclass));
		Iterator<WebElement> iter = mailClassList.iterator();
		ArrayList<String> mailClass = new ArrayList<String>();
		String tableName = "UltimateReferenceData";
		String columnName = "distinct Postal_Class_Type_Desc";
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause2 = "where location_id = " + siteLocationId + " and UPPER(Postal_Piece_Type_Desc) = UPPER('"
				+ mFormat + "') and Work_Area_Type_Id = " + workAreaSelected;
		ArrayList<String> mailClassRef = new GetRawRefData().getRefData(tableName, columnName, whereClause2,
				columnTypes);

		// iterate mail format values returned by the ui and add them to an
		// array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			mailClass.add(we.getText().toUpperCase());
		}

		try {
			testHelper.fileWriter("Mail Class displayed: " + mailClass, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Mail Class reference: " + mailClassRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		testHelper.compareList("Mail Class",mailClass, mailClassRef);
	}

	public void validateDeliveryOffice() {

		String tableName = "vTMAMailCentre_DO";
		String columnName = "distinct UPPER(DO_Name)";
		String columnTypes = "columnTypes=int,string,int,string";
		String whereClause2 = "where MC_Id = " + siteLocationId;
		ArrayList<String> mailClassRef = new GetRawRefData().getRefData(tableName, columnName, whereClause2,
				columnTypes);
		ArrayList<String> doOffices = scroll(destinationbutton, dodropdown, dobutton);
		doOffices.remove("PLEASE SELECT");
		
		try {
			testHelper.fileWriter("Delivery Office Displayed: " + doOffices, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Delivery Office Reference: " + mailClassRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//testHelper.compareList("Delivery Office",doOffices, mailClassRef);
	}

	public void checkDestionLocation() {
		ArrayList<String> locations = new ArrayList<String>();
		WebElement locationSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(destinationbutton));
		locationSelect.click();

		List<WebElement> locationList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));

		try {
			Assert.assertNotNull(locationList);
		} catch (Exception e) {
			testHelper.writeErrorToLog("Destination location is empty");		}
		locationList.get(1).click();
	}

	public void checkDeliveryOut() {
		ArrayList<String> locations = new ArrayList<String>();
		WebElement locationSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(destinationbutton));
		locationSelect.click();

		List<WebElement> locationList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(dodropdown2));

		try {
			Assert.assertNotNull(locationList);
		} catch (Exception e) {
			testHelper.writeErrorToLog(e.toString());
		}
		try {
			deliveryOffice = locationList.get(2).getText();
			locationList.get(2).click();
		} catch (Exception e) {
			dismissPopUp();
		}
	}

	public void selectDestinationLocation() {
		WebElement locationSelect = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(destinationbutton));
		locationSelect.click();

		List<WebElement> locationList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));
		
		validateDeliveryOffice();
		
		destinationLocation = locationList.get(2).getText();
		try {
			testHelper.fileWriter("Delivery Office Selected: " + destinationLocation, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		locationList.get(2).click();
	}

	public void checkDestLocationMatchSelection() {
		WebElement destLoc = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(destinationLocationField));
		try {
			Assert.assertEquals(destinationLocation, destLoc.getText());
		} catch (Exception e) {
			testHelper.writeErrorToLog("Location selected "+destinationLocation+ "does not match");
		}
	}

	public void selectInterceptDirect() {
		WebElement direct = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(directButton));

		WebElement subWROk = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(subWAOkButton));
		direct.click();
		subWROk.click();
		clickWorkAreaConfirmButton();
	}

	/*
	 * public void checkDeliveryOfficeField() { WebElement deliveryOffice = (new
	 * WebDriverWait(driver, 60))
	 * .until(ExpectedConditions.visibilityOf(deliveryOfficeField));
	 * 
	 * Assert.assertEquals("Delivery Office", deliveryOffice.getText());
	 * 
	 * }
	 */

	public void checkSiteDO() {
		ArrayList<String> dOfficeList = new ArrayList<String>();
		String tableName = "MC_to_DO_hierarchy";
		String columnName = "distinct DO_Name";
		String columnTypes = "columnTypes=int,string,int,string";
		String whereClause = "where UPPER(MC_NAME) = UPPER('" + siteLocation + "')";
		ArrayList<String> mailClassRef = new GetRawRefData().getRefData(tableName, columnName, whereClause,
				columnTypes);
		WebElement deliveryOffice = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(destinationbutton));
		deliveryOffice.click();

		List<WebElement> doList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(dodropdown));
		Iterator<WebElement> iter = doList.iterator();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			dOfficeList.add(we.getText().toUpperCase());
		}
		dOfficeList.remove("Please select");
		//testHelper.compareList("Delivery Office",dOfficeList, mailClassRef);
		dismissPopUp();
		dismissPopUp();
	}

	public void selectDeliveryOffice() {
		WebElement deliOffice = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(destinationbutton));
		deliOffice.click();

		List<WebElement> doList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(dodropdown));
		deliveryOffice = doList.get(2).getText();
		doList.get(2).click();
	}

	public void checkDeliOfficeField() {
		// to do
		/*
		 * WebElement doffice = (new WebDriverWait(driver,
		 * 60)).until(ExpectedConditions.visibilityOf(deliveryofficefield));
		 * 
		 * Assert.assertEquals(((WebElement) doffice).getText().toUpperCase(),
		 * deliveryOffice.toUpperCase());
		 */

	}

	public void abnormalButtonEnabled() {
		WebElement abnormalb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(abnormalbutton));

		try {
			Assert.assertEquals("true", abnormalb.getAttribute("enabled"));
		} catch (Exception e) {
			testHelper.writeErrorToLog(e.toString());
		}
	}

	public void scanButtonEnabled() {
		WebElement scanb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scanbutton));

		try {
			Assert.assertEquals("true", scanb.getAttribute("enabled"));
		} catch (Exception e) {
			testHelper.writeErrorToLog(e.toString());

		}
	}

	public void goBack() {
		new Actions(driver).sendKeys(SelendroidKeys.BACK).perform();
	}

	public void clearScreen(String workArea) {
		// if (workArea.equals("IPS - L")) {
		try {
			Assert.assertEquals(true, testHelper.isAttribtuePresent("paymentType", driver));
		} catch (Exception e) {
			testHelper.writeErrorToLog("Payment type is not displayed");
		}
		// } else if (workArea.equals("Conc Out")) {
		// Assert.assertEquals(true, testHelper.isAttribtuePresent("stream",
		// driver));
		// }
	}

	/**
	 * Check if selected work area has more than one stream
	 * 
	 * @param workAreaSelected
	 * @return
	 */
	public ArrayList<String> checkStreamData(String workAreaSelected, String refColumnName, String addCriteria,
			String locationId) {
		String tableName = "UltimateReferenceData";
		String columnName = "distinct " + refColumnName;
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where Work_Area_Type_Id = " + Long.parseLong(workAreaSelected) + " and location_Id = "
				+ locationId + " " + addCriteria;
		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		return workAreaRef;
	}

	/**
	 * Count the number of valid steam records
	 * 
	 * @param workAreaSelected
	 * @param refColumnName
	 * @return
	 */
	public int countStreamData(String locationId, String workAreaSelected, String refColumnName, String addCriteria) {
		String tableName = "UltimateReferenceData";
		String columnName = "distinct " + refColumnName;
		String columnTypes = "columnTypes=int,string,string,string,string,string,int,int";
		String whereClause = "where Location_id = " + locationId + " and Work_Area_Type_Id = " + workAreaSelected + " "
				+ addCriteria;
		ArrayList<String> workAreaRef = new GetRawRefData().getRefData(tableName, columnName, whereClause, columnTypes);
		return workAreaRef.size();
	}

	public void validateMFStreamSelection() {
		ArrayList<String> fetchedData = checkStreamData(workAreaId, "Postal_Piece_Type_Desc", "", siteLocationId);

		// check mail format
		if (fetchedData.size() > 1) {
			validateMailFormats(workAreaId);
			selectRandomMailFormat(testHelper
					.getRandomNumber(countStreamData(siteLocationId, workAreaId, "Postal_Piece_Type_Desc", "")));
		} else {
			WebElement mailFormatF = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOf(mailFormatField));

			try {
				testHelper.fileWriter("Mail Format displayed: " + mailFormatF.getText(), "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Mail Format reference: " + fetchedData.toString(), "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Mail Format Selected: " + fetchedData.toString(), "C:\\DataResult\\result.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Assert.assertEquals(fetchedData.toString().replace("[", "").replace("]", "").toUpperCase(),
						mailFormatF.getText().replace("[", "").replace("]", "").toUpperCase());
			} catch (Exception e) {
				testHelper.writeErrorToLog(e.toString());

			}
		}

	}

	public void validateMCStreamSelection() {
		ArrayList<String> fetchedData = checkStreamData(workAreaId, "Postal_Class_Type_Desc",
				"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "')", siteLocationId);

		// check mail class
		if (fetchedData.size() > 1) {
			validateMailClasss(workAreaId, mailFormatField.getText());
			selectRandomMailClass(testHelper.getRandomNumber(countStreamData(siteLocationId, workAreaId,
					"Postal_Class_Type_Desc", "and Work_Area_Type_Id = " + workAreaId
							+ " and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "')")));
		} else {
			WebElement mailClassF = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOf(mailClassField));

			try {
				testHelper.fileWriter("Mail Class displayed: " + mailClassF.getText(), "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Mail Class reference: " + fetchedData, "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Mail Class selected: " + fetchedData, "C:\\DataResult\\result.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Assert.assertEquals(fetchedData.toString().replace("[", "").replace("]", "").toUpperCase(),
						mailClassF.getText().replace("[", "").replace("]", "").toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void validatePTStreamSelection() {
		ArrayList<String> fetchedData = checkStreamData(workAreaId, "Traffic_Mail_Type_Desc",
				"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
						+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText() + "')",
				siteLocationId);

		// check payment type
		if (fetchedData.size() > 1) {
			validatePaymentType(workAreaId, mailFormatField.getText(), mailClassField.getText());
			selectRandomPT(
					testHelper.getRandomNumber(countStreamData(siteLocationId, workAreaId, "Traffic_Mail_Type_Desc",
							"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
									+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText()
									+ "')")));
		} else {
			WebElement paymentTypeF = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOf(paymentTypeField));

			try {
				testHelper.fileWriter("Payment Type displayed: " + paymentTypeF.getText(),
						"C:\\DataResult\\result.txt");
				testHelper.fileWriter("Paymet Type reference: " + fetchedData.toString(), "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Paymet Type selected: " + fetchedData.toString(), "C:\\DataResult\\result.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Assert.assertEquals(fetchedData.toString().replace("[", "").replace("]", "").toUpperCase(),
						paymentTypeF.getText().replace("[", "").replace("]", "").toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void validateSMTStreamSelection() {
		ArrayList<String> fetchedData = checkStreamData(workAreaId, "Traffic_Mail_Sub_Type_Desc",
				"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
						+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText() + "') "
						+ "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" + paymentTypeField.getText() + "')",
				siteLocationId);

		// check sub mail type
		if (fetchedData.size() > 1) {
			validateSubMailType(workAreaId, mailFormatField.getText(), mailClassField.getText(),
					paymentTypeField.getText());
			selectRandomSubMailType(testHelper.getRandomNumber(countStreamData(siteLocationId, workAreaId,
					"Traffic_Mail_Sub_Type_Desc",
					"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
							+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText() + "') "
							+ "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" + paymentTypeField.getText() + "')")));
		} else {
			WebElement subMailTypeF = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOf(subMailTypeField));

			try {
				testHelper.fileWriter("Sub Mail Typ displayed: " + subMailTypeF.getText(),
						"C:\\DataResult\\result.txt");
				testHelper.fileWriter("Sub Mail Type reference: " + fetchedData.toString(),
						"C:\\DataResult\\result.txt");
				testHelper.fileWriter("Sub Mail Type selected: " + fetchedData.toString(),
						"C:\\DataResult\\result.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Assert.assertEquals(fetchedData.toString().replace("[", "").replace("]", "").toUpperCase(),
						subMailTypeF.getText().replace("[", "").replace("]", "").toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateStreamSelection() {
		ArrayList<String> fetchedData = checkStreamData(workAreaId, "Stream_Name",
				"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
						+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText() + "') "
						+ "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" + paymentTypeField.getText() + "')"
						+ "and UPPER(Traffic_Mail_Sub_Type_Desc) = UPPER('" + subMailTypeField.getText() + "')",
				siteLocationId);

		// check sub mail type
		if (fetchedData.size() > 1) {
			// check stream is valid
			validateStreamIdField(workAreaId);
			selectRandomStream(testHelper.getRandomNumber(countStreamData(siteLocationId, workAreaId, "Stream_Name",
					"and UPPER(Postal_Piece_Type_Desc) = UPPER('" + mailFormatField.getText() + "') "
							+ "and UPPER(Postal_Class_Type_Desc) = UPPER('" + mailClassField.getText() + "') "
							+ "and UPPER(Traffic_Mail_Type_Desc) = UPPER('" + paymentTypeField.getText() + "') "
							+ "and UPPER(Traffic_Mail_Sub_Type_Desc) = UPPER('" + subMailTypeField.getText() + "')")));
		} else {
			WebElement subMailTypeF = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.visibilityOf(streamIdField));

			try {
				testHelper.fileWriter("Stream displayed: " + subMailTypeF.getText(), "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Stream reference: " + fetchedData.toString(), "C:\\DataResult\\result.txt");
				testHelper.fileWriter("Stream selected: " + fetchedData.toString(), "C:\\DataResult\\result.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Assert.assertEquals(fetchedData.toString().replace("[", "").replace("]", "").toUpperCase(),
						subMailTypeF.getText().replace("[", "").replace("]", "").toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateContainerType(ArrayList<String> containerTypeId) {
		String tableName = "TMA_Container_Type";
		String columnName = "distinct UPPER(Container_Type_Desc)";
		String columnTypes = "columnTypes=int,string,int,string";
		String whereClause = "where Container_Type_Id in (" + Arrays
				.asList(containerTypeId.toString().split("\\s*,\\s*")).toString().replace("[", "").replace("]", "")
				+ ")";
		ArrayList<String> containerRef = new GetRawRefData().getRefData(tableName, columnName, whereClause,
				columnTypes);
		ArrayList<String> containers = new ArrayList<String>();
		List<WebElement> containerList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(containerType));
		Iterator<WebElement> iter = containerList.iterator();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			containers.add(we.getText().toUpperCase());
		}

		testHelper.compareList("Containers",containers, containerRef);
	}

	public void validateAndSelectContainer(ArrayList<String> containerTypeId) {
		String tableName = "TMA_Container_Type";
		String columnName = "distinct UPPER(Container_Type_Desc)";
		String columnTypes = "columnTypes=int,string,int,string";
		String whereClause = "where Container_Type_Id in (" + Arrays
				.asList(containerTypeId.toString().split("\\s*,\\s*")).toString().replace("[", "").replace("]", "")
				+ ")";
		ArrayList<String> containerRef = new GetRawRefData().getRefData(tableName, columnName, whereClause,
				columnTypes);
		ArrayList<String> containers = new ArrayList<String>();
		List<WebElement> containerList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(containerType));
		Iterator<WebElement> iter = containerList.iterator();
		int count = 0;

		while (iter.hasNext()) {
			WebElement we = iter.next();
			containers.add(we.getText().toUpperCase());
			count++;
		}

		try {
			testHelper.fileWriter("Containers displayed: " + containers, "C:\\DataResult\\result.txt");
			testHelper.fileWriter("Containers reference: " + containerRef, "C:\\DataResult\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		testHelper.compareList("Containers",containers, containerRef);
		selectRandomContainer(count - 1);
	}

	public void validateMultipleContainer() {
		List<WebElement> containerList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(containerType));
		System.out.println("Container count = " + containerList.size());
		try {
			Assert.assertTrue(containerList.size() > 1);
		} catch (Exception e) {
			testHelper.writeErrorToLog("Container list should be more than one");

		}

	}

	public void validateSingleContainer() {
		List<WebElement> containerList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(containerType));
		try {
			Assert.assertTrue(containerList.size() == 1);
		} catch (Exception e) {
			testHelper.writeErrorToLog("Container list should be one");

		}
	}

	public void selectRandomContainer(int index) {
		List<WebElement> containerTypeList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(containerType));
		containerTypeList.get(index).click();
	}

	public void selectScanButton() {
		WebElement scanb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scanbutton));
		// set the session data
		siteLocationId = getLocationId(siteLocation);
		streamId = getStreamId(streamIdField.getText());
		scanb.click();
	}

	public void selectScanAbnormalButton() {
		WebElement scanb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scanabnormalbutton));
		WebElement abacf = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(abnormal_acf));
		abnormalAcf = abacf.getText();
		scanb.click();
	}

	public void selectDoneButton() {
		WebElement doneb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(donebutton));
		doneb.click();
	}

	public void selectFaultyBarcodeButton() {
		WebElement fBarcodeb = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(faultyBarcodebutton));
		fBarcodeb.click();
	}

	public void validateContainerPopUp() {
		validateContainerType(getContainerTypeId(streamId, siteLocationId));
	}

	/**
	 * Randomly selects location, workarea, mail format, mail class payment
	 * type, submail type, stream
	 */
	public void populateAll(String locations) {

		if (locations.equals("")) {
			selectRandomLocation();
		} else {
			scrollAndSelectLocation(locations);
		}

		int size = getWorkAreaRefSize(siteLocationId);

		for (int x = 1; x <= size; x++) {
			System.out.println("Size valus is :" + size);
			System.out.println("X valus is :" + x);
			//if (x <= size) {
				selectWorkAreaIndex(x);
				// selectRandomWorkArea();
				checkShiftButtonEnabled();
				clickWorkAreaConfirmButton();
				validateMFStreamSelection();
				validateMCStreamSelection();
				validatePTStreamSelection();
				validateSMTStreamSelection();
				validateStreamSelection();
				System.out.println("Work area is " + workAreaId);
				if (workAreaId.equals("1000068") || workAreaId.equals("1000070") || workAreaId.equals("1000072")
						|| workAreaId.equals("1000091")) {
					selectDestinationLocation();
				}
				selectScanButton();
				selectFaultyBarcodeButton();
				validateAndSelectContainer(getContainerTypeId(streamId, siteLocationId));
				selectDoneButton();
				submitScan();
				backToShiftDetails();
			//}
		}
	}

	public void populateFromCaptureAtt() {
		validateMFStreamSelection();
		validateMCStreamSelection();
		validatePTStreamSelection();
		validateSMTStreamSelection();
		validateStreamSelection();
		if (workAreaId.equals("1000068") || workAreaId.equals("1000070") || workAreaId.equals("1000072")
				|| workAreaId.equals("1000091")) {
			selectDestinationLocation();
		}
		selectScanButton();
		selectFaultyBarcodeButton();
		validateAndSelectContainer(getContainerTypeId(streamId, siteLocationId));
		selectDoneButton();
		submitScan();
	}

	public void populateFromCaptureAttNoSub() {
		validateMFStreamSelection();
		validateMCStreamSelection();
		validatePTStreamSelection();
		validateSMTStreamSelection();
		validateStreamSelection();
		try {
			selectDestinationLocation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateScanSuccesfull() {
		WebElement bcode = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(barcode));
		WebElement averagecf = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(acf));
		WebElement container = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(container_type));
		WebElement time = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scantime));
		try {
			Assert.assertNotNull(bcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertNotNull(averagecf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertNotNull(container);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertNotNull(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancelScan() {
		WebElement cancel = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(cancelscanbutton));
		cancel.click();
		
		// dismiss unsubmitted scan pop up
		
				 try { leave(); } catch (Exception e) { e.printStackTrace(); }
				
	}

	public void submitScan() {
		WebElement submit = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(submitbutton));
		WebElement time = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scantime));

		// capture the latest submission time
		lastTransTime = time.getText();
		submit.click();
	}

	public void checkCaptureAttPageIsInFocus() {
		WebElement capAtt = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(captureAttributeRegion));
		Assert.assertTrue(capAtt.isDisplayed());
	}

	public void checkScanPageIsInFocus() {
		WebElement faultbarcode = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(faultybarcode));
		Assert.assertTrue(faultbarcode.isDisplayed());
	}

	/**
	 * add the captured attributes in session variables
	 */
	public void setCaptureAttSession() {
		WebElement MF = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(mailFormatField));
		mailFormat = MF.getText();

		WebElement MC = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(mailClassField));
		mailClass = MC.getText();

		WebElement PT = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(paymentTypeField));
		paymentType = PT.getText();

		WebElement SMT = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(subMailTypeField));
		subMailType = SMT.getText();

		WebElement ST = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(streamIdField));
		stream = ST.getText();
	}

	/**
	 * compare attribute data in focus with captured attribute data
	 */
	public void assertCaptureAttSession() {
		WebElement MF = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(mailFormatField));
		Assert.assertEquals(mailFormat, MF.getText());

		WebElement MC = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(mailClassField));
		Assert.assertEquals(mailClass, MC.getText());

		WebElement PT = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(paymentTypeField));
		Assert.assertEquals(paymentType, PT.getText());

		WebElement SMT = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(subMailTypeField));
		Assert.assertEquals(subMailType, SMT.getText());

		WebElement ST = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(streamIdField));
		Assert.assertEquals(stream, ST.getText());
	}

	public void assertMaxEntryMessageDisplayed() {
		WebElement MF = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(entrylimit));
		Assert.assertTrue(MF.isDisplayed());
	}

	public void dismissPopUp() {
		new Actions(driver).sendKeys(SelendroidKeys.ENTER).perform();
	}

	public void selectAbnormalPosting() {
		WebElement abnormalb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(abnormalbutton));
		siteLocationId = getLocationId(siteLocation);
		streamId = getStreamId(streamIdField.getText());
		;
		abnormalb.click();
	}

	public void verifyPageTitle(String page) {
		/*
		 * List<WebElement> summaryList = (new WebDriverWait(driver, 60))
		 * .until(ExpectedConditions.visibilityOfAllElements(pageTitle));
		 * Iterator<WebElement> iter = summaryList.iterator(); String pageTitle
		 * = ""; Boolean found = false;
		 * 
		 * if (page.equalsIgnoreCase("AbnormalPosting")){ pageTitle = streamId;
		 * }
		 * 
		 * while (iter.hasNext()) { WebElement we = iter.next(); if
		 * (we.getText().equals(streamId)); found = true; }
		 * 
		 * Assert.assertTrue(found);
		 */
		System.out.println("pending");
	}

	public void confirmPageTitle(String page) {

		/*
		 * WebElement summaryList = (new WebDriverWait(driver, 60))
		 * .until(ExpectedConditions.visibilityOf(shiftHistoryTitle)); Boolean
		 * found = false;
		 * 
		 * if (summaryList.getText().equals("Shift History")); found = true;
		 * 
		 * Assert.assertTrue(found);
		 */

		System.out.println("Pending");
	}

	public void abnormalAcfFieldDisplayed() {
		WebElement aACF = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(abnormal_acf));
		Assert.assertTrue(aACF.isDisplayed());
	}

	public void customerNameFieldDisplayed() {
		WebElement cName = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(customer_name));
		Assert.assertTrue(cName.isDisplayed());
	}

	public void scanButtonDisplayed() {
		try {
			WebElement scanb = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scanabnormalbutton));
			Assert.assertTrue(scanb.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scanPageInFocus() {
		try {
			WebElement scanp = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(bigArrow));
			Assert.assertTrue(scanp.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void populateAbnormalValues(String aAcf, String customer) {
		WebElement abacf = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(abnormal_acf));
		WebElement cName = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(customer_name));
		abacf.sendKeys(aAcf);
		cName.sendKeys(customer);
	}

	@SuppressWarnings("deprecation")
	public void longPressDelete() {
		TouchActions touch_action = new TouchActions(driver);
		WebElement buttonPress = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(card));
		Point p = buttonPress.getLocation();
		touch_action.down(p.x, p.y);

		touch_action.pause(500);
		touch_action.up(p.x, p.y);
		touch_action.perform();
	}

	public void deleteCheckboxDislayed() {
		WebElement check = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(checkBox));
		Assert.assertTrue(check.isDisplayed());
	}

	public void cancelDelete() {
		WebElement delete = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(closeButton));
		delete.click();
	}

	public void validateDeleteMode() {
		WebElement check = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(checkBox));
		Assert.assertTrue(check.isDisplayed());
		WebElement close = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(closeButton));
		Assert.assertTrue(close.isDisplayed());
		WebElement del = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(delete));
		Assert.assertTrue(del.isDisplayed());
	}

	public void selectAndDelete() {
		WebElement time = (new WebDriverWait(driver, 180)).until(ExpectedConditions.visibilityOf(scantime));
		deletedTime = time.getText();

		WebElement check = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(checkBox));
		check.click();

		WebElement del = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(delete));
		del.click();
	}

	public void selectAndDeleteHistory() {
		WebElement time = (new WebDriverWait(driver, 180)).until(ExpectedConditions.visibilityOf(time_stamp));
		deletedTime = time.getText();

		WebElement check = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(checkBox));
		check.click();

		WebElement del = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(delete));
		del.click();
	}

	public void validateScanPageDislayed() {
		WebElement scanP = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(scanPage));
		Assert.assertTrue(scanP.isDisplayed());
	}

	public void selectShiftHistory() {
		WebElement menu = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(menubutton));
		// click on the menu button
		menu.click();

		Boolean found = false;

		List<WebElement> menuList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(logouttext));
		Iterator<WebElement> iter = menuList.iterator();

		// iterate work area values returned by the ui and add them to an array
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (!found) {
				if (we.getText().equalsIgnoreCase("Shift History")) {
					found = true;
					we.click();
				}
			}
		}
	}

	public void confirmTransExist() {

		List<WebElement> summaryList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(transactionNumber));

		Assert.assertTrue(summaryList.size() > 0);

		WebElement bcode = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(barcode));
		WebElement averagecf = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(acf_history));
		WebElement container = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(container_type));
		WebElement time = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(time_stamp));
		WebElement countAcf = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(acf));
		WebElement h_stream_name = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(hist_stream_name));

		Assert.assertNotNull(h_stream_name);
		Assert.assertNotNull(bcode);
		Assert.assertNotNull(averagecf);
		Assert.assertNotNull(container);
		Assert.assertNotNull(time);
		Assert.assertNotNull(countAcf);
	}

	/*
	 * Checks that the latest submission(s) is on top of the list
	 */
	public void confirmHistory() {
		WebElement time = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(time_stamp));
		Assert.assertEquals(lastTransTime, time.getText());
	}

	public void confirmHisDuration() throws ParseException {
		List<WebElement> timeList = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOfAllElements(all_time_stamp));
		Iterator<WebElement> iter = timeList.iterator();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		String currTime = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
				+ calendar.get(Calendar.SECOND);

		while (iter.hasNext()) {
			WebElement we = iter.next();
			Assert.assertTrue(testHelper.compareHistoryDates(we.getText(), currTime, 3600));

		}
	}

	public void checkRecordIsDeleted() {
		List<WebElement> timeList = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfAllElements(all_time_stamp));
		Iterator<WebElement> iter = timeList.iterator();
		Boolean exists = false;
		String uitime = "";

		while (iter.hasNext()) {
			WebElement we = iter.next();

			try {
				uitime = we.getText();
			} catch (Exception e) {
			}
			if (uitime.equals(deletedTime))
				exists = true;
		}

		System.out.println("Deleted time = " + deletedTime + "and exists =" + exists);

		Assert.assertFalse(exists);
	}

	public void confirmCaptureAttPageVisible() {
		WebElement capturePage = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(captureAttributeRegion));

	}

	public void scanLimitWarn() {
		WebElement limit = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(limitReachedText));

		Assert.assertTrue(limit.isDisplayed());
	}

	public void checkMQ() throws MQException {
		List<WebElement> timeList = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOfAllElements(all_time_stamp));
		Iterator<WebElement> iter = timeList.iterator();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		String currTime = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
				+ calendar.get(Calendar.SECOND);

		while (iter.hasNext()) {
			WebElement we = iter.next();
			mQueue.checkQueue(loggedInUser, we.getText());

		}
	}

	public void checkAPInputDataLength() {
		WebElement abacf = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(abnormal_acf));
		WebElement cName = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(customer_name));
		Assert.assertTrue(!(abacf.getText().length() > 4));
		Assert.assertTrue(!(cName.getText().length() > 250));
	}

	public void scrollAndSelectLocation(String location) {
		Boolean found = false;
		WebElement locationSelect = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOf(locationbutton));
		locationSelect.click();

		List<WebElement> locationList = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOfAllElements(locationdropdown));

		Iterator<WebElement> iter = locationList.iterator();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().equalsIgnoreCase(location)) {
				found = true;
				siteLocation = we.getText();
				siteLocationId = getLocationId(we.getText());
				we.click();
				break;
			}
		}

		if (!found) {
			TouchActions touch = new TouchActions(driver).flick(locationdropdownScroll, 0, -1700, 100000);
			touch.perform();

			Iterator<WebElement> iter2 = locationList.iterator();
			// iterate work area values returned by the ui and add them to an
			// array
			while (iter2.hasNext()) {
				WebElement we = iter2.next();
				if (we.getText().equalsIgnoreCase(location)) {
					found = true;
					siteLocation = we.getText();
					siteLocationId = getLocationId(we.getText());
					we.click();
					break;
				}

			}
		}
		// scroll to the end
		if (!found) {
			TouchActions touch = new TouchActions(driver).flick(locationdropdownScroll, 0, -1700, 100000);
			touch.perform();

			Iterator<WebElement> iter3 = locationList.iterator();
			// iterate work area values returned by the ui and add them to an
			// array
			while (iter3.hasNext()) {
				WebElement we = iter3.next();
				if (we.getText().equalsIgnoreCase(location)) {
					found = true;
					siteLocation = we.getText();
					siteLocationId = getLocationId(we.getText());
					we.click();
					break;
				}

			}
		}

		try {
			testHelper.fileWriter("******************************* " + siteLocation + " ****************************",
					"C:\\DataResult\\result.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> scroll(WebElement buttonId, List<WebElement> scrollId, WebElement scrollBtn) {
		WebElement scrollSelect = (new WebDriverWait(driver, 180)).until(ExpectedConditions.visibilityOf(buttonId));
		scrollSelect.click();

		List<WebElement> doList = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.visibilityOfAllElements(scrollId));

		Iterator<WebElement> iter = doList.iterator();
		ArrayList<String> scrollData = new ArrayList<String>();

		while (iter.hasNext()) {
			WebElement we = iter.next();
			scrollData.add(we.getText().toUpperCase());
		}

		// scroll first data set
		TouchActions touch = new TouchActions(driver).flick(scrollBtn, 0, -1700, 100000);
		touch.perform();

		Iterator<WebElement> iter2 = doList.iterator();
		// iterate values returned by the ui and add them to an
		// array
		while (iter2.hasNext()) {
			WebElement we = iter2.next();
			scrollData.add(we.getText().toUpperCase());
		}

		// scroll to the end
		TouchActions touch1 = new TouchActions(driver).flick(scrollBtn, 0, -1700, 100000);
		touch1.perform();

		Iterator<WebElement> iter3 = doList.iterator();
		// iterate work area values returned by the ui and add them to an
		// array
		while (iter3.hasNext()) {
			WebElement we = iter3.next();
			scrollData.add(we.getText().toUpperCase());
		}

		scrollData.remove("PLEASE SELECT");

		// remove duplicates
		Set<String> hs = new HashSet<>();
		hs.addAll(scrollData);
		scrollData.clear();
		scrollData.addAll(hs);
		return scrollData;

	}

	public void checkLocationIsCached() {
		WebElement locationVal = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(locationValue));
		System.out
				.println("original siteLocation = " + siteLocation + "and cached location = " + locationVal.getText());
		Assert.assertEquals(siteLocation, locationVal.getText());

	}

	public void checkShiftDestLocation() {
		WebElement shiftLocationVal = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(shiftDestinationLocation));
		Assert.assertEquals(destinationLocation.toString().replace("[", "").replace("]", "").toUpperCase(),
				shiftLocationVal.getText().replace("[", "").replace("]", "").toUpperCase());
	}

	public void adHocActivities(String location) {
		int iteration = 1;

		enterUserId("sit01.testuser");
		enterUserPin("1234");
		clickLoginButton();

		int count = 5;

		/**
		 * Submit scans
		 */
		for (int x = 0; x < count; x++) {
			populateAll(location);
			System.out.println("Create and submitting scans");
			backToShiftDetails();
		}

		for (int x = 0; x < 5; x++) {

			int random = getRandomNumber(5);

			if (random == 0) {
				// go to shift details (work area)
				backToShiftDetails();
				selectRandomWorkArea();
				clickWorkAreaConfirmButton();
				System.out.println("go to shift details (work area)");
			} else if (random == 1) {
				/**
				 * go to shift history, select a stream and submit
				 */
				backToShiftDetails();
				selectRandomWorkArea();
				clickWorkAreaConfirmButton();
				populateFromCaptureAtt();
				System.out.println("go to shift history, select a stream and submit");
			} else if (random == 2) {
				/**
				 * go to shift history, delete a record and assert
				 */
				selectShiftHistory();
				longPressDelete();
				selectAndDeleteHistory();
				// checkRecordIsDeleted();
				System.out.println("go to shift history, delete a record and assert");
			} else if (random == 3) {
				/**
				 * go to shift history, select a stream and go back
				 */
				backToShiftDetails();
				selectRandomWorkArea();
				clickWorkAreaConfirmButton();
				populateFromCaptureAttNoSub();
				goBack();
				System.out.println("go to shift history, select a stream and go back");
			} else if (random == 4) {
				backToShiftDetails();
				selectRandomWorkArea();
				clickWorkAreaConfirmButton();
				populateFromCaptureAttNoSub();
				selectAbnormalPosting();
				populateAbnormalValues("123", "Michael");
				selectScanAbnormalButton();
			}
		}
	}

	public int getRandomNumber(int number) {
		return testHelper.getRandomNumber(number);
	}

	public void leave() {
		leave.click();
	}

	public void stay() {
		stay.click();
	}
	
	public void createLogFile(){
		testHelper.createErrorFile();	
	}
}
