package com.swt.lab.task3;

import com.swt.lab.task3.states.AirbagState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirbagTest {

    @Test
    void testDeploy() {
        Airbag airbag = new Airbag(AirbagState.HIDDEN);
        airbag.deploy();

        assertEquals(AirbagState.DEPLOYED, airbag.getState());

        airbag.setState(AirbagState.BROKEN);
        airbag.deploy();
        assertEquals(AirbagState.BROKEN, airbag.getState());
    }

    @Test
    void testHide() {
        Airbag airbag = new Airbag(AirbagState.DEPLOYED);
        airbag.hide();

        assertEquals(AirbagState.HIDDEN, airbag.getState());

        airbag.setState(AirbagState.BROKEN);
        airbag.hide();
        assertEquals(AirbagState.BROKEN, airbag.getState());
    }
}
