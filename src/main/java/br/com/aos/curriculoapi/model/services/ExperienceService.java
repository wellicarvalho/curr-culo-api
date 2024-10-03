package br.com.aos.curriculoapi.model.services;

import br.com.aos.curriculoapi.model.entities.Experience;
import br.com.aos.curriculoapi.model.entities.PersonalData;
import br.com.aos.curriculoapi.model.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience save(Experience personalData) {
        return experienceRepository.save(personalData);
    }

    public Experience findById(Long id){
        return experienceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(new RuntimeException(String.format("Id= '%s' não encontrado", id))));
    }

    public List<Experience> findAll(){
        return experienceRepository.findAll();
    }

    public void delete(Long id){
        Experience data = findById(id);
        experienceRepository.delete(data);
    }

    public void update(Long id, Experience newData){
        Experience oldData = findById(id);
        experienceRepository.save(updateData(oldData, newData));
    }

    private Experience updateData(Experience data, Experience newData) {
        data.setTitle(newData.getTitle());
        data.setDescription(newData.getDescription());
        data.setCompany(newData.getCompany());
        data.setLocation(newData.getLocation());
        data.setPosition(newData.getPosition());
        data.setStartDate(newData.getStartDate());
        data.setEndDate(newData.getEndDate());

        return data;
    }
}
