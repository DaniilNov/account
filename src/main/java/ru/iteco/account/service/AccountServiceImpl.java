package ru.iteco.account.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.iteco.account.model.AccountInfo;
import ru.iteco.account.model.BankBook;
import ru.iteco.account.model.PersonalInfo;

import java.util.List;
import java.util.Map;

@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private final PersonalInformationService personalInformationService;
    private final Map<String, BankBookService> bankBookServices;

    public AccountServiceImpl(PersonalInformationService personalInformationService,
                              Map<String, BankBookService> bankBookServices) {
        this.personalInformationService = personalInformationService;
        this.bankBookServices = bankBookServices;
    }

    @Override
    public AccountInfo getAccountInfoById(Integer id) {
        PersonalInfo personalInfo = personalInformationService.getPersonalInfoById(id);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setPersonalInfo(personalInfo);
        for (Map.Entry<String, BankBookService> bankBookServiceEntry : bankBookServices.entrySet()) {
            BankBookService bankBookService = bankBookServiceEntry.getValue();
            List<BankBook> bankBooks = bankBookService.getBankBooksById(id);
            System.out.println(bankBooks);
            if (!bankBooks.isEmpty()) {
                accountInfo.setBankBooks(bankBooks);
            }
        }
        return accountInfo;
    }
}
