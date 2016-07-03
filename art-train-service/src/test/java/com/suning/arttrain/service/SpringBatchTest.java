package com.suning.arttrain.service;

import com.suning.arttrain.service.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhanglb on 14-8-3.
 */
public class SpringBatchTest  extends BaseTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job reportJob;

    @Test
    public void springBatchReportTest(){
        try {
            JobExecution execution = jobLauncher.run(reportJob, new JobParameters());
            Assert.assertEquals(BatchStatus.COMPLETED,execution.getStatus());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

    }
}
