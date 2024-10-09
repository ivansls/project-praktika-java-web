package com.web_project.school.service;

import com.web_project.school.model.GroupsModel;

import java.util.List;
import java.util.UUID;

public interface GroupsService {
    public List<GroupsModel> findAllGroups();

    public GroupsModel findGroupById(UUID id);

    public GroupsModel addGroup(GroupsModel group);

    public GroupsModel updateGroup(GroupsModel group);

    public void deleteGroup(UUID id);
}
