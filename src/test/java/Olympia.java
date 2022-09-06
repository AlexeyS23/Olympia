import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class Olympia {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.olympia.casino/");
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        driver.manage().window().maximize();

        Thread.sleep(3000);
        WebElement suButton = driver.findElement(By.xpath("(//a[contains(text(),'Sign up')])[1]"));
        suButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // switch to a new Tab. need to update Selenium to 4 version
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tempmail.dev/en");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'@')]")));
        WebElement mail1 = driver.findElement(By.xpath("//div[@id=\"current-mail\"]"));
        String copyEmail = mail1.getText();

        // switch to Original Window
        driver.switchTo().window(originalWindow);
        

        Thread.sleep(3000);

        WebElement mail2 = driver.findElement(By.xpath("//input[@id='email']"));
        mail2.sendKeys(copyEmail);
        WebElement pass = driver.findElement(By.xpath("//input[@id='password_single']"));
        pass.sendKeys("123Abba123");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"currency\"]")).click();
        driver.findElement(By.xpath("//div[@id='currency-item-3']")).click();
        WebElement next = driver.findElement(By.xpath("//button[text()='next']"));
        next.click();

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Alex");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Alex");
        driver.findElement(By.xpath("//input[@name='date_of_birth_day']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='date_of_birth_month']")).sendKeys("08");
        driver.findElement(By.xpath("//input[@name='date_of_birth_year']")).sendKeys("2021");
        driver.findElement(By.xpath("//input[@name='mobile_phone-number']")).sendKeys("091111111");
        driver.findElement(By.xpath("//button[text()='next']")).click();

       // driver.findElement(By.xpath("//input[@id='country']")).sendKeys();
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kyiv");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Kyiv");
        driver.findElement(By.xpath("//input[@id='postal_code']")).sendKeys("03028");

        WebElement cb1 = driver.findElement(By.xpath("//*[@id=\"sign-up\"]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[5]/div[1]/label/span[1]"));
        boolean isSel = cb1.isSelected();
        if (!isSel){
            cb1.click();
        }
        WebElement cb2 = driver.findElement(By.xpath("//*[@id=\"sign-up\"]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[6]/div[1]/label/span[1]"));
        boolean isSelect = cb2.isSelected();
        if (!isSelect){
            cb2.click();
        }
        WebElement cb3 = driver.findElement(By.xpath("//*[@id=\"sign-up\"]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[7]/div[1]/label/span[1]"));
        boolean isSelected = cb3.isSelected();
        if (!isSelected){
            cb3.click();
        }


    }
}
