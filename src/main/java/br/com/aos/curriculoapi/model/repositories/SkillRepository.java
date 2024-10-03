package br.com.aos.curriculoapi.model.repositories;

import br.com.aos.curriculoapi.model.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {}
