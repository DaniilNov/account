package ru.iteco.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import ru.iteco.account.model.AccountInfo;
import ru.iteco.account.model.User;
import ru.iteco.account.repository.ExternalRepository;
import ru.iteco.account.service.AccountService;
import ru.iteco.account.service.AccountServiceImpl;
import ru.iteco.account.service.IObjectValue;
import ru.iteco.account.service.ObjectValue;

@Slf4j
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class AccountApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountApplication.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        ExternalRepository externalRepository = applicationContext.getBean(ExternalRepository.class);
        User user = User.builder().id(1).name("name").build();
        String info = externalRepository.getInfo(user);
        log.info("Result external repository: {}", info);
        externalRepository.saveInfo(null);

        AccountInfo accountInfo = accountService.getAccountInfoById(1);
        System.out.println(accountInfo);


        for (int i = 0; i < 5; i++) {
            IObjectValue objectValue = applicationContext.getBean(IObjectValue.class);
            System.out.println("objectValue type: " + objectValue.getClass());
            System.out.println("result info: " + objectValue.getInfo());
        }
    }
}
