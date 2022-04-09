package ru.iteco.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteco.account.model.ExternalInfo;
import ru.iteco.account.service.ExternalService;

@RestController
class DefaultController {
    private final ExternalService externalService;

    DefaultController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/")
    ExternalInfo getInfo() {
        return externalService.getInfo();
    }
}
