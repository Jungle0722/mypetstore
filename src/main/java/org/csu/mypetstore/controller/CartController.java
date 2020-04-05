package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {



    @Autowired
    private Cart cart;

    private int numberOfItems;

    @GetMapping("/viewCart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("cart.numberOfItems", cart.getNumberOfItems());
        model.addAttribute("cart.cartItems", cart.getCartItems());

        return "cart/cart";
    }
}
