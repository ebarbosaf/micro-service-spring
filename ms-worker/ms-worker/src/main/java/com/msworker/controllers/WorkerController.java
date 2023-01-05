package com.msworker.controllers;

import com.msworker.entities.Worker;
import com.msworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        System.out.println("Entrou no método");
        List<Worker> listWorker = workerRepository.findAll();
        return ResponseEntity.ok(listWorker);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker>  findId(@PathVariable Long id) {
        return ResponseEntity.ok(workerRepository.findById(id).get());
    }
}
