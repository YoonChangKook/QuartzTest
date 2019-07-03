package com.navercorp.example.quartztest.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DummyJob implements Job {
	private static final Logger logger = LoggerFactory.getLogger(DummyJob.class);

	@Autowired
	private Scheduler scheduler;

	@Override
	public void execute(JobExecutionContext context) {
		int testData = context.getMergedJobDataMap().getIntegerFromString("testData");
		logger.debug("DummyJob is executed. data: {}", testData);

		// autowired test
		try {
			logger.debug(scheduler.getSchedulerName());
		} catch (SchedulerException ex) {
			logger.error("scheduler exception occured", ex);
		}
	}
}
