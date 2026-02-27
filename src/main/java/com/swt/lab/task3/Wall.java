package com.swt.lab.task3;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    private final List<Airbag> airbagList = new ArrayList<>();

    public void deployAirbags() {
        for (Airbag airbag : airbagList) {
            airbag.deploy();
        }
    }

    public void hideAirbags() {
        for (Airbag airbag : airbagList) {
            airbag.hide();
        }
    }

    public void addAirbag(Airbag airbag) {
        airbagList.add(airbag);
    }

    public void removeAirbag(Airbag airbag) {
        airbagList.remove(airbag);
    }

    public List<Airbag> getAirbagList() {
        return airbagList;
    }
}