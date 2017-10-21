package log;

import java.time.LocalDateTime;

public class RequestBean {

    private LocalDateTime startDate;
    private String ip;

    public RequestBean(LocalDateTime startDate, String ip) {
        this.startDate = startDate;
        this.ip = ip;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
