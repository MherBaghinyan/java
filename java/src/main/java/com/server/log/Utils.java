package com.server.log;

import com.server.log.DurationEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static final DateTimeFormatter LOG_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateTimeFormatter START_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss");

    public static boolean isLogDateValid(String argLogDate, String startDate, String duration) {
        LocalDateTime fromDate = getLocalDateTime(startDate, START_DATE_FORMATTER);
        LocalDateTime logDate = getLocalDateTime(argLogDate, LOG_DATE_FORMATTER);
        LocalDateTime toDate = getToDate(fromDate, duration);
        return logDate.isAfter(fromDate) && logDate.isBefore(toDate);
    }

    public static LocalDateTime getLocalDateTime(String startDate, DateTimeFormatter formatter) {
        return LocalDateTime.parse(startDate, formatter);
    }

    private static LocalDateTime getToDate(LocalDateTime fromDate, String durationArg) {

        if (DurationEnum.HOURLY.getType().equals(durationArg)) {
            return fromDate.plusHours(1);
        } else if (DurationEnum.DAILY.getType().equals(durationArg)) {
            return fromDate.plusDays(1);
        }

        return fromDate;
    }
}
