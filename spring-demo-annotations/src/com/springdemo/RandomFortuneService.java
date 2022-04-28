package com.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements  FortuneService{
    String[] forutnes={
            "Beware of the wolf in sheeps clothing",
            "Diligience is the mother of good luck",
            "today is your lucky day","hhjp;p"
    };
    private Random random=new Random();
    @Override
    public String getFortune() {
        int index=random.nextInt(forutnes.length);
        return forutnes[index];
    }
}
