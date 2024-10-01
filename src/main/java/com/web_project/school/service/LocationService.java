package com.web_project.school.service;

import com.web_project.school.model.LocationModel;

import java.util.List;
import java.util.UUID;

public interface LocationService {
    public List<LocationModel> findAllLocation();

    public LocationModel findLocationById(UUID id);

    public LocationModel addLocation(LocationModel location);

    public LocationModel updateLocation(LocationModel location);

    public void deleteLocation(UUID id);
}
