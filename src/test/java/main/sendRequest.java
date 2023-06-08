package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class sendRequest extends browser_setup {

	public static String value;

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

	public static void sendConnectRequest(int pageCount) throws Exception {

		int i = pageCount;

		for (i = 1; i <= pageCount; i++) {

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

				value = userNameis.getText();

				try {

					WebElement connect = driver.findElement(By.xpath("(//span[text()='Connect'])[2]"));

					connect.click();

					Thread.sleep(1000);

					WebElement sendConnect = driver.findElement(By.xpath("//span[text()='Send']"));

					sendConnect.click();

					System.out.println("The Connection request sent to " + value);

				} catch (Exception e) {

					try {

						WebElement follow = driver.findElement(By.xpath("(//span[text()='Follow'])[2]"));

						follow.click();

						System.out.println("The Follow request sent to " + value);

					} catch (Exception f) {

						System.out.println("Unable to or We already follow " + value);

					}

				}

				Thread.sleep(1000);

				driver.navigate().back();

				Thread.sleep(1000);

				driver.navigate().refresh();

				if (j % 2 == 0) {

					Thread.sleep(125000);

				} else {

					continue;

				}

			}

			// Click the Next button

			System.out.println("The request sent completed for page " + i);

			Thread.sleep(1000);

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Next']")));

			WebElement nextPage = driver.findElement(By.xpath("//span[text()='Next']"));

			nextPage.click();

			Thread.sleep(1000);

			driver.navigate().refresh();

		}

		System.out.println("All the request sent to the peoples");

	}

}
