package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "ctl00_MainContent_username")
    private WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    private WebElement loginBtn;

    public void login (String username,String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);

    }

    public void login()
    {
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

    }

    public void clickLogin()
    {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }
}
