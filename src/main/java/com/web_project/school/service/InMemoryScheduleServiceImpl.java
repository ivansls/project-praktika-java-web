package com.web_project.school.service;

import com.individual_project.individual_project.model.ScheduleModule;
import com.individual_project.individual_project.repository.ScheduleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;


    public InMemoryScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public List<ScheduleModule> findAllSchedule() {
       return scheduleRepository.findAll(Sort.by("id"));
    }

    @Override
    public ScheduleModule findScheduleById(UUID id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public ScheduleModule addSchedule(ScheduleModule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public ScheduleModule updateSchedule(ScheduleModule schedule) {
        if (scheduleRepository.existsById(schedule.getId())) {
            return scheduleRepository.save(schedule);
        }
        return null;
    }

    @Override
    public void deleteSchedule(UUID id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
        }
    }
}
