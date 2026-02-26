package com.swt.lab.task3;

import com.swt.lab.task3.sw.SwitchType;
import com.swt.lab.task3.sw.Switch;

import java.util.HashMap;
import java.util.Map;

public class NavigationPanel {

    private Map<SwitchType, Switch> switchMap = new HashMap<>();

    public void addSwitch(SwitchType type, Switch sw) {
        switchMap.put(type, sw);
    }

    public boolean hasSwitch(SwitchType type) {
        return switchMap.containsKey(type);
    }

    public Switch getSwitch(SwitchType type) {
        return switchMap.get(type);
    }

    public void removeSwitch(SwitchType type) {
        switchMap.remove(type);
    }

    public Map<SwitchType, Switch> getSwitchMap() {
        return switchMap;
    }

    public void setSwitchMap(Map<SwitchType, Switch> switchMap) {
        this.switchMap = switchMap;
    }
}
