package ru.litecart.stqa;

import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyDuckTest {

    @Test
    public void buyDuck() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/ru/create_account");
        Thread.sleep(1000);

        WebElement firstName = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[2]/td[1]/input");
        firstName.sendKeys("Dud");

        WebElement lastName = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[2]/td[2]/input");
       lastName.sendKeys("Moran");

        WebElement adress = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[3]/td[1]/input");
       adress.sendKeys("Kukushkino 5");

        Thread.sleep(1000);

        WebElement post = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[4]/td[1]/input");
        post.sendKeys("375357");

        WebElement city = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[4]/td[2]/input");
        city.sendKeys("Jitomir");

        MockNeat mock = MockNeat.threadLocal();
        String corpEmail = mock.emails().domain("startup.com").val();

        WebElement mail = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[6]/td[1]/input");
        mail.sendKeys(corpEmail);

        Thread.sleep(1000);

        WebElement phone = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[6]/td[2]/input");
        phone.sendKeys("89056674314");

        WebElement pass = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[8]/td[1]/input");
        pass.sendKeys("qwerty@122");

        WebElement confirm = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[8]/td[2]/input");
       confirm.sendKeys("qwerty@122");

        WebElement create = driver.findElementByXPath("//*[@id='create-account']/div/form/table/tbody/tr[9]/td/button");
        create.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement duck = driver.findElementByXPath("//*[@id='box-most-popular']/div/ul/li[2]/a[1]");
        duck.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement cart = driver.findElementByXPath("//*[@id='box-product']/div[2]/div[2]/div[5]/form/table/tbody/tr/td/button");
        cart.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement checkout = driver.findElementByXPath("//*[@id='cart']/a[3]");
        checkout.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement confirmOrd = driver.findElementByXPath("//*[@id='order_confirmation-wrapper']/form/div[2]/p/button");
        confirmOrd.sendKeys(Keys.ENTER);


    }
}
