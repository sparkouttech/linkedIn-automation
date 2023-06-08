package main;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browser_setup {

	public static ChromeDriver driver;

	public static Wait<WebDriver> wait;

	public static JavascriptExecutor js;

	public static void setup(String baseURL) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		ChromeOptions options = new ChromeOptions();

		options.setHeadless(false);

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get(baseURL);

		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class);

		js = (JavascriptExecutor) driver;

	}

}
