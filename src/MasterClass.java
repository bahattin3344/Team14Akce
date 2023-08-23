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

        MyFunc.wait(2); // 2 saniye bekletme komutu
        //Hesap aç tıklama
        WebElement btnYeniHesap = driver.findElement(By.xpath("//a[@href='/akakcem/giris/?m=1&s=1']"));// Hesap aç Elementi bulma
        aksiyonlar.moveToElement(btnYeniHesap).click().build().perform(); //Hesap aç üzerine git, tıklat ve tamamla

        MyFunc.wait(2);
        //Kullanıcı adı
        WebElement firstname = driver.findElement(By.xpath("//input[@id='rnufn']"));//Kullanıcı adı Elementi bulma
        firstname.sendKeys("Büşra");//ad gönderme

        MyFunc.wait(2);
        //Kullanıcı soyadı
        WebElement lastname = driver.findElement(By.xpath("//input[@id='rnufs']"));//Kullanıcı soyadı Elementi bulma
        lastname.sendKeys("Öz");// soyad gönderme

        MyFunc.wait(2);
        //Email
        WebElement Email = driver.findElement(By.xpath("//input[@id='rnufe1']"));//e mail Elementi bulma
        Email.sendKeys("busranur@gmail.com");//mail gönderme


        MyFunc.wait(2);
        //Email tekrar
        WebElement Email2 = driver.findElement(By.xpath("//input[@id='rnufe2']"));//e mail tekrar Elementi bulma
        Email2.sendKeys("busranur@gmail.com"); //mail tekrar gönderme


        MyFunc.wait(2);
        //Şifre
        WebElement password = driver.findElement(By.xpath("//input[@id='rnufp1']"));//şifre Elementi bulma
        password.sendKeys("Techno123.");//şifreyi gönderme


        MyFunc.wait(2);
        //Şifre tekrar
        WebElement password2 = driver.findElement(By.xpath("//input[@id='rnufp2']"));//şifre tekrar Elementi bulma
        password2.sendKeys("Techno123."); //şifreyi tekrar gönderme


        MyFunc.wait(2);
        //Cinsiyet Kadın
        WebElement cinsiyetK = driver.findElement(By.xpath("//input[@id='rngf']"));// Kadın Elementi bulma
        cinsiyetK.click(); // radio buttonuna tıklatma
        System.out.println(cinsiyetK.isSelected());

        MyFunc.wait(2);
        //il
        WebElement il = driver.findElement(By.xpath("//select[@id='locpr']")); // İl Elementi bulma
        Select secim = new Select(il);//Select nesnesine çevirme
        secim.selectByVisibleText("Ankara"); //Select olarak gönderme

        MyFunc.wait(2);
        //ilçe
        WebElement ilce = driver.findElement(By.xpath("//select[@id='locds']"));//İlçe Elementi bulma
        ilce.sendKeys("Çubuk");// İlçeyi gönderme


        MyFunc.wait(2);
        //D. günü
        WebElement bdGun = driver.findElement(By.xpath("//select[@id='bd']"));//D. günü Elementi bulma
        Select day = new Select(bdGun);//Select nesnesine çevirme
        day.selectByValue("21");//value değerinde seçme

        MyFunc.wait(2);
        //D. ay
        WebElement bdAy = driver.findElement(By.xpath("//select[@id='bm']"));//D.ayı Elementi bulma
        Select month = new Select(bdAy); //Select nesnesine çevirme
        month.selectByValue("3"); //value değerinde seçme

        MyFunc.wait(2);
        //D. yıl
        WebElement bdYil = driver.findElement(By.xpath("//select[@id='by']"));//D. yılı Elementi bulma
        Select year = new Select(bdYil);//Select nesnesine çevirme
        year.selectByValue("1994");//value değerinde seçme

        MyFunc.wait(2);
        //Checkbox onay
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='rnufpca']")); // Kabul et Elementi bulma
        aksiyonlar.moveToElement(checkbox).click().build().perform();//Checkbox üzerine gitme, seçme ve tamamlama

        MyFunc.wait(2);
        // Checkbox 2 onay
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='rnufnee']")); // Kabul et Elementi bulma
        aksiyonlar.moveToElement(checkbox2).click().build().perform();//Checkbox üzerine gitme, seçme ve tamamlama

        MyFunc.wait(2);
        //Hesap Aç onaylama
        WebElement btnHesapAc = driver.findElement(By.xpath("//input[@id='rfb']")); // Hesap Aç Elementi bulma
        aksiyonlar.moveToElement(btnHesapAc).click().build().perform(); //Hesap oluştur butonuna gitme,tıklama ve tamamlama
        //MyFunc.wait(2);

        //Hesap duğrulama
        WebElement HesapDogrula = driver.findElement(By.xpath("//*[text()='Büşra']"));//Hesap adı Elementi bulma
        Assert.assertTrue("Hesap Oluşturma Başarısız",HesapDogrula.getText().contains("Büşra"));
        MyFunc.wait(2);


























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

        driver.navigate().back(); // Navigate element ile geri dönüş sağladık
      //  WebElement profil2 = driver.findElement(By.xpath("//a[@title='Hesabım']"));
      //  Action action5 = aksiyonlar.moveToElement(profil2).build(); // profil sekmesine gelip bekliyoruz HOVER
      //  MyFunc.wait(2);
      //  action5.perform();

      //  WebElement hesabim2 = driver.findElement(By.xpath("//a[text()='Hesabım']"));
      //  Action action6 = aksiyonlar.moveToElement(hesabim2).click().build(); // Profil sekmesinin altındaki hesabıma tıkladı
      //  MyFunc.wait(2);
      //  action6.perform();

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
        sifreDogrulama.sendKeys("Techno123.");  // Şifre Doğrulama
        WebElement hesapSilBtn=driver.findElement(By.cssSelector("[value='Hesabımı sil']"));
        hesapSilBtn.click();   // Hesap Sil Butonuna Basma
        MyFunction.wait(3);
        WebElement hesapSilindiDogrulama=driver.findElement(By.xpath("//*[text()='Hesabın Silindi']"));
        Assert.assertTrue("Hesap Silme Başarısız.",hesapSilindiDogrulama.getText().contains("Hesabın Silindi"));
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
