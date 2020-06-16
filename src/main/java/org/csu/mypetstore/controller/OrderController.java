package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/order")
@SessionAttributes({"order", "shippingAddressRequired", "confirmed"})
public class OrderController {

    @Autowired
    private Cart cart;
    @Autowired
    private AccountService accountService;


    @GetMapping("/accountError")
    public String accountError(Model model) {
        String msg = "You must sign on before attempting to check out.  Please sign on and try checking out again.";
        model.addAttribute("msg", msg);
        return "common/error";
    }

    @GetMapping("/newOrderForm")
    public String newOrderForm(String username, Boolean authenticated, Model model) {

        if (!authenticated) {
            String msg = "You must sign on before attempting to check out.  Please sign on and try checking out again.";
            model.addAttribute("msg", msg);
            return "common/error";
        } else if (cart != null) {
            Order order = new Order();
            Account account = accountService.getAccount(username);
            order.initOrder(account, cart);
            model.addAttribute("order", order);
            return "order/newOrderForm";
        } else {
            return null;
        }
    }

    @PostMapping("/newOrder")
    public String newOrder() {
        return "order/confirmOrder";
    }

    @GetMapping("/viewOrder")
    public String viewOrder() {
        return "order/viewOrder";
    }
}
