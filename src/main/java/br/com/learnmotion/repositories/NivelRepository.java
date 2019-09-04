package br.com.learnmotion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learnmotion.models.Nivel;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {

}