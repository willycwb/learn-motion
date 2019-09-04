package br.com.learnmotion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learnmotion.models.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

}