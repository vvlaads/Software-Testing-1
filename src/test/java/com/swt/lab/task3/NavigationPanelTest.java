package com.swt.lab.task3;

import com.swt.lab.task3.states.SwitchState;
import com.swt.lab.task3.sw.Switch;
import com.swt.lab.task3.sw.SwitchType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NavigationPanelTest {

    @Test
    void testAddingSwitch() {
        NavigationPanel panel = new NavigationPanel();
        Switch sw = new Switch(null, SwitchState.OFF);
        panel.addSwitch(SwitchType.NONE, sw);
        assertTrue(panel.hasSwitch(SwitchType.NONE));
        assertEquals(sw, panel.getSwitch(SwitchType.NONE));
        assertEquals(1, panel.getSwitchMap().size());
    }

    @Test
    void testContaining() {
        NavigationPanel panel = new NavigationPanel();
        assertFalse(panel.hasSwitch(SwitchType.NONE));
        assertFalse(panel.hasSwitch(SwitchType.EMERGENCY));

        Switch sw = new Switch(null, SwitchState.OFF);
        panel.addSwitch(SwitchType.NONE, sw);
        panel.addSwitch(SwitchType.EMERGENCY, sw);
        assertTrue(panel.hasSwitch(SwitchType.NONE));
        assertTrue(panel.hasSwitch(SwitchType.EMERGENCY));

        panel.removeSwitch(SwitchType.NONE);
        assertFalse(panel.hasSwitch(SwitchType.NONE));
    }
}
