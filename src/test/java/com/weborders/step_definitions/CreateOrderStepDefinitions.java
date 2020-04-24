package com.weborders.step_definitions;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.utilities.Wait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CreateOrderStepDefinitions {

    OrderPage orderPage=new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();


    @Then("user navigates to {string} page")
    public void user_navigates_to_page(String string) {
       orderPage.navigation(string);

    }

    @When("user enters following product information:")
    public void user_enters_following_product_information(List<Map<String,String>> dataTable) {
        orderPage.SelectProduct(dataTable.get(0).get("Product"));
        orderPage.SetQuanity(dataTable.get(0).get("Quantity"));
        orderPage.setPricePerUnit(dataTable.get(0).get("Price per unit"));
        orderPage.setDiscount(dataTable.get(0).get("Discount"));
    }

    @When("user click on calculate button")
    public void user_click_on_calculate_button() {
        orderPage.clickCalculate();
    }

    @Then("user should verify that total is {int} is displayed")
    public void user_should_verify_that_total_is_is_displayed(Integer total) {
        Assert.assertEquals(total,orderPage.getTotal());
    }

    @When("user enters address information as following :")
    public void user_enters_address_information_as_following(List<Map<String,String>> dataTable) {
        orderPage.setCustomerName(dataTable.get(0).get("Customer name"));
        orderPage.setStreet(dataTable.get(0).get("Street"));
        orderPage.setCity(dataTable.get(0).get("City"));
        orderPage.setState(dataTable.get(0).get("State"));
        orderPage.setZip(dataTable.get(0).get("Zip"));

    }

    @When("user enters payment information as following :")
    public void user_enters_payment_information_as_following(List<Map<String,String>> dataTable) {
        orderPage.setCard(dataTable.get(0).get("Card"));
        orderPage.setCardNr(dataTable.get(0).get("Card Nr"));
        orderPage.setExpireDate(dataTable.get(0).get("Expire date (mm/yy)"));
    }

    @When("user clicks on process button")
    public void user_clicks_on_process_button() {
    orderPage.clickProcess();
    }

    @Then("user verifies that order is placed with following data :")
    public void user_verifies_that_order_is_placed_with_following_data(List<Map<String,String>> dataTable) {
        Assert.assertTrue(viewAllOrdersPage.CheckName(dataTable.get(0).get("Name")));
        Assert.assertTrue(viewAllOrdersPage.CheckProduct(dataTable.get(0).get("Product")));
        Assert.assertTrue(viewAllOrdersPage.CheckQuantity(dataTable.get(0).get("Quantity")));
        Assert.assertTrue(viewAllOrdersPage.CheckDate(dataTable.get(0).get("Date")));
        Assert.assertTrue(viewAllOrdersPage.CheckStreet(dataTable.get(0).get("Street")));
        Assert.assertTrue(viewAllOrdersPage.CheckCity(dataTable.get(0).get("City")));
        Assert.assertTrue(viewAllOrdersPage.CheckState(dataTable.get(0).get("State")));
        Assert.assertTrue(viewAllOrdersPage.CheckZip(dataTable.get(0).get("Zip")));
        Assert.assertTrue(viewAllOrdersPage.CheckCard(dataTable.get(0).get("Card")));
        Assert.assertTrue(viewAllOrdersPage.CheckCardNumber(dataTable.get(0).get("Card Number")));
        Assert.assertTrue(viewAllOrdersPage.CheckExp(dataTable.get(0).get("Exp")));

    }

}
