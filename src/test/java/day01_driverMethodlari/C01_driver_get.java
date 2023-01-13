package day01_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01_driver_get {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\nesri\\OneDrive\\Desktop\\Git\\com.Team105Selenium\\src\\drivers\\chromedriver.exe");

        //windows sonda .exe olmali, mac icin gerek yok

        WebDriver driver =new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("profile.default_content_setting_values.cookies");

        driver.get("https://www.amazon.com");


        // driver.get satirini siler, yoruma alir sonra clss calistirisak, yine bir pencere aciliyor
        // bos ve data olayan ve otamosyon yazilim tarafidan
        // kontrol edildigini belirten bir sayfa

        /*
        12.satırda ChromeDriver() constructor'ını kullanarak bir obje olusturduk
        bu objeyi kullanmasak bile bu satırdan dolayı bos bir browser acilir*/

        // WebElement closeCookies=driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        //  closeCookies.click();
        //driver.manage().getCookies();   // Return The List of all Cookies
        // driver.manage().deleteAllCookies();

        // sayfayi kapatma komutu verdigimizde, cok hizli kapatiyor, onceside
        //  bir sure bekleyip, sayfayi daha sonra kapatmasi icin bir bekleme suresi
        // belirtiyoruz, tabii bunu kapatma komutundan once yapmamiz gerek

         Thread.sleep(5000);
         // bu kodda sleep alti cizili, ignore ediyoruz ve exception throws geliyor class basina

       // actigimiz sayfanin, kendiliginden kapanmasini istiyorsak

         driver.close();

          /*
        1-Selenium jar dosyalarini ve chromedriver driver'ini manuel
        olarak sisteme tanittik

        Eger firefox veya safari ile calismamiz gerekse,
        bu defa onlarin driver'larini indirip, manuel olarak
        12. satirda (system.setProperty ile) o driver'lari tanimlamaliyiz

        2- 16. satirda(driver objesi olusturma) ChromeDriver() constructor'ini kullanarak bir obje oilusturduk
        bu objeyi kullanmasak bile bu satirdan dolayi
        bos bir browser acilir

        3-driver.get(url) driver'i yazdigimiz url'e goturur.
        url yazarken www yazmaysak calisir ama https:// yazmazsak method calismaz
         */
         // adres satirina www yazmazsak calisir ama bastaki https yazmayip, www ile baslarsak calismaz


    }
}
