package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/account")
@SessionAttributes({"account", "exit"})
public class AccountController {
    // 因为用户登录之后登录的状态要一直保持到会话结束，所以需要将account相关信息放到sessionScope内

    @Autowired
    private AccountService accountService;

    @GetMapping("/viewSignOnForm")
    public String viewSignOnForm(){
        return "account/signOnForm";
    }

    @PostMapping("/viewSignOn")
    public String viewSignOn(String username, String password, Model model) {
        Account account = accountService.getAccount(username, password);
        model.addAttribute("account", account);
        model.addAttribute("exit", true);
        return "catalog/main";
    }

    @GetMapping("/viewSignOff")
    public String viewSignOff(Model model) {
        model.addAttribute("account", null);
        model.addAttribute("exit", false);
        return "catalog/main";
    }
}
