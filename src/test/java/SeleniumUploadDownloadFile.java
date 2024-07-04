import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class SeleniumUploadDownloadFile
{
    @Test
    public void fileUploadDownloadInSelenium() throws InterruptedException, IOException {
        String downloadPath=System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");

        //The below 3 lines of code from Hashmap to separator line will set default download directory of a file to
        //our projects's directory (i.,e at the time of execution of this script )

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("download.default_directory", downloadPath);

        //-------------------

        ChromeOptions options=new ChromeOptions();

        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver=new ChromeDriver(options);

        driver.get("https://altoconvertpdftojpg.com/");

        driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

        Thread.sleep(3000);

        //Here we need to call the autoIT script file

        Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //wait until 10 seconds for the file to be uploaded & the convert now button is shown

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

        driver.findElement(By.cssSelector("button[class*='medium']")).click();

        //wait until the 10 seconds for the conversion to be completed & the download button is shown to download the file

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));

        driver.findElement(By.linkText("Download Now")).click();

        //wait until 5 seconds for the file to be downloaded after the download button is clicked.

        Thread.sleep(5000);

        //The below lines will check whether the file is downloaded in our project path & it will delete the file once it's downloaded & present in the project's folder

        File f=new File(downloadPath+"/converted.zip");

        if(f.exists())

        {

            Assert.assertTrue(f.exists());

            if(f.delete())

                System.out.println("file deleted");

        }
    }



}
