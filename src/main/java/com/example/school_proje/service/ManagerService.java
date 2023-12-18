package com.example.school_proje.service;

import com.example.school_proje.dto.ManagerDto;
import com.example.school_proje.entity.Manager;
import com.example.school_proje.repository.ManagerRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    public ManagerDto saveManager(ManagerDto managerDto) {
        return toDto(managerRepository.save(toEntity(managerDto)));
    }

    public ManagerDto findById(String managerId) {
        return toDto(managerRepository.findById(Integer.parseInt(managerId)).get());
    }

    public List<ManagerDto> getAllManagers() {
        List<ManagerDto> managerDtoList = new ArrayList<>();
        for (Manager manager:managerRepository.findAll()) {
            managerDtoList.add(toDto(manager));
        }
        return managerDtoList;
    }


    public Manager toEntity(ManagerDto dto){
        Manager entity = new Manager();
        entity.setName(dto.name);
        entity.setManagerId(dto.managerId);
        return entity;
    }

    public ManagerDto toDto(Manager entity){
        ManagerDto dto = new ManagerDto();
        dto.name = entity.getName();
        dto.managerId = entity.getManagerId();
        return dto;
    }

    public Manager findManagerById(String id) {
        return managerRepository.findById(Integer.parseInt(id)).get();
    }
}
