package ru.iteco.account.service;

import org.springframework.stereotype.Service;
import ru.iteco.account.model.AccountInfo;
import ru.iteco.account.model.BankBook;
import ru.iteco.account.model.PersonalInfo;

import java.util.List;

@Service
public class AccountServiceMockImpl implements AccountService {


    @Override
    public AccountInfo getAccountInfoById(Integer id) {

        return new  AccountInfo();
    }
}
