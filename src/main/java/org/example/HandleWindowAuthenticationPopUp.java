package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HandleWindowAuthenticationPopUp
{
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.get("http://admin:admin@the-internet.herokuapp.com/");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.linkText("Basic Auth")).click();

        //Here are the steps to upload the file from our local system using Auto IT
        //Automating window Controls with Selenium:
        //
        //
        //
        //· Handling Window Authentication Pop Up
        //
        //
        //· Driver.get(http://Username:Password@SiteURL); while calling the URL, we need to specify the credentials along with the URL
        //
        //· Handling File Upload from Windows using AutoIT
        //
        //
        //What is AutoIT
        //Install AutoIT
        //AutoIT Scripting
        //Integrating AutoIT with Selenium
        //
        //
        //
        ////Shift focus to the file upload windows
        //
        ////set text/path into file name edit box
        //
        ////click open to upload file
        //
        //
        //
        //Au3info- record window component objects
        //
        //Build Script -scite.exe
        //
        //Save it- .au3 extension
        //
        //Convert file into .exe by compiling .au3 file
        //
        //Call .exe file with Runtime class in java into your selenium tests
        //
        //
        //
        //
        // Here's the script which we need to add it in the scite editor that will be located in "C:\Program Files (x86)\AutoIt3\SciTE"
        //ControlFocus("Open","","Edit1")
        //
        //ControlSetText("Open","","Edit1","Path of the file to be uploaded")
        //
        //ControlClick("Open","","Button1")

        driver.get("https://altoconvertpdftojpg.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id='browse']")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("Path to call the compiled .exe autoIT script file., when it's called after download button" +
                "script in selenium, it will select the file [i.,e pasting the path of the filename in the pop-up filename input] & then" +
                "it'll click the upload button");
    }
}
