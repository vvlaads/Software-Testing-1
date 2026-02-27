package com.swt.lab.task3.sw;

import com.swt.lab.task3.states.SwitchState;

public class Switch {
    private SwitchState state;
    private final SwitchAction action;

    public void toggle() {
        switch (state) {
            case ON -> {
                state = SwitchState.OFF;
                if (action != null) {
                    action.off();
                }
            }
            case OFF -> {
                state = SwitchState.ON;
                if (action != null) {
                    action.on();
                }
            }
        }
    }

    public SwitchState getState() {
        return state;
    }

    public void setState(SwitchState state) {
        this.state = state;
    }

    public Switch(SwitchAction action, SwitchState state) {
        this.action = action;
        this.state = state;
    }
}
