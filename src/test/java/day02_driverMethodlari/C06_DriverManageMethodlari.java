package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMethodlari {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // implicity wait gittigimiz sayfa aciloincaya veya aradigimiz webelement bulununcaya kadar
        // driver'in bekleyebilecegi max sureyi belirler

        // bu dortlu her test method'unun basina yazilacak


    }
}
