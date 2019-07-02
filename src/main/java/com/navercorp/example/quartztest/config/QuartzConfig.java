package com.navercorp.example.quartztest.config;

import org.quartz.JobDetail;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import com.navercorp.example.quartztest.job.DummyJob;

/**
 * Quartz 관련 Bean들을 정의하는 클래스
 *
 * @author 국윤창
 */
@Configuration
public class QuartzConfig {
	@Bean
	@Autowired
	public SchedulerFactoryBean scheduler(@Qualifier("dummyJob")JobDetail dummyJob) {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setJobDetails(new JobDetail[] { dummyJob });
		return schedulerFactoryBean;
	}

	/**
	 * Quartz Job 내부에서 Spring Context를 이용할 수 있도록 해준다.
	 */
	@Bean
	public JobFactory jobFactory(final AutowireCapableBeanFactory beanFactory) {
		return new SpringBeanJobFactory() {
			@Override
			protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
				Object job = super.createJobInstance(bundle);
				beanFactory.autowireBean(job);
				return job;
			}
		};
	}

	@Bean
	public JobDetailFactoryBean dummyJob() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(DummyJob.class);
		factory.setName("dummyJob");
		factory.setDurability(true);
		return factory;
	}
}
