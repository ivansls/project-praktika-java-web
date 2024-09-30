package com.web_project.school.service;

import com.web_project.school.model.HolidayModel;
import com.web_project.school.model.UniversityModel;

import java.util.List;
import java.util.UUID;

public interface HolidaysService {
    public List<HolidayModel> findAllHolidays();

    public HolidayModel findHolidayById(UUID id);

    public HolidayModel addHoliday(HolidayModel university);

    public HolidayModel updateHoliday(HolidayModel university);

    public void deleteHoliday(UUID id);
}
