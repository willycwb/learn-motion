package br.com.learnmotion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.learnmotion.models.Pessoa;

public interface TesteRepository extends JpaRepository<Pessoa, Long> {

}
