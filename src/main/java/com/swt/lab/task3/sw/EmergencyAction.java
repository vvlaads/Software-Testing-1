package com.swt.lab.task3.sw;

import com.swt.lab.task3.Ship;

public class EmergencyAction implements SwitchAction {

    private final Ship ship;

    @Override
    public void on() {
        ship.emergency();
    }

    @Override
    public void off() {
        ship.stabilize();
    }

    public EmergencyAction(Ship ship) {
        this.ship = ship;
    }
}
