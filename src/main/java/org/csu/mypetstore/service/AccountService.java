package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account = accountMapper.getAccountByUsernameAndPassword(account);
        return account;
    }

    public Account getAccount(String username) {
        Account account = accountMapper.getAccountByUsername(username);
        return account;
    }

    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    public void insertSignOn(Account account) {
        accountMapper.insertSignon(account);
    }

    public void insertProfile(Account account) {
        accountMapper.insertProfile(account);
    }

    public void updateAccount(Account account) {accountMapper.updateAccount(account);}
    public void updateSignOn(Account account) {accountMapper.updateSignon(account);}
    public void updateProfile(Account account) {accountMapper.updateProfile(account);}
}
