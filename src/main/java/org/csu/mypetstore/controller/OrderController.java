package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;


@Controller
@RequestMapping("/order")
@SessionAttributes({"order", "shippingAddressRequired", "confirmed"})
public class OrderController {

    @Autowired
    private Cart cart;
    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderService orderService;


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

    @GetMapping("/newOrder")
    public String newOrder(int orderId, Model model) {

        model.addAttribute("order", orderService.getOrder(orderId));


        return "order/viewOrders";
    }

    @GetMapping("/viewOrder")
    public String viewOrder(Order order) {
        orderService.insertOrder(order);
        return "order/viewOrder";
    }

    @GetMapping("/orderManage")
    public String orderManage(Model model) {
        model.addAttribute("orderList", orderService.getOrdersByUsername("j2ee"));
        return "back/orderManage";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("orderList", orderService.getOrdersByUsername("j2ee"));
        return "order/listOrders";
    }

    @GetMapping("/editOrder")
    public String editOrder(int orderId, Model model) {
        model.addAttribute("order", orderService.getOrder(orderId));
        return "back/editOrder";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(int orderId, Model model) {
        orderService.deleteOrder(orderId);
        model.addAttribute("orderList", orderService.getOrdersByUsername("j2ee"));
        return "back/orderManage";
    }

    @PostMapping("/searchOrder")
    public String searchOrder(int orderId, Model model) {
        model.addAttribute("orderList", orderService.getOrder(orderId));
        return "back/orderManage";
    }

    @GetMapping("/search")
    public String search() {
        return "back/searchOrder";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(int orderId, Model model, HttpServletRequest request) {
        Order order = orderService.getOrder(orderId);
        order.setShipAddress1(request.getParameter("shipAddress1"));
        order.setShipAddress2(request.getParameter("shipAddress2"));
        order.setShipCity(request.getParameter("shipCity"));
        order.setShipState(request.getParameter("shipState"));
        order.setShipZip(request.getParameter("shipZip"));
        order.setShipCountry(request.getParameter("shipCountry"));
        order.setBillAddress1(request.getParameter("billAddress1"));
        order.setBillAddress2(request.getParameter("billAddress2"));
        order.setBillCity(request.getParameter("billCity"));
        order.setBillState(request.getParameter("billState"));
        order.setBillZip(request.getParameter("billZip"));
        order.setBillCountry(request.getParameter("billCountry"));
        order.setCourier(request.getParameter("courier"));
        order.setBillToFirstName(request.getParameter("billToFirstName"));
        order.setBillToLastName(request.getParameter("billToLastName"));
        order.setShipToFirstName(request.getParameter("shipToFirstName"));
        order.setShipToLastName(request.getParameter("shipToLastName"));
        order.setCreditCard(request.getParameter("creditCard"));
        order.setExpiryDate(request.getParameter("expiryDate"));
        order.setCardType(request.getParameter("cardType"));
        order.setStatus(request.getParameter("status"));

        orderService.updateOrder(order);

        model.addAttribute("orderList", orderService.getOrdersByUsername("j2ee"));
        return "back/orderManage";
    }
}
