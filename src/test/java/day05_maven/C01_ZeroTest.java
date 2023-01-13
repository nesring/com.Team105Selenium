package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ZeroTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get(" http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
// ??
        //  ?? yanlis degil iki adimda yaptim gerek yok 3. Login alanine  “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");


        // ??   3 ile ayni 4. Password alanine “password” yazdirin
       driver.findElement(By.id("user_password")).sendKeys("password");


        // ?? 5. Sign in buttonuna tiklayin //  //input[@type='submit'] yazdim
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // ?? 6. navigate back yapip ,online banking menusunden Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 7. locate dogru ...amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("200");

        // 8. tarih kismina “2020-09-10” yazdirin locate dogru
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");;

        // 9. Pay buttonuna tiklayin dogru
        driver.findElement(By.id("pay_saved_payees")).click();

        // yanlis10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement succesfullyElementi = driver.findElement(By.id("alert_content"));

        if (succesfullyElementi.isDisplayed()) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.close();

    }

}
