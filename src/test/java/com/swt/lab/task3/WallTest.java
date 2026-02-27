package com.swt.lab.task3;

import com.swt.lab.task3.states.AirbagState;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    @Test
    void testAddingAndRemoving() {
        Wall wall = new Wall();
        Airbag airbag1 = new Airbag(AirbagState.HIDDEN);
        Airbag airbag2 = new Airbag(AirbagState.HIDDEN);
        wall.addAirbag(airbag1);
        wall.addAirbag(airbag2);

        assertEquals(2, wall.getAirbagList().size());
        wall.removeAirbag(airbag1);
        assertEquals(1, wall.getAirbagList().size());
    }

    @Test
    void testDeploying() {
        Wall wall = new Wall();
        Airbag airbag1 = new Airbag(AirbagState.HIDDEN);
        Airbag airbag2 = new Airbag(AirbagState.HIDDEN);
        wall.addAirbag(airbag1);
        wall.addAirbag(airbag2);

        wall.deployAirbags();
        List<Airbag> airbagList = wall.getAirbagList();
        for (Airbag airbag : airbagList) {
            assertEquals(AirbagState.DEPLOYED, airbag.getState());
        }
    }

    @Test
    void testHiding() {
        Wall wall = new Wall();
        Airbag airbag1 = new Airbag(AirbagState.DEPLOYED);
        Airbag airbag2 = new Airbag(AirbagState.DEPLOYED);
        wall.addAirbag(airbag1);
        wall.addAirbag(airbag2);

        wall.hideAirbags();
        List<Airbag> airbagList = wall.getAirbagList();
        for (Airbag airbag : airbagList) {
            assertEquals(AirbagState.HIDDEN, airbag.getState());
        }
    }
}
