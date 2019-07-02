package com.navercorp.example.quartztest.controller;

import java.util.Collections;
import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("quartz")
public class QuartzController {
	private static final Logger logger = LoggerFactory.getLogger(QuartzController.class);

	private final Scheduler scheduler;

	@Autowired
	public QuartzController(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@RequestMapping(value="trigger/after10", method= RequestMethod.GET)
	public void setQuartzTriggerAfter10Seconds() throws SchedulerException {
		logger.debug("Set Schedule After 10 Seconds !!");

		Date triggerDate = new Date(System.currentTimeMillis() + 10 * 1000);
		JobDataMap jobData = new JobDataMap(Collections.singletonMap("testData", "123"));
		Trigger trigger = new SimpleTrigger("trigger" + triggerDate.getTime(), triggerDate);
		trigger.setJobDataMap(jobData);
		trigger.setJobName("dummyJob");

		scheduler.scheduleJob(trigger);
	}
}
