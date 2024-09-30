package com.web_project.school.service;

import com.web_project.school.model.PasportModel;
import com.web_project.school.repository.PasportRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryPasportServiceImpl implements PasportService{
    private final PasportRepository PasportRepository;

    public InMemoryPasportServiceImpl(PasportRepository PasportRepository) {
        this.PasportRepository = PasportRepository;
    }

    @Override
    public List<PasportModel> findAllPasports(){
        return PasportRepository.findAll(Sort.by("id"));
    }

    @Override
    public PasportModel findPasportById(UUID id) {
        return PasportRepository.findById(id).orElse(null);
    }

    @Override
    public PasportModel addPasport(PasportModel Pasport){
        return PasportRepository.save(Pasport);
    }

    @Override
    public PasportModel updatePasport(PasportModel Pasport){
        if(PasportRepository.existsById(Pasport.getId())){
            return PasportRepository.save(Pasport);
        }else {
            return null;
        }
    }

    @Override
    public void deletePasport(UUID id){
        if(PasportRepository.existsById(id)) PasportRepository.deleteById(id);
    }

}
