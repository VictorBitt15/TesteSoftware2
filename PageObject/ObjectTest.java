import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectTest {
	private WebDriver driver;
	private String baseURL = "C:\\Users\\victor.bittencourt.075\\Downloads\\paginamod.html";
	
	public ObjectTest(WebDriver webdriver){
		this.driver = webdriver;
		driver.get(baseURL);
	}
	
	
	public boolean tamanhoSite(){
		driver.get(baseURL);
		int qtd = driver.findElements(By.className("container")).size();
		return qtd>0;
	}

	public boolean botaoSemCredendiais(){
		driver.get(baseURL);
		driver.findElement(By.className("btn")).click();
		return !driver.findElement(By.id("email1")).getAttribute("validationMessage").isEmpty();
	}
	@Test
	public void testPreencherCorreto() throws Exception{
		try {
			driver.get(baseURL);
			driver.findElement(By.id("email1")).sendKeys("fulano@outlook.com");
			driver.findElement(By.id("psw1")).sendKeys("123456");
			driver.findElement(By.className("btn")).click();
			assertTrue(!driver.switchTo().alert().getText().isBlank());
			driver.switchTo().alert().accept();
		
		} catch (UnhandledAlertException e) {
		
			}
	}
	@Test
	public void testPreencherIncorreto() throws Exception{
		try {
			driver.get(baseURL);
			driver.findElement(By.id("email1")).sendKeys("fulanooutlook.com");
			driver.findElement(By.id("psw1")).sendKeys("123456");
			driver.findElement(By.className("btn")).click();
			assertTrue(!driver.findElement(By.id("email1")).getAttribute("validationMessage").isEmpty());
		
		} catch (UnhandledAlertException e) {
			
		}
	}
	
	@Test
	public void testChecked() throws Exception{
		driver.get(baseURL);
		driver.findElement(By.className("checkbox")).findElement(By.tagName("INPUT")).click();
		driver.findElement(By.id("optionsCheckbox2")).click();
		driver.findElement(By.id("optionsRadios2")).click();
		driver.findElement(By.className("btn")).click();
		assertTrue(!driver.findElement(By.id("email1")).getAttribute("validationMessage").isEmpty());

	}
	
	
	
}
