package com.weborders.pages;

import com.weborders.utilities.Driver;
import com.weborders.utilities.Wait;
import io.cucumber.java.ca.Cal;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class OrderPage extends BasePage {


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement Quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement PricePerUnit;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement Discount;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement Total;

    @FindBy(css = "input[value='Calculate']")
    private WebElement Calculate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement CustomerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement Street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement City;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement State;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement Zip;

    @FindBy(css = "table[id='ctl00_MainContent_fmwOrder_cardList']>tbody>tr>td")
    private List<WebElement> Card;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement CardNr;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement ExpireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement Process;

    /*===========╨⌂╨===============*/


    public void clickProcess()
    {
        Process.click();
    }

    public void setCustomerName(String name)
    {
        wait.until(ExpectedConditions.visibilityOf(CustomerName));
        CustomerName.sendKeys(name);
    }

    public void setStreet(String street)
    {
        wait.until(ExpectedConditions.visibilityOf(Street));
        Street.sendKeys(street);
    }

    public void setCity(String city){
        wait.until(ExpectedConditions.visibilityOf(City));
        City.sendKeys(city);
    }

    public void setState(String state){
        wait.until(ExpectedConditions.visibilityOf(State));
        State.sendKeys(state);
    }

    public void setZip(String zip){
        wait.until(ExpectedConditions.visibilityOf(Zip));
        Zip.sendKeys(zip);
    }

   public void setCard(String card)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(Card));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("table[id='ctl00_MainContent_fmwOrder_cardList']>tbody>tr>td"),3));
        for (int i = 0; i <Card.size() ; i++) {
            if(Card.get(i).getText().equals(card)){
                Card.get(i).click();
            }
        }
    }

    public void setCardNr(String cardNr)
    {
        wait.until(ExpectedConditions.visibilityOf(CardNr));
        CardNr.sendKeys(cardNr);
    }

    public void setExpireDate(String expireDate)
    {
        wait.until(ExpectedConditions.visibilityOf(ExpireDate));
        ExpireDate.clear();
        ExpireDate.sendKeys(expireDate);
    }


    public void clickCalculate()
    {
        wait.until(ExpectedConditions.elementToBeClickable(Calculate));
        Calculate.click();
    }

    public void SelectProduct(String Pname){
        Select product = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        product.selectByValue(Pname);
    }

    public void SetQuanity(String Qty)
    {
        wait.until(ExpectedConditions.visibilityOf(Quantity));
        Quantity.clear();
        Quantity.sendKeys(Qty);
    }


    public void setPricePerUnit(String PPU)
    {
        wait.until(ExpectedConditions.visibilityOf(PricePerUnit));
        PricePerUnit.sendKeys(PPU);
    }

    public void setDiscount(String Disc)
    {
        wait.until(ExpectedConditions.visibilityOf(Discount));
        Discount.sendKeys(Disc);
    }

    public Integer getTotal(){
        return Integer.parseInt(Total.getAttribute("value"));
    }

}