import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteInicial {
	private WebDriver driver;
	private String baseURL;
	private static String driverPath="C:\\Users\\victor.bittencourt.075\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		baseURL = "C:\\Users\\victor.bittencourt.075\\Downloads\\pagina.html";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void testSite() throws Exception{
		driver.get(baseURL);
		int qtd = driver.findElements(By.className("container")).size();
		assertTrue(qtd>0);
	}
	@Test
	public void testCriar() throws Exception{
		driver.get(baseURL);
		driver.findElement(By.className("btn")).click();
		assertTrue(driver.findElement(By.id("exampleInputEmail1")).getText().contains("Erro"));
	}
	@After
	public void tearDown() {
		driver.close();
	}
	
}
