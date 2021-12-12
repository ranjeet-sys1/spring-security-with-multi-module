package com.app.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/notice")
    public String getNotice(){
        return "Hi I have new Notice from DB";
    }
    @GetMapping("/account")
    public String myAccount(){
        return "my account from DB";
    }
    @GetMapping("/cards")
    public String myCards(){
        return "my cards from DB";
    }
    @GetMapping("/loan")
    public String myLoan(){
        return "Loan from DB";
    }
    @GetMapping("/bank")
    public String bankInfo(){
        return "Here is details of Bank from DB";
    }
}
