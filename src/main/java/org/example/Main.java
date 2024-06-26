package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException
    {
        String host = "localhost";
        String port = "3306";
        Connection connection = DriverManager.getConnection("jdbc:mysql://" +host+":"+port+"/qatestdb","root","admin");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from employees where empName = 'Arun'");
        while (rs.next())
        {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("https://login.salesforce.com");
            driver.findElement(By.id("username")).sendKeys(rs.getString("empName"));
            driver.findElement(By.id("password")).sendKeys(rs.getString("location"));


        }



    }
}