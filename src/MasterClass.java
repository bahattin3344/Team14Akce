import Bilgehan.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MasterClass {
    @Test
    public void Master(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // açılan ekranı tam ekran açmayı sağlıyor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 30 saniyede chrome da sayfa açılmazsa kapat
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 30 saniye elementi bulma süresi verdik
        driver.get("https://www.akakce.com");
        Actions aksiyonlar = new Actions(driver);




















        WebElement profil = driver.findElement(By.xpath("//a[@title='Hesabım']"));
        Action action2 = aksiyonlar.moveToElement(profil).build(); // profil sekmesine gelip bekliyoruz HOVER
        MyFunc.wait(2);
        action2.perform();

        WebElement hesabim = driver.findElement(By.xpath("//a[text()='Hesabım']"));
        Action action3 = aksiyonlar.moveToElement(hesabim).click().build(); // Profil sekmesinin altındaki hesabıma tıkladı
        MyFunc.wait(2);
        action3.perform();

        WebElement siparislerim = driver.findElement(By.xpath("//li[@class='order first']//a[text()='Siparişlerim']"));
        Action action4 = aksiyonlar.moveToElement(siparislerim).click().build(); // siparişlerime gelip tıkladı
        MyFunc.wait(2);
        action4.perform();

        WebElement siparislerKontrolu = driver.findElement(By.xpath("//div[@class='no-record']"));
        MyFunc.wait(2); // Siparişiniz bulunmuyor mesajı kontrol edildi. Hata varsa verilecek mesaj girildi.
        Assert.assertTrue("Siparişler eşleşmedi...", siparislerKontrolu.getText().equals("Kayıtlı siparişiniz bulunmuyor."));
        MyFunc.wait(2);

        WebElement profil2 = driver.findElement(By.xpath("//a[@title='Hesabım']"));
        Action action5 = aksiyonlar.moveToElement(profil2).build(); // profil sekmesine gelip bekliyoruz HOVER
        MyFunc.wait(2);
        action5.perform();

        WebElement hesabim2 = driver.findElement(By.xpath("//a[text()='Hesabım']"));
        Action action6 = aksiyonlar.moveToElement(hesabim2).click().build(); // Profil sekmesinin altındaki hesabıma tıkladı
        MyFunc.wait(2);
        action6.perform();

        WebElement mesajlarim = driver.findElement(By.xpath("//li[@class='order first']//a[text()='Mesajlarım']"));
        Action action7 = aksiyonlar.moveToElement(mesajlarim).click().build(); // mesajlarıma gelip tıkladı
        MyFunc.wait(2);
        action7.perform();

        WebElement mesajKontrolu = driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));
        MyFunc.wait(2); // Mesaj kutusu kontrol edildi, hata varsa girilecek mesaj girildi.
        Assert.assertTrue("Mesaj kontrolü eşleşmedi...", mesajKontrolu.getText().equals("Listelenecek mesaj bulunamadı."));
        MyFunc.wait(2);

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
