package br.com.learnmotion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learnmotion.models.SubConteudo;

@Repository
public interface SubConteudoRepository extends JpaRepository<SubConteudo, Long>{

}
