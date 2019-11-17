package com.f.test;

import com.google.common.base.Joiner;
import org.quartz.*;

import com.f.test.Logger;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HelloJob implements Job {
    private org.slf4j.Logger logger = Logger.LOGGER;

    public HelloJob() {
        logger.info(getClass().getSimpleName() + " 构造方法被调用");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        logger.error("instant {}: values:\n{}", jobKey, Joiner.on("\n").withKeyValueSeparator(" -> ").join(jobDataMap));

    }
}
