package br.com.learnmotion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learnmotion.models.TipoNivel;

@Repository
public interface TipoNivelRepository extends JpaRepository<TipoNivel, Long> {

}