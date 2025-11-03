
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DetectAutomationReader {
    public static void main(String[] args) throws Exception {
        // set your chromedriver path
        //System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        ChromeOptions opts = new ChromeOptions();
        // comment/uncomment headless to compare differences
        // opts.addArguments("--headless=new");
        opts.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(opts);
        try {
            // use file:// URL pointing to your saved file
            String path = "https://lijoraj-p-r.github.io/testEnvironment/"; // update to your path
            driver.get(path);

            // small delay for JS to populate page
            Thread.sleep(800);

            // read the displayed fields
            String webdriver = driver.findElement(By.id("webdriver")).getText();
            String ua = driver.findElement(By.id("ua")).getText();
            String plugins = driver.findElement(By.id("plugins")).getText();
            String webgl = driver.findElement(By.id("webgl")).getText();
            String headless = driver.findElement(By.id("headless")).getText();
            String eventsLog = driver.findElement(By.id("eventsLog")).getText();

            System.out.println("=== DETECTION FIELDS ===");
            System.out.println("navigator.webdriver: " + webdriver);
            System.out.println("userAgent: " + ua);
            System.out.println("plugins.length: " + plugins);
            System.out.println("webgl: " + webgl);
            System.out.println("headless indicators: " + headless);
            System.out.println("\nRecent events:\n" + (eventsLog.length()>200 ? eventsLog.substring(0,200) + "...\n" : eventsLog));

            // also dump console logs if you want (requires enabling logging prefs) - omitted here for brevity

            // keep browser open briefly so you can also visually inspect
            Thread.sleep(4000);
        } finally {
            driver.quit();
        }
    }
}
