package br.com.project.msspringboot.job.controller;

import br.com.project.msspringboot.job.model.Job;
import br.com.project.msspringboot.job.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    public String save(@RequestBody Job job) { // @RequestBody: Converte o JSON recebido no corpo da requisição para o objeto Job
        jobService.createdJob(job);
        return "Job saved successfully!";
    }

}
