package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {
    @Transactional
    @Modifying
@Query(value = "delete from dependente where id_responsavel=:idEmpregado", nativeQuery = true)
 void deleteDependentes(Integer idEmpregado);
}
