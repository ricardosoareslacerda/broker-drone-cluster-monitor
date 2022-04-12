package br.com.fiap.broker.dronemonitorproducer.job;

import br.com.fiap.broker.dronemonitorproducer.services.DroneService;
import lombok.AllArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DroneJob implements Job {

    @Autowired
    private DroneService jobService;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        jobService.executeSampleJob();
    }
}
