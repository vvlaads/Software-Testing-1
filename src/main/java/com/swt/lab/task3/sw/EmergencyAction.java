package com.swt.lab.task3.sw;

import com.swt.lab.task3.Ship;

public class EmergencyAction implements SwitchAction {

    private final Ship ship;

    @Override
    public void on() {
        ship.stabilize();
    }

    @Override
    public void off() {
        ship.emergency();
    }

    public EmergencyAction(Ship ship) {
        this.ship = ship;
    }
}
