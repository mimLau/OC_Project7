package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.dao.WorkDao;
import com.mimi.mlibrary.model.works.Work;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkController {
    private WorkDao workDao;

    public WorkController(WorkDao workDao){
        this.workDao = workDao;
    }


    @GetMapping(value = "Works")
    public List<Work> getAllwork() {
    return workDao.findAll();
    }

    @GetMapping(value = "Work/{id}")
    public Optional<Work> getWorkById(@PathVariable int id) {
        return workDao.findById(id);
    }
}
