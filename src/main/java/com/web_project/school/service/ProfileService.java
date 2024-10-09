package com.web_project.school.service;

import com.individual_project.individual_project.model.ProfileModel;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    public List<ProfileModel> findAllProfiles();

    public ProfileModel findProfileById(UUID id);

    public ProfileModel addProfile(ProfileModel profile);

    public ProfileModel updateProfile(ProfileModel profile);

    public void deleteProfile(UUID id);
}
