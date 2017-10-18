import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("\"yyyy-MM-dd HH:mm:ss.SSS\"");
    
    public static LocalDateTime getLocalDateTime(String startDate) {
        return LocalDateTime.parse(startDate, FORMATTER);
    }

    public static LocalDateTime getToDate(LocalDateTime fromDate, String durationArg) {

        if (DurationEnum.HOURLY.getType().equals(durationArg)) {
            return fromDate.plusHours(1);
        } else if (DurationEnum.DAILY.getType().equals(durationArg)) {
            return fromDate.plusDays(1);
        }

        return null;
    }


}
