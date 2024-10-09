package com.web_project.school.service;

import com.individual_project.individual_project.model.ScheduleModule;

import java.util.List;
import java.util.UUID;

public interface ScheduleService {
    public List<ScheduleModule> findAllSchedule();

    public ScheduleModule findScheduleById(UUID id);

    public ScheduleModule addSchedule(ScheduleModule schedule);

    public ScheduleModule updateSchedule(ScheduleModule schedule);

    public void deleteSchedule(UUID id);
}
