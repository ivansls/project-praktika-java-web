package com.web_project.school.service;

import com.web_project.school.model.LocationModel;
import com.web_project.school.repository.LocationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryLocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;


    public InMemoryLocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationModel> findAllLocation(){
        return locationRepository.findAll(Sort.by("id"));
    }

    @Override
    public LocationModel findLocationById(UUID id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public LocationModel addLocation(LocationModel location){
        return locationRepository.save(location);
    }

    @Override
    public LocationModel updateLocation(LocationModel location){
        if (locationRepository.existsById(location.getId())) {
            return locationRepository.save(location);
        }
        return null;
    }

    @Override
    public void deleteLocation(UUID id){
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
        }
    }

}
