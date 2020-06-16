package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {



    @Autowired
    private Cart cart;
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/viewCart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("cart.numberOfItems", cart.getNumberOfItems());
        model.addAttribute("cart.cartItems", cart.getCartItems());
        return "cart/cart";
    }

    @PostMapping("/viewUpdateCart")
    public String viewUpdateCart(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("cart.numberOfItems", cart.getNumberOfItems());
        model.addAttribute("cart.cartItems", cart.getCartItems());



        return "cart/cart";
    }

    @GetMapping("/addItemToCart")
    public String addItemToCart(String workingItemId, Model model) {
        if(cart.containsItemId(workingItemId)){
            cart.incrementQuantityByItemId(workingItemId);
        }else{
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item,isInStock);
        }

        model.addAttribute("cart", cart);
        model.addAttribute("cart.numberOfItems", cart.getNumberOfItems());
        model.addAttribute("cart.cartItems", cart.getCartItems());

        return "cart/cart";
    }

    @GetMapping("/removeItemFromCart")
    public String removeItem(String cartItem, Model model) {

        Item item = cart.removeItemById(cartItem);

        model.addAttribute("cart", cart);
        model.addAttribute("cart.numberOfItems", cart.getNumberOfItems());
        model.addAttribute("cart.cartItems", cart.getCartItems());
        return "cart/cart";
    }

}
