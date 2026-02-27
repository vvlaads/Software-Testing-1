package com.swt.lab.task3;

import com.swt.lab.task3.states.*;
import com.swt.lab.task3.sw.*;

import java.util.List;

public class TestFactory {

    public static Ship normalShipWithoutSwitch() {
        Airbag airbag1 = new Airbag(AirbagState.HIDDEN);
        Airbag airbag2 = new Airbag(AirbagState.HIDDEN);

        Wall wall1 = new Wall();
        wall1.addAirbag(airbag1);
        Wall wall2 = new Wall();
        wall2.addAirbag(airbag2);

        Person person1 = new Person("Зафод", PersonState.CAN_MOVE);
        Person person2 = new Person("Роберт", PersonState.CAN_MOVE);

        NavigationPanel panel = new NavigationPanel();

        return new Ship(
                List.of(wall1, wall2),
                List.of(person1, person2),
                panel,
                ShipState.NORMAL
        );
    }

    public static Ship normalShipWithEmergencySwitch() {
        Airbag airbag1 = new Airbag(AirbagState.HIDDEN);
        Airbag airbag2 = new Airbag(AirbagState.HIDDEN);

        Wall wall1 = new Wall();
        wall1.addAirbag(airbag1);
        Wall wall2 = new Wall();
        wall2.addAirbag(airbag2);

        Person person1 = new Person("Зафод", PersonState.CAN_MOVE);
        Person person2 = new Person("Роберт", PersonState.CAN_MOVE);

        NavigationPanel panel = new NavigationPanel();

        Ship ship = new Ship(
                List.of(wall1, wall2),
                List.of(person1, person2),
                panel,
                ShipState.NORMAL
        );

        Switch emergencySwitch = new Switch(new EmergencyAction(ship), SwitchState.OFF);
        panel.addSwitch(SwitchType.EMERGENCY, emergencySwitch);

        return ship;
    }
}