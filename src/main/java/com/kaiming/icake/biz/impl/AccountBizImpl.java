package com.kaiming.icake.biz.impl;

import com.kaiming.icake.biz.AccountBiz;
import com.kaiming.icake.dao.AccountDao;
import com.kaiming.icake.entity.Account;
import com.kaiming.icake.global.DaoFactory;

import java.util.List;

public class AccountBizImpl implements AccountBiz {
    /* 获取对应dao的实例对象*/
    private AccountDao accountDao = DaoFactory.getInstance().getDao(AccountDao.class);
    /*登录验证*/
    public Account login(String name, String password) {
        List<Account> list = accountDao.selectByName(name);
        for(Account account:list) {
            if (account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
}
