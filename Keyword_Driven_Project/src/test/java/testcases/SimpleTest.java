package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://practice.expandtesting.com/login");
		
		WebElement userName=driver.findElement(By.id("username"));
		userName.sendKeys("practice");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		
		WebElement login=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		login.click();
		

	}

}
