package com.swt.lab.task3;

import com.swt.lab.task3.states.PersonState;
import com.swt.lab.task3.sw.Switch;

public class Person {
    private final String name;

    private PersonState state;

    public void useSwitch(Switch sw) {
        if (state.equals(PersonState.CAN_MOVE)) {
            sw.toggle();
        }
    }

    public void turnAround() {
        state = PersonState.CAN_MOVE;
    }

    public String getName() {
        return name;
    }

    public PersonState getState() {
        return state;
    }

    public void setState(PersonState state) {
        this.state = state;
    }

    public Person(String name, PersonState state) {
        this.name = name;
        this.state = state;
    }
}