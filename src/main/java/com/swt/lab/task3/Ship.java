package com.swt.lab.task3;

import com.swt.lab.task3.states.ShipState;

import java.util.List;

public class Ship {
    private List<Wall> walls;
    private List<Person> people;

    private NavigationPanel navigationPanel;

    private ShipState state;

    public void emergency() {
        state = ShipState.EMERGENCY;

        for (Person person : people) {
            person.pressByInertia();
        }

        for (Wall wall : walls) {
            wall.deployAirbags();
        }
    }

    public void stabilize() {
        state = ShipState.NORMAL;

        for (Person person : people) {
            person.release();
        }

        for (Wall wall : walls) {
            wall.hideAirbags();
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
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

    public void setNavigationPanel(NavigationPanel navigationPanel) {
        this.navigationPanel = navigationPanel;
    }

    public Ship(List<Wall> walls, List<Person> people, NavigationPanel navigationPanel, ShipState state) {
        this.walls = walls;
        this.people = people;
        this.navigationPanel = navigationPanel;
        this.state = state;
    }
}
