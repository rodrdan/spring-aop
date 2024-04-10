package cz.rodr.springAopDemo.dao;

import cz.rodr.springAopDemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);
}
