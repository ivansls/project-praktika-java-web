package com.web_project.school.service;

import com.web_project.school.model.UniversityModel;
import com.web_project.school.repository.UniversitytRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryUniversityServiceImpl implements UniversityService{
    private final UniversitytRepository universityRepository;

    public InMemoryUniversityServiceImpl(UniversitytRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<UniversityModel> findAllUniversitys(){
        return universityRepository.findAll(Sort.by("id"));
    }

    @Override
    public UniversityModel finduniversityById(UUID id) {
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public UniversityModel adduniversity(UniversityModel university){
        return universityRepository.save(university);
    }

    @Override
    public UniversityModel updateuniversity(UniversityModel university){
        if(universityRepository.existsById(university.getId())){
            return universityRepository.save(university);
        }else {
            return null;
        }
    }

    @Override
    public void deleteuniversity(UUID id){
        if(universityRepository.existsById(id)) universityRepository.deleteById(id);
    }

}
