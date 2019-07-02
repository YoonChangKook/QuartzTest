# Quartz Test
* JDK 1.7
* Spring 3.1.2
* Quartz 1.8.6
* Tomcat 7
* Maven 3

### Job
Job은 Quartz의 작업 단위이다.

작업은 Job을 extends한 클래스로 정의하고, 사용할 때는 작업의 디테일한 속성들을 담은 JobDetail 클래스로 감싼 Bean을 이용한다.  

Job을 등록하는 방식에는 두가지가 있다.
1. Scheduler에 Add 하는 방식

		schedulerFactoryBean.setJobDetails(...);

2. Scheduler의 scheduleJob 메서드에 인자로 넘기는 방식

		scheduler.scheduleJob(Job, Trigger);

두 번째 방식은 Job 하나에 여러개의 트리거 등록이 불가능하므로 첫번째 방식을 사용한다.

### Trigger
Job을 실행할 조건이다.

Job을 실행시킬 시간, 반복 횟수, 파라미터 등을 정할 수 있으며, Scheduler의 scheduleJob 메서드로 등록한다.

### Scheduler
Trigger의 조건을 감지하여 Job을 실행시킨다.
