package com.swt.lab.task3;

import com.swt.lab.task3.states.ShipState;
import com.swt.lab.task3.states.SwitchState;
import com.swt.lab.task3.sw.EmergencyAction;
import com.swt.lab.task3.sw.Switch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SwitchTest {

    @Test
    void testToggle() {
        Ship ship = TestFactory.normalShipWithoutSwitch();
        Switch sw = new Switch(new EmergencyAction(ship), SwitchState.OFF);

        sw.toggle();
        assertEquals(SwitchState.ON, sw.getState());
        assertEquals(ShipState.NORMAL, ship.getState());

        sw.toggle();
        assertEquals(SwitchState.OFF, sw.getState());
        assertEquals(ShipState.EMERGENCY, ship.getState());
    }

    @Test
    void testToggleWithEmptyAction() {
        Switch sw = new Switch(null, SwitchState.OFF);

        sw.toggle();
        assertEquals(SwitchState.ON, sw.getState());

        sw.toggle();
        assertEquals(SwitchState.OFF, sw.getState());
    }

    @Test
    void testBrokenSwitch() {
        Switch sw = new Switch(null, SwitchState.OFF);
        sw.setState(SwitchState.BROKEN);

        sw.toggle();
        assertEquals(SwitchState.BROKEN, sw.getState());
    }
}
