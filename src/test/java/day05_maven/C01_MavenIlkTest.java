package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        // 2-arama kutusunu locate edelim
        WebElement aramaKutusu =driver.findElement(By.id("twotabsearchtextbox")) ;

        // 3-"Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        // 4-Bulunan sonuc sayisini yazdiralim

        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYaziElementi.getText());
        // 5-Ilk urunu tiklayalim
           // linki ve resmi tiklamak farkli, secmemiz gerek, linki tikladik
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        // ilk element icin diger bir locate ise (//h2)[1]

        // 6-Sayfadaki tum basliklari yazdiralim
            // 5. komutta urun linkine tikladigimiz icin o sayfadan ayrildik ve de basliklar kayboldu
            // once 1 sayfa geri gidecegiz

        driver.navigate().back();
        List<WebElement> basliklarWebElementListesi= driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));


        for (WebElement each: basliklarWebElementListesi
             ) {
            System.out.println(each.getText());
        }


        driver.close();



    }
}
