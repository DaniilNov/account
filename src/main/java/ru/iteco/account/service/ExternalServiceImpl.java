package ru.iteco.account.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExternalServiceImpl implements ExternalService {

    @Override
    public String getInfo() {
        log.info("Call get Info!!!");
        return "INFO!!!";
    }
}
