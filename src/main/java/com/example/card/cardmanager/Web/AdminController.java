package com.example.card.cardmanager.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
    @GetMapping("/admin/cards")
    public String adminCards() {
        return "adminCards";
    }
    @GetMapping("/admin/cards/add")
    public String addCards() {
        return "addCards";
    }
}
