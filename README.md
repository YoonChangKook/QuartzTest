# Quartz Test
* JDK 1.7
* Spring 3.1.2
* Quartz 1.8.6
* Tomcat 7
* Maven 3

### Job
Job은 Quartz의 작업 단위이다.

작업은 Job을 extends한 클래스로 정의하고, 사용할 때는 작업의 디테일한 속성들을 담은 JobDetail 클래스로 감싼 Bean을 이용한다.  

Scheduler의 setJobDetails 함수를 사용하여 Job을 Scheduler에 등록시킬 수 있다.

	schedulerFactoryBean.setJobDetails(...);

### Trigger
Job을 실행할 조건이다.

Job을 실행시킬 시간, 반복 횟수, 파라미터 등을 정할 수 있으며, Scheduler의 scheduleJob 메서드로 등록한다.

	// Job 하나에 여러개의 Trigger 등록 불가
	scheduler.scheduleJob(Job, Trigger);

	// Job 하나에 여러개의 Trigger 등록 가능
	scheduler.scheduleJob(Trigger);

### Scheduler
Trigger의 조건을 감지하여 Job을 실행시킨다.
