package com.example.vending.controller;

import com.example.vending.model.Item;
import com.example.vending.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vending")
public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    @Autowired
    public VendingMachineController(VendingMachineService vendingMachineService){
        this.vendingMachineService = vendingMachineService;
    }

    @PostMapping("add-item")
    public String addItem(@RequestBody Item item){
        vendingMachineService.addItem(item);
        return "Item added successfully";
    }

    @PostMapping("/select/itemCode")
    public String selectItem(@PathVariable String itemCode){
        return vendingMachineService.selectItem(itemCode);
    }

    @PostMapping("/pay")
    public String insertPayment(@RequestParam float amount, @RequestParam String paymentType){
        return vendingMachineService.insertPayment(amount, paymentType);
    }

    @PostMapping("/complete")
    public String completeTransaction(@RequestParam String itemCode){
        return vendingMachineService.completeTransaction(itemCode);
    }

    @PostMapping("/cancel")
    public String cancelTransaction(){
        return vendingMachineService.cancelTransation();
    }
}
