package com.swt.lab.task3.sw;

import com.swt.lab.task3.states.SwitchState;

public class Switch {
    private SwitchState state = SwitchState.OFF;
    private final SwitchAction action;

    public void toggle() {
        switch (state) {
            case ON -> {
                state = SwitchState.OFF;
                action.on();
            }
            case OFF -> {
                state = SwitchState.ON;
                action.off();
            }
        }
    }

    public SwitchState getState() {
        return state;
    }

    public void setState(SwitchState state) {
        this.state = state;
    }

    public Switch(SwitchAction action) {
        this.action = action;
    }
}
