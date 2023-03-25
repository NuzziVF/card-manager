package com.example.card.cardmanager.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminHome() {
        return "homepage";
    }
    @GetMapping("/admin/cards")
    public String adminCards() {
        return "viewCards";
    }
    @GetMapping("/admin/cards/add")
    public String addCards() {
        return "addCards";
    }

    @GetMapping("/oneCard")
    public String oneCard() { return "oneCard";}

    @GetMapping("/addPage")
    public String addPage() { return "addPage";}

    @GetMapping("/viewPage")
    public String viewPage() { return "viewPage";}

    @GetMapping("/addPlayer")
    public String addPlayer() { return "addPlayer";}

    @GetMapping("viewPlayer")
    public String viewPlayer() {return "viewPlayer";}
}
