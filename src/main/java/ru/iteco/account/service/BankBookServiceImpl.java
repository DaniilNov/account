package ru.iteco.account.service;

import org.springframework.stereotype.Service;
import ru.iteco.account.model.BankBook;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankBookServiceImpl implements BankBookService {

    @Override
    public List<BankBook> getBankBooksById(Integer id) {
        BankBook bankBook = new BankBook();
        bankBook.setNumber(1L);
        bankBook.setUserId(id);
        List<BankBook> bankBooks = new ArrayList<>();
        bankBooks.add(bankBook);
        return bankBooks;
    }
}
