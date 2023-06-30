package hooks;


import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;

    public Hooks(TestContext context){
        this.context = context;
    }

    /*@BeforeAll
    public static void  beforeAll(){
        System.out.println("In BeforeAll hook");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("In AfterAll hook");
    }*/

    @Before
    public void  before(Scenario scenario){
        context.scenarioName = scenario.getName();
        System.out.println("In Before hook");
        System.out.println("BEFORE: THREAD ID: " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        System.out.println("AFTER: THREAD ID: " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME " + scenario.getName());
    }

    @After
    public void after() {
        driver.quit();
        System.out.println("In After hook");

    }
}
