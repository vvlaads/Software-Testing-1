package com.swt.lab.task1;

public class ArccosArgumentException extends Exception {
    public ArccosArgumentException() {
        super("Argument for function arccos should be in range [-1, 1]");
    }
}
