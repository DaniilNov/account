package ru.iteco.account.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.iteco.account.model.PersonalInfo;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Value("${name}")
    private String name;

    public PersonalInformationServiceImpl() {
    }

    @PostConstruct
    public void init() {
        if (name.contains("N")) {
            log.info("YES");
        }
    }

    @Override
    public PersonalInfo getPersonalInfoById(Integer id) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName(name);
        personalInfo.setUserId(id);
        return personalInfo;
    }
}
