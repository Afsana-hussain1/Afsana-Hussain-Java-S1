package com.company.retailapi.controller;


import com.company.retailapi.messages.LevelUpMessage;
import com.company.retailapi.model.LevelUp;
import com.company.retailapi.model.Product;
import com.company.retailapi.service.ServiceLayer;
import com.company.retailapi.viewModel.InvoiceVM;
import com.company.retailapi.viewModel.LevelUpViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
@RestController
public class GameStoreController {

    public static final String EXCHANGE = "queue-demo-exchange";
    public static final String ROUTING_KEY = "email.list.add.account.controller";
    @Autowired RabbitTemplate rabbitTemplate;

    public GameStoreController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    ServiceLayer serviceLayer;
    // Retail Endpoints

    //attempted queue
//    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
//    public LevelUpViewModel submitInvoice(@RequestBody LevelUp levelUp) {
//        // create message to send to email list creation queue
//        LevelUpMessage msg = new LevelUpMessage(levelUp.getLevelupId() + " " + levelUp.getCustomerId(), levelUp.getPoint(), levelUp.getMemberDate());
//        System.out.println("Sending message...");
//        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
//        System.out.println("Message Sent");
//
//        // Now do account creation stuff...
//
//        return "level up created";
//    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    public InvoiceVM getInvoiceById(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<InvoiceVM> getAllInvoices() {
        return null;
    }

    @RequestMapping(value = "/invoices/customer/{id}", method = RequestMethod.GET)
    public List<InvoiceVM> getInvoicesByCustomerId(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value = "/products/inventory", method = RequestMethod.GET)
    public List<Product> getProductsInInventory() {
        return null;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value = "/products/invoice/{id}", method = RequestMethod.GET)
    public List<Product> getProductByInvoiceId(@PathVariable int id) {
        return null;
    }

    //must have a circuit breaker
    @RequestMapping(value = "/levelup/customer/{id}", method = RequestMethod.GET)
    public int getLevelUpPointsByCustomerId(int id) {
        return 0;
    }



    // getProductById is above in the Retail endpoints

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return null;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {

    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int id) {

    }

}
