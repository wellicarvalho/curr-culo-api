package br.com.aos.curriculoapi.model.repositories;

import br.com.aos.curriculoapi.model.entities.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {}
