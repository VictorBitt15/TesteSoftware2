import org.junit.Test;

public class Main {
    private static String driverPath="C:\\Users\\victor.bittencourt.075\\Downloads\\chromedriver_win32\\chromedriver.exe";
    private static WebDriver driver; 
    
    @Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    @Test
    public void testTamanho(){
        ObjectTest Tester= new ObjectTest(driver);
        assertTrue(Tester.tamanhoSite());
    }
    @Test
    public void testCriar(){
        ObjectTest Tester = new ObjectTest(driver);
        assertTrue(Tester.botaoSemCredendiais);
    }

    @After
	public void tearDown() {
		driver.close();
	}
}
