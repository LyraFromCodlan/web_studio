package org.nt_uni.web_studio.service;

import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.enums.SoftwareType;
import org.nt_uni.web_studio.model.process.Status;

import java.util.List;

public interface DropdownService {
    List<ApplicationType> getApplicationTypes();
    List<Status> getStatuses();
    List<SoftwareType> getSoftwareTypes();
}
