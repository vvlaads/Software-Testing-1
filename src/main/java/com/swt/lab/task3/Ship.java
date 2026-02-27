package com.swt.lab.task3;

import com.swt.lab.task3.states.PersonState;
import com.swt.lab.task3.states.ShipState;

import java.util.List;

public class Ship {
    private final List<Wall> walls;
    private final List<Person> people;

    private final NavigationPanel navigationPanel;

    private ShipState state;

    public void emergency() {
        state = ShipState.EMERGENCY;

        for (Person person : people) {
            person.setState(PersonState.PRESSED_BY_INERTIA);
        }

        for (Wall wall : walls) {
            wall.deployAirbags();
        }
    }

    public void stabilize() {
        state = ShipState.NORMAL;

        for (Person person : people) {
            person.setState(PersonState.CAN_MOVE);
        }

        for (Wall wall : walls) {
            wall.hideAirbags();
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Person> getPeople() {
        return people;
    }

    public ShipState getState() {
        return state;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public NavigationPanel getNavigationPanel() {
        return navigationPanel;
    }

    public Ship(List<Wall> walls, List<Person> people, NavigationPanel navigationPanel, ShipState state) {
        this.walls = walls;
        this.people = people;
        this.navigationPanel = navigationPanel;
        this.state = state;
    }
}
