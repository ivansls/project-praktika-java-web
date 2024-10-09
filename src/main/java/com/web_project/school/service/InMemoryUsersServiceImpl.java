package com.web_project.school.service;

import com.individual_project.individual_project.model.UsersModel;
import com.individual_project.individual_project.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryUsersServiceImpl implements UsersService{
    private final UserRepository userRepository;


    public InMemoryUsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UsersModel> findAllUsers() {
       return userRepository.findAll(Sort.by("id"));
    }

    @Override
    public UsersModel findUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UsersModel addUser(UsersModel group) {
        return userRepository.save(group);
    }

    @Override
    public UsersModel updateUser(UsersModel group) {
        if (userRepository.existsById(group.getId())) {
            return userRepository.save(group);
        }
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
