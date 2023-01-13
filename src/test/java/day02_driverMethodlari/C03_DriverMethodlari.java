package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe") ;
        WebDriver driver = new ChromeDriver() ;

        driver.get("https://www.amazon.com");
        // System.out.println(driver.getPageSource());

        // pageSource'un MEOW icerdigini test edin

        String pageSource = driver.getPageSource();

        String  expectedKelime = "MEOW" ;

        if (pageSource.contains(expectedKelime)) {
            System.out.println("page source testi PASSED");

        }else {
            System.out.println("page sourse testi FAILED, MEOW kelimesi bulunamadi");
        }

    }
}
