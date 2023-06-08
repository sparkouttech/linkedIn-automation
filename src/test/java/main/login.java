package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class login extends browser_setup {

	public static void userLogin(String userEmail, String Password) throws Exception {

		String linkedin = "https://www.linkedin.com/authwall?trk=qf&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2F";

		browser_setup.setup(linkedin);

		Thread.sleep(1000);
		WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),' Sign in ')]"));

		signIn.click();

		WebElement emailAddress = driver.findElement(By.xpath("//input[@autocomplete = 'username']"));

		emailAddress.sendKeys(userEmail);

		WebElement userPassword = driver.findElement(By.xpath("//input[@autocomplete = 'current-password']"));

		userPassword.sendKeys(Password);

		WebElement submit = driver.findElement(By.xpath("(//button[contains(text(),'Sign in')])[2]"));

		submit.click();

		Thread.sleep(2000);

	}

}
