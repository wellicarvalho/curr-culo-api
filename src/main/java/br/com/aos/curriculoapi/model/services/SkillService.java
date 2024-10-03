package br.com.aos.curriculoapi.model.services;

import br.com.aos.curriculoapi.model.entities.PersonalData;
import br.com.aos.curriculoapi.model.entities.Skill;
import br.com.aos.curriculoapi.model.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository educationRepository) {
        this.skillRepository = educationRepository;
    }

    public Skill save(Skill personalData) {
        return skillRepository.save(personalData);
    }

    public Skill findById(Long id){
        return skillRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(new RuntimeException(String.format("Id= '%s' não encontrado", id))));
    }

    public List<Skill> findAll(){
        return skillRepository.findAll();
    }

    public void delete(Long id){
        Skill data = findById(id);
        skillRepository.delete(data);
    }

    public void update(Long id, Skill newData){
        Skill oldData = findById(id);
        skillRepository.save(updateData(oldData, newData));
    }

    private Skill updateData(Skill data, Skill newData) {
        data.setName(newData.getName());
        data.setLevel(newData.getLevel());

        return data;
    }
}
