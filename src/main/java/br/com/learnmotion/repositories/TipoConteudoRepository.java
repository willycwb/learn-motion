package br.com.learnmotion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learnmotion.models.TipoConteudo;

@Repository
public interface TipoConteudoRepository extends JpaRepository<TipoConteudo, Long>{

}
