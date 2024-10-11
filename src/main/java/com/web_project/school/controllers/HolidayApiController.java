package com.web_project.school.controllers;

import com.web_project.school.model.HolidayModel;
import com.web_project.school.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/holidays")
public class HolidayApiController {
    @Autowired
    private final HolidayService holidayService;

    public HolidayApiController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<HolidayModel> getAllHolidays() {
        return holidayService.findAllHolidays();
    }

    @GetMapping("/{id}")
    public HolidayModel getHolidayById(@PathVariable UUID id){
        return holidayService.findHolidayById(id);
    }

    @PostMapping
    public HolidayModel createHoliday(@RequestBody HolidayModel holiday){
        return holidayService.addHoliday(holiday);
    }

    @PutMapping("/{id}")
    public HolidayModel updateHoliday(@PathVariable UUID id, @RequestBody HolidayModel holiday){
        holiday.setId(id);
        return holidayService.updateHoliday(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable UUID id){
        holidayService.deleteHoliday(id);
    }
}
