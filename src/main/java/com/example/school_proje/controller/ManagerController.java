package com.example.school_proje.controller;

import com.example.school_proje.dto.ManagerDto;
import com.example.school_proje.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("managers")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping
    public ManagerDto saveManager(@RequestBody ManagerDto managerDto){
        return  managerService.saveManager(managerDto);
    }

    @GetMapping("{id}")
    public ManagerDto getManager(@PathVariable String id){
        return managerService.findById(id);
    }

    @GetMapping
    public List<ManagerDto> getAllManagers(){
        return managerService.getAllManagers();
    }
}
