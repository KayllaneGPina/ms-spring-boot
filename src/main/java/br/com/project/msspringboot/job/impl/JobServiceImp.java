package br.com.project.msspringboot.job.impl;

import br.com.project.msspringboot.job.model.Job;
import br.com.project.msspringboot.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImp implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createdJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }
}
