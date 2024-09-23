package br.com.project.msspringboot.job.controller;

import br.com.project.msspringboot.job.model.Job;
import br.com.project.msspringboot.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Job>> findAll() { // ResponseEntity é um objeto que representa toda a resposta HTTP: código de status, cabeçalhos e corpo
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Job job) { // @RequestBody: Converte o JSON recebido no corpo da requisição para o objeto Job
        jobService.createdJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) { // @PathVariable: Pega o valor da URL e passa para o parâmetro
       Job job = jobService.findById(id);

       if (job != null) return new ResponseEntity<>(job, HttpStatus.OK);

       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
