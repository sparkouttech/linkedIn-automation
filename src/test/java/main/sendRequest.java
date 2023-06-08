package main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class sendRequest extends browser_setup {

	public static String value;

	public static List<String> nameList = new ArrayList<String>();

	public static void searchPeople(String name, String country) throws Exception {

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='share-box-feed-entry__top-bar']")));

		// Search the People with technology name

		WebElement searchaPeople = driver.findElement(By.xpath("//input[@placeholder='Search']"));

		searchaPeople.click();

		searchaPeople.sendKeys(name);

		searchaPeople.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='People']")));

		WebElement clickPeople = driver.findElement(By.xpath("//button[text()='People']"));

		clickPeople.click();

		// Choose a location

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='People']")));

		WebElement Locations = driver.findElement(By.xpath("//button[text()='Locations']"));

		Locations.click();

		WebElement searchLocation = driver.findElement(By.xpath("//input[@placeholder='Add a location']"));

		searchLocation.sendKeys(country);

		Thread.sleep(2000);

		searchLocation.sendKeys(Keys.ARROW_DOWN);

		searchLocation.sendKeys(Keys.ENTER);

		WebElement showResults = driver.findElement(By.xpath("(//span[text()='Show results'])[2]"));

		showResults.click();

	}

	public static List<String> sendConnectRequest(int pageCount) throws Exception {

		for (int i = 1; i <= pageCount; i++) {

			// Execute the details based on the page

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='People']")));

			for (int j = 1; j <= 10; j++) {

				Thread.sleep(2000);

				String peopleNameXpath = "(//*[@class ='entity-result__title-line entity-result__title-line--2-lines '])"
						+ "[" + j + "]";

				WebElement peopleName = driver.findElement(By.xpath(peopleNameXpath));

				peopleName.click();

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='More'])[2]")));

				Thread.sleep(1000);

				WebElement userNameis = driver.findElement(
						By.xpath("//h1[@class='text-heading-xlarge inline t-24 v-align-middle break-words']"));

				String name = userNameis.getText();

				String value = driver.getCurrentUrl();

				nameList.add(value);

				try {

					// Send a connect request to the peoples

					WebElement connect = driver.findElement(By.xpath("(//span[text()='Connect'])[2]"));

					connect.click();

					Thread.sleep(1000);

					WebElement sendConnect = driver.findElement(By.xpath("//span[text()='Send']"));

					sendConnect.click();

					System.out.println("The Connection request sent to " + name);

				} catch (Exception e) {

					try {

						// Send the follow request to users

						WebElement follow = driver.findElement(By.xpath("(//span[text()='Follow'])[2]"));

						follow.click();

						System.out.println("The Follow request sent to " + name);

					} catch (Exception f) {

						// If we already follow then just exit the loop

						System.out.println("Unable to or We already follow " + name);

					}

				}

				Thread.sleep(1000);

				driver.navigate().back();

				Thread.sleep(1000);

				driver.navigate().refresh();

				if (j % 2 == 0) {

					// Thread.sleep(125000);

				} else {

					continue;

				}

			}

			// Click the Next button

			System.out.println("The request sent completed for page " + i);

			Thread.sleep(1000);

			try {

				// Avoid the last page failure exception

				if (i != pageCount) {

					js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Next']")));

					WebElement nextPage = driver.findElement(By.xpath("//span[text()='Next']"));

					nextPage.click();

					Thread.sleep(1000);

					driver.navigate().refresh();

				} else {

					continue;

				}

			} catch (Exception f) {

				continue;

			}

		}

		System.out.println("All the request sent to the peoples");

		return nameList;

	}
}
