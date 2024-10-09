package com.web_project.school.service;

import com.individual_project.individual_project.model.GroupsModel;
import com.individual_project.individual_project.repository.GroupsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryGroupsServiceImpl implements GroupsService{
    private final GroupsRepository groupsRepository;


    public InMemoryGroupsServiceImpl(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }


    @Override
    public List<GroupsModel> findAllGroups() {
       return groupsRepository.findAll(Sort.by("id"));
    }

    @Override
    public GroupsModel findGroupById(UUID id) {
        return groupsRepository.findById(id).orElse(null);
    }

    @Override
    public GroupsModel addGroup(GroupsModel group) {
        return groupsRepository.save(group);
    }

    @Override
    public GroupsModel updateGroup(GroupsModel group) {
        if (groupsRepository.existsById(group.getId())) {
            return groupsRepository.save(group);
        }
        return null;
    }

    @Override
    public void deleteGroup(UUID id) {
        if (groupsRepository.existsById(id)) {
            groupsRepository.deleteById(id);
        }
    }
}
