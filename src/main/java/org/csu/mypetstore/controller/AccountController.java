package org.csu.mypetstore.controller;

import com.sun.net.httpserver.HttpContext;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/account")
@SessionAttributes({"account", "authenticated" ,"username"})
public class AccountController {
    // 因为用户登录之后登录的状态要一直保持到会话结束，所以需要将account相关信息放到sessionScope内

    @Autowired
    private AccountService accountService;

    @GetMapping("/viewSignOnForm")
    public String viewSignOnForm(Model model){
        return "account/signOnForm";
    }

    @PostMapping("/viewSignOn")
    public String viewSignOn(String username, String password, Model model) {
        Account account = accountService.getAccount(username, password);
            model.addAttribute("account", account);
            model.addAttribute("username", username);
            model.addAttribute("authenticated", true);
            return "catalog/main";
    }

    @GetMapping("/viewSignOff")
    public String viewSignOff(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("authenticated", false);
        return "catalog/main";
    }

    @GetMapping("/viewNewAccountForm")
    public String viewNewAccountForm(Model model) {

        // 此处添加newAccount 对象的这个方法非常好，可以防止对用户是否登录的检测
        model.addAttribute("newAccount", new Account());
        return "account/newAccountForm";
    }

    // 因未找到一个较好的方法来提取页面上用户输入的值，因此此处仍然采用源文件的思路进行处理
    @PostMapping("/saveNewAccount")
    public String saveNewAccount(Model model, HttpServletRequest request) {
        Account account = new Account();
        account.setPassword(request.getParameter("password"));
        account.setUsername(request.getParameter("username"));

        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));

        account.setPhone(request.getParameter("phone"));
        account.setEmail(request.getParameter("email"));

        account.setCountry(request.getParameter("country"));
        account.setState(request.getParameter("state"));
        account.setZip(request.getParameter("zip"));
        account.setCity(request.getParameter("city"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setLanguagePreference(request.getParameter("languagePreference"));
        account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
        accountService.insertAccount(account);
        accountService.insertSignOn(account);
        accountService.insertProfile(account);

        account = accountService.getAccount(account.getUsername(), account.getPassword());
        model.addAttribute("account", account);
        model.addAttribute("authenticated", true);


        return "catalog/main";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(Model model, HttpServletRequest request) {
        System.out.println(request.getParameter("username"));
        Account account = accountService.getAccount(request.getParameter("username"));



        if (request.getParameter("password").equals(request.getParameter("repeatPassword"))) {
            account.setPassword(request.getParameter("password"));
            accountService.updateSignOn(account);
        }

        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));

        account.setPhone(request.getParameter("phone"));
        account.setEmail(request.getParameter("email"));

        account.setCountry(request.getParameter("country"));
        account.setState(request.getParameter("state"));
        account.setZip(request.getParameter("zip"));
        account.setCity(request.getParameter("city"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setLanguagePreference(request.getParameter("languagePreference"));
        account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
        accountService.updateAccount(account);

        accountService.updateProfile(account);

        model.addAttribute("account", account);

        return "catalog/main";
    }


    @GetMapping("/viewEditAccount")
    public String viewEditAccount(String username, Model model) {
        Account account = accountService.getAccount(username);
        model.addAttribute("account", account);
        return "account/editAccount";
    }

}
