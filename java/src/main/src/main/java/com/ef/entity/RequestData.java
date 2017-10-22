package com.ef.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Mher on 12/22/2015.
 */
@Entity
@Table(name = "request_data")
public class RequestData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    private String ip;
    private String comment;

    public RequestData(LocalDateTime startDate, String ip, String comment) {
        this.startDate = startDate;
        this.ip = ip;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", comment='" + comment + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
