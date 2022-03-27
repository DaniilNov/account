package ru.iteco.account.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.iteco.account.model.User;

@Slf4j
@Component
public class ExternalRepository {

    public String getInfo(User user) {
        log.info("Get info for User {}", user);
        return "EXTERNAL_INFO";
    }

    public void saveInfo(String info) {
        if (info == null) {
            throw new RuntimeException("Null not saved");
        }
        log.info("Save info: {}", info);
    }
}
