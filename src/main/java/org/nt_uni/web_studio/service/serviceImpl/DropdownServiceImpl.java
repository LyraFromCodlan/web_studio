package org.nt_uni.web_studio.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.dao.ApplicationTypeRepository;
import org.nt_uni.web_studio.dao.SoftwareTypeRepository;
import org.nt_uni.web_studio.dao.StatusRepository;
import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.base.SoftwareType;
import org.nt_uni.web_studio.model.process.Status;
import org.nt_uni.web_studio.service.DropdownService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DropdownServiceImpl implements DropdownService {
    private final StatusRepository statusRepository;
    private final ApplicationTypeRepository applicationTypeRepository;
    private final SoftwareTypeRepository softwareTypeRepository;
    @Override
    public List<ApplicationType> getApplicationTypes() {
        return applicationTypeRepository.findAll();
    }

    @Override
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public List<SoftwareType> getSoftwareTypes() {
        return softwareTypeRepository.findAll();
    }

    @Override
    public ApplicationType getApplicationTypeByCode(String code) {
        return applicationTypeRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public Status getStatusByCode(String code) {
        return statusRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public SoftwareType getSoftwareTypeByCode(String code) {
        return softwareTypeRepository.findByCodeIgnoreCase(code);
    }
}
