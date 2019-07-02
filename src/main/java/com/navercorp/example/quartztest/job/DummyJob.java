package com.navercorp.example.quartztest.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyJob implements Job {
	private static final Logger logger = LoggerFactory.getLogger(DummyJob.class);

	@Override
	public void execute(JobExecutionContext context) {
		int testData = context.getMergedJobDataMap().getIntegerFromString("testData");
		logger.debug("DummyJob is executed. data: {}", testData);
	}
}
