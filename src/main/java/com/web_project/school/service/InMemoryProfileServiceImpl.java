package com.web_project.school.service;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.repository.ProfileRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryProfileServiceImpl implements ProfileService{
    private final ProfileRepository profileRepository;


    public InMemoryProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public List<ProfileModel> findAllProfiles() {
       return profileRepository.findAll(Sort.by("id"));
    }

    @Override
    public ProfileModel findProfileById(UUID id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public ProfileModel addProfile(ProfileModel group) {
        return profileRepository.save(group);
    }

    @Override
    public ProfileModel updateProfile(ProfileModel group) {
        if (profileRepository.existsById(group.getId())) {
            return profileRepository.save(group);
        }
        return null;
    }

    @Override
    public void deleteProfile(UUID id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
        }
    }
}
