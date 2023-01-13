package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i 3 farkli relative locator ile locate edin

             // a- Sailor'in ustundeki diyelim
        WebElement sailorElementi = driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));

            // b-Boston'in sagi diyelim, bunun icin once Boston locate etmeliyiz
        WebElement bostonElementi = driver.findElement(By.xpath("//p[text()='Boston']"));
       // tarif etmek istediginiz elementin bir ozelligini kullanmalisiniz
        // ornegin tagName= img

        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));

                // c-NYC altindaki diyecegiz
        WebElement nyc= driver.findElement(By.xpath("//p[text()='NYC']"));
        WebElement berlin3= driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));

        // eger bir tane elementten tarif ettigimizde yine de bulamazsak
        // birden fazla element ile refere edebiliriz
        WebElement berlin4 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc).toRightOf(bostonElementi).above(sailorElementi));
        //3 ) Relative locator’larin dogru calistigini test edin

        // id'si pid7_thumb oldugunu test edelim (1. islem icin)
        String expectedIdDegeri="pid7_thumb";
        String actualIdDegeri = berlin1.getAttribute("id");

        if (expectedIdDegeri.equals(actualIdDegeri)) {
            System.out.println("Relative Locator testi 1 PASSED");
        }else {
            System.out.println("Relative Locator testi 1 FAILED");
        }

        // berlin2 yi test edelim yukardaki kod ayni(ya sadece berlin1 i 2 yap, ya da ayri ayri calismasi icin strin degerleri de yeniden atamak gerek

        String expectedIdDegeri2="pid7_thumb";
        String actualIdDegeri2= berlin2.getAttribute("id");

        if (expectedIdDegeri.equals(actualIdDegeri)) {
            System.out.println("Relative Locator testi 2 PASSED");
        }else {
            System.out.println("Relative Locator testi 2 FAILED");
        }

// berlin3 u test ediyoruz
        String expectedIdDegeri3="pid7_thumb";
        String actualIdDegeri3= berlin2.getAttribute("id");

        if (expectedIdDegeri.equals(actualIdDegeri)) {
            System.out.println("Relative Locator testi 3 PASSED");
        }else {
            System.out.println("Relative Locator testi 3 FAILED");
        }

        // berlin4 u test ediyoruz
        String expectedIdDegeri4="pid7_thumb";
        String actualIdDegeri4= berlin2.getAttribute("id");

        if (expectedIdDegeri.equals(actualIdDegeri)) {
            System.out.println("Relative Locator testi 4 PASSED");
        }else {
            System.out.println("Relative Locator testi 4 FAILED");
        }


        Thread.sleep(3000);
        driver.close();
    }
}
