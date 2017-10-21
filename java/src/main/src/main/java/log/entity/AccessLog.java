package log.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Mher on 12/22/2015.
 */
@Entity
public class AccessLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    private String ip;

    public AccessLog(LocalDateTime localDateTime, String ip) {
        this.startDate = localDateTime;
        this.ip = ip;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "AccessLog{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
