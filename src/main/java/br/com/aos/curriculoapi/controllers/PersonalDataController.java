package br.com.aos.curriculoapi.controllers;

import br.com.aos.curriculoapi.model.entities.PersonalData;
import br.com.aos.curriculoapi.model.services.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personalInfo")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @PostMapping
    public ResponseEntity<PersonalData> createPersonalData(@RequestBody PersonalData request) {
        PersonalData createdData = personalDataService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalData> getPersonalData(@PathVariable Long id){
        PersonalData personalData = personalDataService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(personalData);
    }

    @GetMapping
    public ResponseEntity<List<PersonalData>> getAllPersonalData(){
        List<PersonalData> listPersonalData = personalDataService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listPersonalData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePersonalData(@PathVariable Long id, @RequestBody PersonalData request){
        personalDataService.update(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id){
        personalDataService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
