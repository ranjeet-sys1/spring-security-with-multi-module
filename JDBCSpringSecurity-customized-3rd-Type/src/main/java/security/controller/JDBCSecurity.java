package security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBCSecurity {
    @GetMapping("/love")
    public String getMyLove(){
        return "take my ^^) :) ";
    }
    @GetMapping("/wife")
    public String beMyWife(){
        return "Always with you :) lot of oooooooo loveeee";
    }
    @GetMapping("/affair")
    public String getAffair(){
        return "I wanna affair with you my love";
    }
    @GetMapping("/rich")
    public String getRich(){
        return "I wanna be billionaire";
    }

}
