package org.nt_uni.web_studio.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.dao.ApplicationTypeRepository;
import org.nt_uni.web_studio.dao.StatusRepository;
import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.enums.SoftwareType;
import org.nt_uni.web_studio.model.process.Status;
import org.nt_uni.web_studio.service.DropdownService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DropdownServiceImpl implements DropdownService {
    private final StatusRepository statusRepository;
    private final ApplicationTypeRepository applicationTypeRepository;
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
        return Arrays.asList(SoftwareType.values());
    }
}
