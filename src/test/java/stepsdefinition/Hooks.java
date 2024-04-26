package stepsdefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

 public class Hooks{
     private final TestContext testContext;

     public Hooks(TestContext context) {
         this.testContext = context;
     }
    @Before
    public void setUp() {
         testContext.setDriver(new ChromeDriver());
         testContext.getDriver().manage().window().maximize();
         testContext.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();
        }
    }
}