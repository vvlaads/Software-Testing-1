package com.swt.lab.task3;

import com.swt.lab.task3.states.PersonState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    void testName() {
        String name = "Силинцев Владислав";
        Person person = new Person(name, PersonState.CAN_MOVE);
        assertEquals(name, person.getName());
    }

    @Test
    void testTurnAround() {
        Person person = new Person("Алексей", PersonState.PRESSED_BY_INERTIA);
        person.turnAround();
        assertEquals(PersonState.CAN_MOVE, person.getState());
    }
}
