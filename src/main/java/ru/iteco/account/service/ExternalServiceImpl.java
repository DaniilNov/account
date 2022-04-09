package ru.iteco.account.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.iteco.account.model.ExternalInfo;

@Slf4j
@Component
public class ExternalServiceImpl implements ExternalService {

    @Override
    public ExternalInfo getInfo() {
        log.info("Call get Info!!!");
        return ExternalInfo.builder().info("INFO!!!").build();
    }
}
