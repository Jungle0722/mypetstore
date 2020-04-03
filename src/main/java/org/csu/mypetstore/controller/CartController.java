package org.csu.mypetstore.controller;

import org.csu.mypetstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/viewCart")
    public String viewCart() {
        // 检测是否有Account登录，如果已登录，就显示此Account的Cart，否则显示一个空的Cart
        if (false) {
            return null;
        } else {
            return "cart/cart";
        }

    }
}
