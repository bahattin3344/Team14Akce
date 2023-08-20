import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MasterClass {
    @Test
    public void Master(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // açılan ekranı tam ekran açmayı sağlıyor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 30 saniyede chrome da sayfa açılmazsa kapat
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 30 saniye elementi bulma süresi verdik
        driver.get("https://www.akakce.com");


        WebElement hesabım = driver.findElement(By.cssSelector("[id='HM_v8']>i>[rel='nofollow']"));
        hesabım.click();  // Hesabım Elementine Click
        MyFunction.wait(2);
        WebElement hesapSil=driver.findElement(By.cssSelector("[class='user']> :nth-child(5)"));
        hesapSil.click();  // Hesap Silme Elementine Click
        MyFunction.wait(2);
        WebElement sifreDogrulama=driver.findElement(By.cssSelector("[type='password']"));
        sifreDogrulama.sendKeys("Deniz3344");  // Şifre Doğrulama
        WebElement hesapSilBtn=driver.findElement(By.cssSelector("[value='Hesabımı sil']"));
        hesapSilBtn.click();   // Hesap Sil Butonuna Basma
        MyFunction.wait(3);
        driver.quit();

    }

    public class MyFunction {
        public static void wait(int sn) {
            try {
                Thread.sleep(sn*1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
}}
