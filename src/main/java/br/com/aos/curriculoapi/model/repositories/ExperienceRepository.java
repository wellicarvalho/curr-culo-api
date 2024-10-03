package br.com.aos.curriculoapi.model.repositories;

import br.com.aos.curriculoapi.model.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {}
