package ru.iteco.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.iteco.account.model.AccountInfo;
import ru.iteco.account.service.AccountService;
import ru.iteco.account.service.AccountServiceImpl;
import ru.iteco.account.service.IObjectValue;
import ru.iteco.account.service.ObjectValue;


@ComponentScan
@PropertySource("classpath:application.properties")
public class AccountApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountApplication.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        AccountInfo accountInfo = accountService.getAccountInfoById(1);
        System.out.println(accountInfo);

        for (int i = 0; i < 5; i++) {
            IObjectValue objectValue = applicationContext.getBean(IObjectValue.class);
            System.out.println("objectValue type: " + objectValue.getClass());
            System.out.println("result info: " + objectValue.getInfo());
        }
    }
}
