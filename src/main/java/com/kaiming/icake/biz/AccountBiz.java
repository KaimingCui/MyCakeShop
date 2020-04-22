package com.kaiming.icake.biz;

import com.kaiming.icake.entity.Account;

public interface AccountBiz {
    Account login(String name, String password);
}
