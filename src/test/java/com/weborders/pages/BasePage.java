package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver=Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,15);

    @FindBy(linkText = "View all orders")
    private WebElement ViewAllOrders;

    @FindBy(linkText = "View all products")
    private WebElement ViewAllProducts;

    @FindBy(linkText = "Order")
    private WebElement Order;

    public BasePage()
    {
        PageFactory.initElements(driver,this);
    }


    public void navigation(String moduleName)
    {
        switch (moduleName)
        {
            case "View all orders":
                wait.until(ExpectedConditions.elementToBeClickable(ViewAllOrders));
                ViewAllOrders.click();
                break;
            case "View all products":
                wait.until(ExpectedConditions.elementToBeClickable(ViewAllProducts));
                ViewAllProducts.click();
                break;
            case "Order":
                wait.until(ExpectedConditions.elementToBeClickable(Order));
                Order.click();
                break;
            default:
                System.out.println("Please Enter valid Menu!!!");
        }
    }
}
