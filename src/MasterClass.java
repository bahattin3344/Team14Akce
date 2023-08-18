import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MasterClass {
    @Test
    public void Master(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize(); // açılan ekranı tam ekran açmayı sağlıyor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 30 saniyede chrome da sayfa açılmazsa kapat
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 30 saniye elementi bulma süresi verdik
        driver.get("https://www.akakce.com");

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
}
}
