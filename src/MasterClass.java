import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MasterClass {
    @Test
    public void Master(){
        WebDriver driver=new ChromeDriver();
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
}}
