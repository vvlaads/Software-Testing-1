package com.swt.lab.task3;

import com.swt.lab.task3.states.*;
import com.swt.lab.task3.sw.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipTest {

    @Test
    void testEmergencyFullScenario() {
        Ship ship = TestFactory.normalShipWithEmergencySwitch();
        Person person1 = ship.getPeople().get(0);
        Person person2 = ship.getPeople().get(1);

        // авария
        ship.emergency();
        assertEquals(PersonState.PRESSED_BY_INERTIA, person1.getState());
        assertEquals(PersonState.PRESSED_BY_INERTIA, person2.getState());

        assertEquals(AirbagState.DEPLOYED, ship.getWalls().get(0).getAirbagList().get(0).getState());
        assertEquals(AirbagState.DEPLOYED, ship.getWalls().get(1).getAirbagList().get(0).getState());

        // попытка нажать сразу — ничего не меняется
        person1.useSwitch(ship.getNavigationPanel().getSwitch(SwitchType.EMERGENCY));
        assertEquals(ShipState.EMERGENCY, ship.getState());
        assertEquals(SwitchState.OFF, ship.getNavigationPanel().getSwitch(SwitchType.EMERGENCY).getState());

        // после поворота можно нажать
        person1.turnAround();
        person1.useSwitch(ship.getNavigationPanel().getSwitch(SwitchType.EMERGENCY));
        assertEquals(ShipState.NORMAL, ship.getState());
        assertEquals(SwitchState.ON, ship.getNavigationPanel().getSwitch(SwitchType.EMERGENCY).getState());

        assertEquals(PersonState.CAN_MOVE, person1.getState());
        assertEquals(PersonState.CAN_MOVE, person2.getState());

        assertEquals(AirbagState.HIDDEN, ship.getWalls().get(0).getAirbagList().get(0).getState());
        assertEquals(AirbagState.HIDDEN, ship.getWalls().get(1).getAirbagList().get(0).getState());
    }

    @Test
    void pressedPersonCannotUseSwitch() {
        Ship ship = TestFactory.normalShipWithEmergencySwitch();
        Person person = ship.getPeople().get(0);

        ship.emergency();
        person.useSwitch(ship.getNavigationPanel().getSwitch(SwitchType.EMERGENCY));

        assertEquals(ShipState.EMERGENCY, ship.getState());
    }

    @Test
    void turnAroundAllowsSwitchUsage() {
        Ship ship = TestFactory.normalShipWithEmergencySwitch();
        Person person = ship.getPeople().get(0);

        ship.emergency();
        person.turnAround();
        person.useSwitch(ship.getNavigationPanel().getSwitch(SwitchType.EMERGENCY));

        assertEquals(ShipState.NORMAL, ship.getState());
    }
}