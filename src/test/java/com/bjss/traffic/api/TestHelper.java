package com.bjss.traffic.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestHelper extends ArrayList<String> {

	private static String fileName;

	public TestHelper() {

	}

	/**
	 * Compares the values of 2 lists. Returns not found if value1 is not
	 * missing in value2
	 * 
	 * @param uiList
	 * @param refList
	 */
	public void compareList(String module, ArrayList<String> uiList, ArrayList<String> refList) {

		boolean notFound = false;

		for (int i = 0; i < uiList.size(); i++) {
			if (refList.contains(uiList.get(i))) {
				System.out.println("UI list displayed" + uiList.get(i));
			} else {
				notFound = true;
				break;
			}
		}

		// System.out.println("From UI" + uiList);
		// System.out.println("From Ref Data" + refList);
		try {
			Assert.assertEquals(uiList.size(), refList.size());
		} catch (AssertionError e) {

			writeErrorToLog(module + "failed ui has" + uiList.size() + "and reference data has " + refList.size());

		}
		try {
			Assert.assertFalse(notFound);
		} catch (AssertionError e) {
			writeErrorToLog(module + "failed ui contains" + uiList + "and reference data contains " + refList);

			throw e;
		}

	}

	public boolean isAttribtuePresent(String elementId, WebDriver driver) {
		return driver.findElement(By.id(elementId)).getText() != null;
	}

	public int getRandomNumber(int maxNumber) {
		Random rand = new Random();
		int x = rand.nextInt(maxNumber - 1);
		return x;
	}

	/*
	 * Checks to see if the transaction dates are within the duration specified
	 */
	public Boolean compareHistoryDates(String source, String base, int seconds) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Date firstParsedDate = dateFormat.parse(source);
		Date secondParsedDate = dateFormat.parse(base);
		long diff = secondParsedDate.getTime() - firstParsedDate.getTime();
		System.out.println("time difference : " + diff);
		System.out.println("source :" + source + "/ base = " + base);
		return diff / 1000 <= seconds;
	}

	public void fileWriter(String text, String filename) throws IOException {

		Writer output;
		output = new BufferedWriter(new FileWriter(filename, true));
		output.append(System.lineSeparator());
		output.append(text);
		output.close();
	}

	public void writeErrorToLog(String message) {
		Writer output;
		try {
			output = new BufferedWriter(new FileWriter(fileName, true));

			output.append(System.lineSeparator());

			output.append(message);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createErrorFile() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		String formatted = formatDate.format(cal.getTime());

		try {

			File file = new File("C:\\TestResults\\" + formatted + ".txt");
			fileName = file.toString();

			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean contains(Object o) {
		String paramStr = (String) o;
		for (String s : this) {
			if (paramStr.equalsIgnoreCase(s))
				return true;
		}
		return false;
	}

}
