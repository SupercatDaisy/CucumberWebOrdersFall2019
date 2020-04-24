package com.weborders.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewAllOrdersPage extends BasePage {

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]")
    private List<WebElement> ListOfName;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[3]")
    private List<WebElement> ListOfProduct;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[4]")
    private List<WebElement> ListOfQuantity;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[5]")
    private List<WebElement> ListOfDate;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[6]")
    private List<WebElement> ListOfStreet;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]")
    private List<WebElement> ListOfCity;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[8]")
    private List<WebElement> ListOfState;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[9]")
    private List<WebElement> ListOfZip;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[10]")
    private List<WebElement> ListOfCard;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[11]")
    private List<WebElement> ListOfCardNumber;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[12]")
    private List<WebElement> ListOfExp;

    public boolean CheckName(String name) {
        for (WebElement element : ListOfName) {
            if (element.getText().equals(name)) {
                return true; } }return false; }
    public boolean CheckProduct(String product) {
        for (WebElement element : ListOfProduct) {
            if (element.getText().equals(product)) {
                return true; } }return false; }
    public boolean CheckQuantity(String quantity) {
        for (WebElement element : ListOfQuantity) {
            if (element.getText().equals(quantity)) {
                return true; } }return false; }
    public boolean CheckDate(String date) {
        for (WebElement element : ListOfDate) {
            if (element.getText().equals(date)) {
                return true; } }return false; }
    public boolean CheckStreet(String street) {
        for (WebElement element : ListOfStreet) {
            if (element.getText().equals(street)) {
                return true; } }return false; }
    public boolean CheckCity(String city) {
        for (WebElement element : ListOfCity) {
            if (element.getText().equals(city)) {
                return true; } }return false; }
    public boolean CheckState(String state) {
        for (WebElement element : ListOfState) {
            if (element.getText().equals(state)) {
                return true; } }return false; }
    public boolean CheckZip(String zip) {
        for (WebElement element : ListOfZip) {
            if (element.getText().equals(zip)) {
                return true; } }return false; }
    public boolean CheckCard(String card) {
        for (WebElement element : ListOfCard) {
            if (element.getText().equals(card)) {
                return true; } }return false; }
    public boolean CheckCardNumber(String cardNr) {
        for (WebElement element : ListOfCardNumber) {
            if (element.getText().equals(cardNr)) {
                return true; } }return false; }
    public boolean CheckExp(String exp) {
        for (WebElement element : ListOfExp) {
            if (element.getText().equals(exp)) {
                return true; } }return false; }





}
