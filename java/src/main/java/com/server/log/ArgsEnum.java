package com.server.log;

public enum ArgsEnum {

    START_DATE("startDate"),
    DURATION("duration"),
    THRESHOLD("threshold");

    private String var;

    ArgsEnum(String s) {
        this.var = s;
    }

    public String getVar() {
        return var;
    }
}
