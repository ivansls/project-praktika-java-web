package com.web_project.school.service;

import com.web_project.school.model.RoleEnum;
import com.web_project.school.model.UsersModel;
import com.web_project.school.repository.UsersRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InMemoryUsersServiceImpl implements UsersService{
    private final UsersRepository userRepository;


    public InMemoryUsersServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UsersModel> findAllUsers(String role) {
        if(!Objects.equals(role, "ALL")){
            List<UsersModel> users = new ArrayList<>();
            userRepository.findAll(Sort.by("id"))
                    .forEach(u -> {
                        if (u.getRoles().stream()
                                .map(RoleEnum::getAuthority)
                                .collect(Collectors.toSet()).contains(role)) {
                            users.add((UsersModel) u);
                        }
                    });
//               .filter(user -> user.getRoles().contains(role)
//               .toList());
            return users;
        }else {
            return userRepository.findAll(Sort.by("id"));
        }

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
