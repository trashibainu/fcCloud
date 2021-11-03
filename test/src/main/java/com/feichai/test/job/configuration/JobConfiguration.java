package com.feichai.test.job.configuration;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 项目启动后会自动执行Job
 */
//@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        //job
//        return jobBuilderFactory.get("JingYing")
//                .start(one())
//                .next(one())
//                .next(one())
//                .build();

        //job---decider()
        return jobBuilderFactory.get("JingYing")
                .start(one())
                .next(decider())
                .from(decider()).on("ONE").to(one())
                .from(one()).on("*").to(one())
                .end()
                .build();

        //flow
//        return jobBuilderFactory.get("YuanJing")
//                .start(stepsFlow())
//                .next(one()).end().build();

        //split-----线程同步
//        return jobBuilderFactory.get("WU")
//                .start(stepsFlow())
//                .split(new SimpleAsyncTaskExecutor()).add(stepsFlow(),stepsFlow())
//                .end()
//                .build();
    }

    @Bean
    public Step one() {
        return stepBuilderFactory.get("one")
                .tasklet((new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello Spring Batch.");
                        return RepeatStatus.FINISHED;
                    }
                })).build();
    }

    /**
     * Flow是step的集合
     *
     * @return
     */
    @Bean
    public Flow stepsFlow() {
        return new FlowBuilder<Flow>("")
                .start(one())
                .next(one())
                .build();
    }

    @Bean
    public JobExecutionDecider decider(){
        return new MyDecider();
    }

    private class MyDecider implements JobExecutionDecider {
        @Override
        public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {

            return new FlowExecutionStatus("ONE");
        }
    }
}
