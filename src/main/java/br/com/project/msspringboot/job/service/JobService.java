package br.com.project.msspringboot.job.service;

import br.com.project.msspringboot.job.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createdJob(Job job);
    Job findById(Long id);
}
