package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {


    Optional<Dependente> findAllById(Integer idDependente);
}
