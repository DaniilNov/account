package ru.iteco.account.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.iteco.account.model.annotation.EncryptResult;
import ru.iteco.account.model.annotation.InjectRandom;

@Component
@Scope(value = "prototype")
public class ObjectValue implements IObjectValue {

    @InjectRandom
    private int value1;

    @InjectRandom(min = 10, max = 100)
    private int value2;

    @EncryptResult
    public String getInfo() {
        return "ObjectValue{" +
                "value1=" + value1 +
                "value2=" + value2 +
                "}";
    }
}
