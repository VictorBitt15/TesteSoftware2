import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Main {
    private static String driverPath="C:\\Users\\victor.bittencourt.075\\Downloads\\chromedriver_win32\\chromedriver.exe";
    private static WebDriver driver; 
    private ObjectTest objectTest;
    
    @Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.objectTest = new ObjectTest(driver);
	}
    @Test
    public void testTamanho(){
        assertTrue(this.objectTest.tamanhoSite());
    }
    @Test
    public void testCriar(){
        assertTrue(this.objectTest.botaoSemCredendiais());
    }
    @Test
    public void testPreencherCorreto(){
        assertTrue(this.objectTest.PreencherCorreto());
    }
    @Test
    public void testPreencherIncorreto(){
        assertTrue(this.objectTest.PreencherIncorreto());
    }

    @Test
    public void testChecked(){
        assertTrue(this.objectTest.Checked());
    }
    @After
	public void tearDown() {
		driver.close();
	}
}
