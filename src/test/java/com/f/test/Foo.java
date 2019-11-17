package com.f.test;


import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.calendar.HolidayCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class Foo {
    public void say() {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("info");
        logger.error("error");
        logger.debug("debug");
        logger.trace("trace");
        logger.warn("warn");
    }

    @Test
    void foo() {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("hello");
    }

    @Test
    void quartzHello() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("name", "helloName")
                    .usingJobData("age", 10)
                    .usingJobData("sex", "female")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .usingJobData("sexName", "sex-foo")
                    .usingJobData("sexAge", 15)
                    .startNow()
                    .withSchedule(
                            cronSchedule("0/1 * * * * ?")
                    )
                    .build();

            scheduler.start();
            scheduler.scheduleJob(job, trigger);
            TimeUnit.DAYS.sleep(3);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
