package br.com.aos.curriculoapi.model.repositories;

import br.com.aos.curriculoapi.model.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {}
