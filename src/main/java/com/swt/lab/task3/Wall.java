package com.swt.lab.task3;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    private List<Airbag> airbagList = new ArrayList<>();

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

    public List<Airbag> getAirbagList() {
        return airbagList;
    }

    public void setAirbagList(List<Airbag> airbagList) {
        this.airbagList = airbagList;
    }

    public Wall() {
    }

    public Wall(List<Airbag> airbagList) {
        this.airbagList = airbagList;
    }
}
