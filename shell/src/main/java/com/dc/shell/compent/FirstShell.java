package com.dc.shell.compent;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class FirstShell {

    @ShellMethod(value = "a + b", key = "add", prefix = "-")
    public int addNumber(int a, int b) {
        return a + b;
    }

    @ShellMethod(value = "a - b", key = "sub", prefix = "-")
    public String subNumber(@ShellOption(defaultValue = "0") int a, @ShellOption(value = "-B",defaultValue = "0") int b) {
        int i = a - b;
        return "result = " + i;
    }

    @ShellMethod(value = "boolean", prefix = "-")
    public String said(boolean force) {
        return "You said " + force;
    }


}
