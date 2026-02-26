package com.swt.lab.task3;

import com.swt.lab.task3.states.PersonState;

public class Person {
    private String name;

    private PersonState state;

    public void pressByInertia() {
        state = PersonState.PRESSED_BY_INERTIA;
    }

    public void release() {
        state = PersonState.CAN_MOVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonState getState() {
        return state;
    }

    public void setState(PersonState state) {
        this.state = state;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, PersonState state) {
        this.name = name;
        this.state = state;
    }
}
