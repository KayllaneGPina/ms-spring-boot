package br.com.project.msspringboot.job.controller;

import br.com.project.msspringboot.job.model.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private List<Job> jobs = new ArrayList<>();

    @GetMapping
    public List<Job> findAll() {
        return jobs;
    }

    @PostMapping
    public String save(@RequestBody Job job) { // @RequestBody: Converte o JSON recebido no corpo da requisição para o objeto Job
        jobs.add(job);
        return "Job saved successfully!";
    }

}
