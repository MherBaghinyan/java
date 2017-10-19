package com.server.log;

public enum DurationEnum {

    HOURLY("hourly"),
    DAILY("daily");

    private String type;

    DurationEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
