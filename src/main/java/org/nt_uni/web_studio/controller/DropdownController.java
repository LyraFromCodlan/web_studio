package org.nt_uni.web_studio.controller;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.mapper.DropdownMapper;
import org.nt_uni.web_studio.model.dto.output.ApplicationTypeOutput;
import org.nt_uni.web_studio.model.dto.output.StatusOutput;
import org.nt_uni.web_studio.model.enums.SoftwareType;
import org.nt_uni.web_studio.model.process.Status;
import org.nt_uni.web_studio.service.DropdownService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("dropdown")
@RequiredArgsConstructor
public class DropdownController {
    private final DropdownService dropdownService;
    private final DropdownMapper dropdownMapper;
    @GetMapping("applicationType")
    public List<ApplicationTypeOutput> getApplicationTypes(){
        return dropdownService.getApplicationTypes().stream().map(dropdownMapper::mapEntityToDto).collect(Collectors.toList());
    }

    @GetMapping("statuses")
    public List<StatusOutput> getStatuses(){
        return dropdownService.getStatuses().stream().map(dropdownMapper::mapEntityToDto).collect(Collectors.toList());
    }

    @GetMapping("softwareTypes")
    public List<SoftwareType> getSoftwareTypes(){
        return dropdownService.getSoftwareTypes();
    }
}
