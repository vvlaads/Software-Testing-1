package com.swt.lab.task3;

import com.swt.lab.task3.states.AirbagState;

public class Airbag {
    private AirbagState state;

    public void deploy() {
        if (state.equals(AirbagState.HIDDEN)) {
            state = AirbagState.DEPLOYED;
        }
    }

    public void hide() {
        if (state.equals(AirbagState.DEPLOYED)) {
            state = AirbagState.HIDDEN;
        }
    }

    public AirbagState getState() {
        return state;
    }

    public void setState(AirbagState state) {
        this.state = state;
    }

    public Airbag(AirbagState state) {
        this.state = state;
    }
}
