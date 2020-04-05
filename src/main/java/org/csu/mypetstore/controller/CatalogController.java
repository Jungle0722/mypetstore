package org.csu.mypetstore.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/view")
    public String view(Model model) {
        // 每个用户刚进入页面时未登录，故account为空
        model.addAttribute("account", null);
        return "catalog/main";
    }

    @GetMapping("/viewCategory")
    public String viewCategory(String categoryId, Model model) {
        if (categoryId != null) {
            Category category = catalogService.getCategory(categoryId);
            List<Product> productList = catalogService.getProductListByCategory(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("productList", productList);
            return "catalog/category";
        }
        return "catalog/main";
    }

    @GetMapping("/viewProduct")
    public String viewProduct(String productId, Model model) {
        Product product = catalogService.getProduct(productId);
        List<Item> itemList = itemService.getItemListByProduct(productId);
        model.addAttribute("product", product);
        model.addAttribute("itemList", itemList);
        return "catalog/product";
    }

    @GetMapping("/viewItem")
    public String viewItem(String itemId, Model model) {
        Item item = itemService.getItem(itemId);
        // model内的数据只能维持在一个页面？
        Product product = item.getProduct();
        model.addAttribute("item", item);
        model.addAttribute("product", product);
        return "catalog/item";
    }

    @PostMapping("searchProduct")
    public String searchProduct(String keywords, Model model) {
        List<Product> productList = catalogService.searchProductByKeywords(keywords);
        model.addAttribute("productList", productList);
        return "catalog/searchProduct";
    }
}
