package tech.powerjob.server.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class JobLogReport {

    private int id;

    private Date triggerDay;

    private int runningCount;
    private int sucCount;
    private int failCount;
}
