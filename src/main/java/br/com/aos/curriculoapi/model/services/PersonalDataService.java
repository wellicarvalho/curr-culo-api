package br.com.aos.curriculoapi.model.services;

import br.com.aos.curriculoapi.model.entities.PersonalData;
import br.com.aos.curriculoapi.model.repositories.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    @Autowired
    public PersonalDataService(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public PersonalData save(PersonalData personalData) {
        return personalDataRepository.save(personalData);
    }

    public PersonalData findById(Long id){
        return personalDataRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(new RuntimeException(String.format("Id= '%s' não encontrado", id))));
    }

    public List<PersonalData> findAll(){
        return personalDataRepository.findAll();
    }

    public void delete(Long id){
        PersonalData data = findById(id);
        personalDataRepository.delete(data);
    }

    public void update(Long id, PersonalData newData){
        PersonalData oldData = findById(id);
        personalDataRepository.save(updateData(oldData, newData));
    }

    private PersonalData updateData(PersonalData data, PersonalData newData) {
        data.setName(newData.getName());
        data.setEmail(newData.getEmail());
        data.setPhone(newData.getPhone());
        data.setAddressStreet(newData.getAddressStreet());
        data.setAddressCity(newData.getAddressCity());
        data.setAddressState(newData.getAddressState());
        data.setAddressCountry(newData.getAddressCountry());
        data.setAddressZip(newData.getAddressZip());
        data.setLinkedinLink(newData.getLinkedinLink());
        data.setGithubLink(newData.getGithubLink());
        data.setAbout(newData.getAbout());

        return data;
    }
}
